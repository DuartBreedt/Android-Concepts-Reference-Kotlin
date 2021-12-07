package za.co.duartbreedt.androidconceptsreference;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import za.co.duartbreedt.androidconceptsreference.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}