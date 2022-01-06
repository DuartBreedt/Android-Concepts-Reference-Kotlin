package za.co.duartbreedt.androidconceptsreference;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import za.co.duartbreedt.androidconceptsreference.databinding.ActivityMainBinding;
import za.co.duartbreedt.androidconceptsreference.databinding.ActivityNextBinding;

public class NextActivity extends AppCompatActivity {

    private ActivityNextBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNextBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}