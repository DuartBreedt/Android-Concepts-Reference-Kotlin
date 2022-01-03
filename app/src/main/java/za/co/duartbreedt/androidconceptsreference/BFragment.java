package za.co.duartbreedt.androidconceptsreference;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import za.co.duartbreedt.androidconceptsreference.databinding.FragmentBBinding;


public class BFragment extends Fragment {

    private FragmentBBinding binding;

    private static final String KEY_USERNAME = "usernameKey";
    private static final String KEY_MESSAGE = "messageKey";

    // Method for creating safe arguments using language features over plugins
    public static Bundle bundle(String username, String message) {
        Bundle bundle = new Bundle();

        bundle.putString(KEY_USERNAME, username);
        bundle.putString(KEY_MESSAGE, message);

        return bundle;
    }

    public BFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        binding = FragmentBBinding.inflate(inflater);

        return binding.getRoot();
    }

    @Override
    public void onStart() {
        super.onStart();

        // Ensure there were arguments passed in
        if (getArguments() != null) {

            // Get the username stored in the bundle
            String username = getArguments().getString(KEY_USERNAME);
            String message = getArguments().getString(KEY_MESSAGE);

            // Set the secondary text to the stored username and message
            binding.textSecondary.setText(username + " - " + message);
        }
    }
}