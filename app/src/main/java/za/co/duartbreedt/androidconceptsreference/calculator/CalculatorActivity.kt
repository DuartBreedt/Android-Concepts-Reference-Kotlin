package za.co.duartbreedt.androidconceptsreference.calculator

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import za.co.duartbreedt.androidconceptsreference.R
import za.co.duartbreedt.androidconceptsreference.databinding.ActivityCalculatorBinding

class CalculatorActivity : AppCompatActivity() {

    private var binding: ActivityCalculatorBinding? = null
    private val viewModel: CalculatorViewModel by viewModels()

    private var resultObserver = Observer { result: Int ->

        // Format the result once it is returned
        val formattedResult = getString(R.string.calculatorActivity_resultFormat, result.toString())

        // Set the view to the formatted result
        binding?.textResult?.text = formattedResult
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCalculatorBinding.inflate(layoutInflater)

        setContentView(binding?.root)
    }

    override fun onStart() {
        super.onStart()

        // Start observing the LiveData object on the CalculatorViewModel
        viewModel.resultObservable.observe(this, resultObserver)

        // Setup click listener when "CALCULATE RESULT!" button is clicked
        binding?.buttonGetResult?.setOnClickListener { onGetResultButtonClicked() }
        binding?.buttonGetResultBadly?.setOnClickListener { onGetResultBadlyButtonClicked() }
    }

    override fun onStop() {
        super.onStop()

        // Stop observing the LiveData object on the CalculatorViewModel
        viewModel.resultObservable.removeObserver(resultObserver)
    }

    private fun onGetResultButtonClicked() {

        // Clear result field
        binding?.textResult?.setText(R.string.calculatorActivity_emptyResult)

        // Parse input as a number
        val numberInputString = binding?.editTextNumberInput?.text.toString().trim { it <= ' ' }
        val number = if (numberInputString.isEmpty()) 0 else numberInputString.toInt()

        viewModel.calculate(number)
    }

    private fun onGetResultBadlyButtonClicked() {

        // Clear result field
        binding?.textResult?.setText(R.string.calculatorActivity_emptyResult)

        // Parse input as a number
        val numberInputString = binding?.editTextNumberInput?.text.toString().trim { it <= ' ' }
        val number = if (numberInputString.isEmpty()) 0 else numberInputString.toInt()

        viewModel.calculateBadly(number)
    }
}