package za.co.duartbreedt.androidconceptsreference;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import za.co.duartbreedt.androidconceptsreference.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    // TODO: Custom View
    // TODO: Explicit inflation for a fragment
    // TODO: Recycler view

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    @Override
    protected void onStart() {
        super.onStart();

        binding.buttonNavigateToRecyclerActivity.setOnClickListener(clickedView -> navigateToRecyclerActivity());
    }

    private void navigateToRecyclerActivity() {
        startActivity(new Intent(this, RecyclerActivity.class));
    }
}