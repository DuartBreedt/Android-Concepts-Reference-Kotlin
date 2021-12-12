package za.co.duartbreedt.androidconceptsreference;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import za.co.duartbreedt.androidconceptsreference.databinding.ActivityIncrementerBinding;

public class IncrementerActivity extends AppCompatActivity {

    private ActivityIncrementerBinding binding;

    // Unique Key for saving and retrieving counter data from bundles
    private final static String KEY_COUNTER = "counterKey";

    // Cached counter value
    private int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inflate layout
        binding = ActivityIncrementerBinding.inflate(getLayoutInflater());

        // Restore saved bundle data
        if (savedInstanceState == null) {
            counter = 0;
        } else {
            counter = savedInstanceState.getInt(KEY_COUNTER, 0);
        }

        // Set view to restored data
        binding.textCounter.setText(String.valueOf(counter));

        setContentView(binding.getRoot());
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        // Save data to bundle upon destruction
        outState.putInt(KEY_COUNTER, counter);
    }

    @Override
    protected void onStart() {
        super.onStart();

        binding.buttonIncrement.setOnClickListener(clickedView -> onIncrementButtonClicked());
        binding.buttonDecrement.setOnClickListener(clickedView -> onDecrementButtonClicked());
    }

    private void onIncrementButtonClicked() {
        counter++;
        binding.textCounter.setText(String.valueOf(counter));
    }

    private void onDecrementButtonClicked() {
        counter--;
        binding.textCounter.setText(String.valueOf(counter));
    }
}