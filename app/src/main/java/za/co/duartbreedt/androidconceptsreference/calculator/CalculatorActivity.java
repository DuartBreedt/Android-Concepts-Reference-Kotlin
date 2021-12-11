package za.co.duartbreedt.androidconceptsreference.calculator;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import za.co.duartbreedt.androidconceptsreference.R;
import za.co.duartbreedt.androidconceptsreference.databinding.ActivityCalculatorBinding;

public class CalculatorActivity extends AppCompatActivity {

    private ActivityCalculatorBinding binding;
    private CalculatorViewModel viewModel;

    Observer<Integer> resultObserver = (result) -> {

        // Format the result once it is returned
        String formattedResult = getString(R.string.calculatorActivity_resultFormat, result.toString());

        // Set the view to the formatted result
        binding.textResult.setText(formattedResult);
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityCalculatorBinding.inflate(getLayoutInflater());

        viewModel = new ViewModelProvider(this).get(CalculatorViewModel.class);

        setContentView(binding.getRoot());
    }

    @Override
    protected void onStart() {
        super.onStart();

        // Start observing the LiveData object on the CalculatorViewModel
        viewModel.resultObservable.observe(this, resultObserver);

        // Setup click listener when "CALCULATE RESULT!" button is clicked
        binding.buttonGetResult.setOnClickListener(clickedView -> onGetResultButtonClicked());
    }

    @Override
    protected void onStop() {
        super.onStop();

        // Stop observing the LiveData object on the CalculatorViewModel
        viewModel.resultObservable.removeObserver(resultObserver);
    }

    private void onGetResultButtonClicked() {

        // Clear result field
        binding.textResult.setText(R.string.calculatorActivity_emptyResult);

        // Parse input as a number
        String numberInputString = binding.editTextNumberInput.getText().toString().trim();
        int number = numberInputString.isEmpty() ? 0 : Integer.parseInt(numberInputString);

        viewModel.calculate(number);
    }
}