package za.co.duartbreedt.androidconceptsreference;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import za.co.duartbreedt.androidconceptsreference.databinding.FragmentMyBinding;

public class MyFragment extends Fragment {

    private FragmentMyBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // Inflate layout
        binding = FragmentMyBinding.inflate(inflater, container, false);

        // Create text view programmatically
        TextView newTextView = new TextView(requireContext());

        newTextView.setText("A programmatically created view in my fragment...");

        // Set the width and height
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        );
        newTextView.setLayoutParams(layoutParams);

        // Add it to the view hierarchy
        binding.myFragmentRootView.addView(newTextView);

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        // Always dispose of your bindings if you are caching them on Fragments!
        // Fragments outlive their views
        binding = null;
    }
}