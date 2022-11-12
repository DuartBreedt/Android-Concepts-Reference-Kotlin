package za.co.duartbreedt.androidconceptsreference;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import za.co.duartbreedt.androidconceptsreference.databinding.FragmentMyBinding;

public class MyFragment extends Fragment {

    private FragmentMyBinding binding;
    // TODO use delegate. Show what the vanilla implementation might look like for equivalent delegate differences
    private UsernameViewModel viewModel;

    // Fragments HAVE to have an empty constructor
    public MyFragment() {
        super(R.layout.fragment_my);
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // If the owner is set to `this` then the VM won't be the same as the one created in the activity.
        //  Instead, a new instance will be created.
        // Replace `requireActivity()` with `this` and observe the logs
        viewModel = new ViewModelProvider(requireActivity()).get(UsernameViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // Inflate layout
        binding = FragmentMyBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    @Override
    public void onStart() {
        super.onStart();

        binding.textPrimary.setText(viewModel.getUsername());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        // Always dispose of your bindings if you are caching them!
        binding = null;
    }
}