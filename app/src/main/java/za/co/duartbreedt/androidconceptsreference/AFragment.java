package za.co.duartbreedt.androidconceptsreference;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import za.co.duartbreedt.androidconceptsreference.databinding.FragmentABinding;


public class AFragment extends Fragment {

    private FragmentABinding binding;
    private NavController navController;

    private String username = "";
    private String message = "";

    public AFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        binding = FragmentABinding.inflate(inflater);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Get the nav controller instance which this view belongs to
        navController = Navigation.findNavController(view);
    }

    @Override
    public void onStart() {
        super.onStart();

        // Ensure there were arguments passed in
        if (getArguments() != null) {

            // Get the username stored in the bundle by SafeArgs
            username = AFragmentArgs.fromBundle(getArguments()).getUSERNAME();

            // Get the message stored in the bundle by SafeArgs
            message = AFragmentArgs.fromBundle(getArguments()).getMESSAGE();
        }

        // Set the secondary text to the stored username and message
        binding.textSecondary.setText(username + " - " + message);

        // Without args
        binding.buttonToFragmentBNoArgs.setOnClickListener((View v) -> {

            // Navigate to Fragment B using the fragment ID declared in the Nav Graph
            navController.navigate(R.id.fragmentB);
        });

        // With args
        binding.buttonToFragmentBArgs.setOnClickListener((View v) -> {

            /*
             * Navigate to Fragment B using the fragment ID declared in the Nav Graph
             * Navigate with arguments using language features instead of SafeArgs
             */
            navController.navigate(R.id.fragmentB, BFragment.bundle(username, message));
        });

    }
}