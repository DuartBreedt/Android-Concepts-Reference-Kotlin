package za.co.duartbreedt.androidconceptsreference

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import za.co.duartbreedt.androidconceptsreference.databinding.FragmentMyBinding

// Fragments HAVE to have an empty constructor
class MyFragment : Fragment(R.layout.fragment_my) {

    private var binding: FragmentMyBinding? = null


    // activityViewModels delegate makes the activity which this fragment is in the owner of the VM
    //  If the alternative ViewModels delegate is used then the owner of the activity is this fragment.
    //  This results in the VM not being the same as the one created in the activity instead a new instance will be created.
    private val viewModel: UsernameViewModel by activityViewModels()

    // With a plain vanilla instantiation of the VM the same thing can be achieved by assigning either the activity or this fragment as the VM owner.
    //  As seen below:
    // override fun onCreate(savedInstanceState: Bundle?) {
    //     super.onCreate(savedInstanceState)
    //
    //     // Will get a handle to the VM created by the activity
    //     viewModel = ViewModelProvider(requireActivity())[UsernameViewModel::class.java]
    //     // Will instantiated a brand new UsernameViewModel where this fragment is the owner
    //     viewModel = ViewModelProvider(this)[UsernameViewModel::class.java]
    // }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate layout
        binding = FragmentMyBinding.inflate(inflater, container, false)

        return binding?.root
    }

    override fun onStart() {
        super.onStart()
        binding?.textPrimary?.text = viewModel.username
    }

    override fun onDestroyView() {
        super.onDestroyView()

        // Always dispose of your bindings if you are caching them!
        binding = null
    }
}