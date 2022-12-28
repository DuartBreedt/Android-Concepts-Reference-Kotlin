package za.co.duartbreedt.androidconceptsreference.mvvm

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import za.co.duartbreedt.androidconceptsreference.databinding.ActivityEmployeeBinding
import za.co.duartbreedt.androidconceptsreference.mvvm.model.domain.Employee

class EmployeeActivity : AppCompatActivity() {

    private var binding: ActivityEmployeeBinding? = null
    private val viewModel: EmployeeViewModel by viewModels()

    private var employeeObserver = Observer { employeeResponse: Employee ->

        // Hide loader once data is returned
        binding?.loader?.visibility = View.GONE

        // Show the employee's name once data is returned
        binding?.textPrimary?.visibility = View.VISIBLE

        // Set the primary text to the returned employee's name
        val name = employeeResponse.data.firstName + " " + employeeResponse.data.lastName
        binding?.textPrimary?.text = name
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate layout
        binding = ActivityEmployeeBinding.inflate(layoutInflater)

        setContentView(binding?.root)
    }

    override fun onStart() {
        super.onStart()

        // Start observing the LiveData object on the EmployeeViewModel
        viewModel.employeeObservable.observe(this, employeeObserver)

        // Setup click listener when "GET EMPLOYEE" button is clicked
        binding?.buttonGetEmployee?.setOnClickListener { onGetEmployeeButtonClicked() }
    }

    override fun onStop() {
        super.onStop()

        // Stop observing the LiveData object on the EmployeeViewModel
        viewModel.employeeObservable.removeObserver(employeeObserver)
    }

    private fun onGetEmployeeButtonClicked() {

        // Show loader while data is loading
        binding?.loader?.visibility = View.VISIBLE

        // Hide employee's name while data is loading
        binding?.textPrimary?.visibility = View.GONE
        viewModel.getEmployee(1)
    }
}