package za.co.duartbreedt.androidconceptsreference;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import za.co.duartbreedt.androidconceptsreference.databinding.ActivityAnotherBinding;

public class AnotherActivity extends AppCompatActivity {

    private ActivityAnotherBinding binding;
    // TODO Use lazy?
    private UsernameViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.i("BOOTCAMP", "AnotherActivity Created!");

        // Inflate layout
        binding = ActivityAnotherBinding.inflate(getLayoutInflater());

        viewModel = new ViewModelProvider(this).get(UsernameViewModel.class);

        setContentView(binding.getRoot());
    }

    @Override
    protected void onStart() {
        super.onStart();

        binding.textPrimary.setText(viewModel.getUsername());
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.i("BOOTCAMP", "AnotherActivity stopped!");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.i("BOOTCAMP", "AnotherActivity destroyed!");
    }
}