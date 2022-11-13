package za.co.duartbreedt.androidconceptsreference

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation.findNavController
import za.co.duartbreedt.androidconceptsreference.BFragment.Companion.bundle
import za.co.duartbreedt.androidconceptsreference.databinding.FragmentABinding

class AFragment : Fragment() {

    private var binding: FragmentABinding? = null
    private lateinit var navController: NavController

    private var username = ""
    private var message = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        binding = FragmentABinding.inflate(inflater)

        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Get the nav controller instance which this view belongs to
        navController = findNavController(view)
    }

    override fun onStart() {
        super.onStart()

        // Get the username stored in the bundle by SafeArgs
        username = AFragmentArgs.fromBundle(arguments).username

        // Get the message stored in the bundle by SafeArgs
        message = AFragmentArgs.fromBundle(arguments).message

        // Set the secondary text to the stored username and message
        binding?.textSecondary?.text = "$username - $message"

        // Without args
        binding?.buttonToFragmentBNoArgs?.setOnClickListener {

            // Navigate to Fragment B using the fragment ID declared in the Nav Graph
            navController.navigate(R.id.fragmentB)
        }

        // With args
        binding?.buttonToFragmentBArgs?.setOnClickListener {

            /*
             * Navigate to Fragment B using the fragment ID declared in the Nav Graph
             * Navigate with arguments using language features instead of SafeArgs
             */
            navController.navigate(R.id.fragmentB, bundle(username, message))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()

        binding = null
    }
}