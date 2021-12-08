package za.co.duartbreedt.androidconceptsreference;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import za.co.duartbreedt.androidconceptsreference.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        // Set data in the view model
        viewModel.setUsername("Hennie Brink");

        setContentView(binding.getRoot());
    }
}