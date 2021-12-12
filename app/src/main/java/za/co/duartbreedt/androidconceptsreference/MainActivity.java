package za.co.duartbreedt.androidconceptsreference;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import za.co.duartbreedt.androidconceptsreference.calculator.CalculatorActivity;
import za.co.duartbreedt.androidconceptsreference.databinding.ActivityMainBinding;
import za.co.duartbreedt.androidconceptsreference.employee.EmployeeActivity;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private UsernameViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.i("BOOTCAMP", "MainActivity Created!");

        // Inflate layout
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        viewModel = new ViewModelProvider(this).get(UsernameViewModel.class);

        // Set data in the view model
        viewModel.setUsername("Hennie Brink");

        setContentView(binding.getRoot());
    }

    @Override
    protected void onStart() {
        super.onStart();

        binding.buttonGoToAnother.setOnClickListener(clickedView -> onGoToAnotherButtonClicked());
        binding.buttonCalculator.setOnClickListener(clickedView -> onCalculatorButtonClicked());
        binding.buttonEmployee.setOnClickListener(clickedView -> onEmployeeButtonClicked());
        binding.buttonIncrementer.setOnClickListener(clickedView -> onIncrementerButtonClicked());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.i("BOOTCAMP", "MainActivity destroyed!");
    }

    private void onGoToAnotherButtonClicked() {
        startActivity(new Intent(this, AnotherActivity.class));
    }

    private void onCalculatorButtonClicked() {
        startActivity(new Intent(this, CalculatorActivity.class));
    }

    private void onEmployeeButtonClicked() {
        startActivity(new Intent(this, EmployeeActivity.class));
    }

    private void onIncrementerButtonClicked() {
        startActivity(new Intent(this, IncrementerActivity.class));
    }
}