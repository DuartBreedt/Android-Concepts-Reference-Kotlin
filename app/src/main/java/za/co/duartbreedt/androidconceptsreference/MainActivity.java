package za.co.duartbreedt.androidconceptsreference;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import za.co.duartbreedt.androidconceptsreference.databinding.ActivityMainBinding;
import za.co.duartbreedt.androidconceptsreference.pusheen.PusheenDetailsActivity;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inflate layout
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    @Override
    protected void onStart() {
        super.onStart();

        binding.buttonPrimary.setOnClickListener(clickedView -> onPrimaryButtonClicked());

        setupMyCustomView();
    }

    private void setupMyCustomView() {
        binding.myCustomView.setPrimaryText("My Custom View");
        binding.myCustomView.setSecondaryText("Yay!");
    }

    private void onPrimaryButtonClicked() {
        startActivity(new Intent(this, PusheenDetailsActivity.class));
    }
}