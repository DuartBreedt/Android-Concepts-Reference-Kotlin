package za.co.duartbreedt.androidconceptsreference.employee;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import retrofit2.Response;
import za.co.duartbreedt.androidconceptsreference.databinding.ActivityEmployeeBinding;
import za.co.duartbreedt.androidconceptsreference.employee.domain.Employee;

public class EmployeeActivity extends AppCompatActivity {

    private ActivityEmployeeBinding binding;
    private EmployeeViewModel viewModel;

    Observer<Response<Employee>> employeeObserver = (employeeResponse) -> {

        if(!employeeResponse.isSuccessful()) {

            // Handle HTTP error...

        } else {

            // Hide loader once data is returned
            binding.loader.setVisibility(View.GONE);

            // Show the employee's name once data is returned
            binding.textPrimary.setVisibility(View.VISIBLE);

            // Set the primary text to the returned employee's name
            String name = employeeResponse.body().getData().getFirstName() + " " + employeeResponse.body().getData().getLastName();
            binding.textPrimary.setText(name);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityEmployeeBinding.inflate(getLayoutInflater());

        viewModel = new ViewModelProvider(this).get(EmployeeViewModel.class);

        setContentView(binding.getRoot());
    }

    @Override
    protected void onStart() {
        super.onStart();

        // Start observing the LiveData object on the EmployeeViewModel
        viewModel.employeeObservable.observe(this, employeeObserver);

        // Setup click listener when "GET EMPLOYEE" button is clicked
        binding.buttonGetEmployee.setOnClickListener(clickedView -> onGetEmployeeButtonClicked());
    }

    @Override
    protected void onStop() {
        super.onStop();

        // Stop observing the LiveData object on the EmployeeViewModel
        viewModel.employeeObservable.removeObserver(employeeObserver);
    }

    private void onGetEmployeeButtonClicked() {

        // Show loader while data is loading
        binding.loader.setVisibility(View.VISIBLE);

        // Hide employee's name while data is loading
        binding.textPrimary.setVisibility(View.GONE);

        viewModel.getEmployee(1);
    }
}