package za.co.duartbreedt.androidconceptsreference;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import za.co.duartbreedt.androidconceptsreference.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private UsernameViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.i("BOOTCAMP", "MainActivity Created!");

        binding = ActivityMainBinding.inflate(getLayoutInflater());

        viewModel = new ViewModelProvider(this).get(UsernameViewModel.class);

        // Set data in the view model
        viewModel.setUsername("Hennie Brink");

        setContentView(binding.getRoot());
    }

    @Override
    protected void onStart() {
        super.onStart();

        binding.buttonPrimary.setOnClickListener(clickedView -> onPrimaryButtonClicked());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.i("BOOTCAMP", "MainActivity destroyed!");
    }

    private void onPrimaryButtonClicked() {
        startActivity(new Intent(this, AnotherActivity.class));
    }
}