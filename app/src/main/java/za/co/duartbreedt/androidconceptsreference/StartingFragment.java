package za.co.duartbreedt.androidconceptsreference;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import za.co.duartbreedt.androidconceptsreference.databinding.FragmentStartingBinding;


public class StartingFragment extends Fragment {

    private FragmentStartingBinding binding;
    private NavController navController;

    public StartingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        binding = FragmentStartingBinding.inflate(inflater);

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

        // Without args
        binding.buttonToFragmentANoArgs.setOnClickListener((View v) -> {

            // Navigate to Fragment A using the action declared in the Nav Graph
            navController.navigate(R.id.action_startingFragment_to_fragmentA);
        });

        // With args
        binding.buttonToFragmentAArgs.setOnClickListener((View v) -> {

            /*
             * Navigate to Fragment A using the action declared in the Nav Graph
             * Navigate with arguments using SafeArgs' generated directions
             */

            NavDirections directions =
                StartingFragmentDirections.actionStartingFragmentToFragmentA("Doc", "Great Scott!");

            navController.navigate(directions);
        });
    }
}