package za.co.duartbreedt.androidconceptsreference

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import za.co.duartbreedt.androidconceptsreference.calculator.CalculatorActivity
import za.co.duartbreedt.androidconceptsreference.databinding.ActivityMainBinding
import za.co.duartbreedt.androidconceptsreference.employee.EmployeeActivity


class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null
    private lateinit var viewModel: UsernameViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.i("BOOTCAMP", "MainActivity Created!")

        // Inflate layout
        binding = ActivityMainBinding.inflate(layoutInflater)

        /**
         * Vanilla way to create view models
         * Note:You can also use a lazy block with this instantiation in
         */
        viewModel = ViewModelProvider(this)[UsernameViewModel::class.java]

        // Set data in the view model
        viewModel.username = "Hennie Brink"

        setContentView(binding!!.root)
    }

    override fun onStart() {
        super.onStart()

        binding?.buttonGoToAnother?.setOnClickListener { onGoToAnotherButtonClicked() }
        binding?.buttonCalculator?.setOnClickListener { onCalculatorButtonClicked() }
        binding?.buttonEmployee?.setOnClickListener { onEmployeeButtonClicked() }
        binding?.buttonIncrementer?.setOnClickListener { onIncrementerButtonClicked() }
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.i("BOOTCAMP", "MainActivity destroyed!")

        binding = null
    }

    private fun onGoToAnotherButtonClicked() {
        startActivity(Intent(this, AnotherActivity::class.java))
    }

    private fun onCalculatorButtonClicked() {
        startActivity(Intent(this, CalculatorActivity::class.java))
    }

    private fun onEmployeeButtonClicked() {
        startActivity(Intent(this, EmployeeActivity::class.java))
    }

    private fun onIncrementerButtonClicked() {
        startActivity(Intent(this, IncrementerActivity::class.java))
    }
}