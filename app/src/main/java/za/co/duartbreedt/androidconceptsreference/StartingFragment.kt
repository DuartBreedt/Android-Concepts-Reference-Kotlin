package za.co.duartbreedt.androidconceptsreference

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.Navigation.findNavController
import za.co.duartbreedt.androidconceptsreference.databinding.FragmentStartingBinding

class StartingFragment : Fragment() {

    private var binding: FragmentStartingBinding? = null

    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        binding = FragmentStartingBinding.inflate(inflater)

        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Get the nav controller instance which this view belongs to
        navController = findNavController(view)
    }

    override fun onStart() {
        super.onStart()

        // Without args
        binding?.buttonToFragmentANoArgs?.setOnClickListener {

            // Navigate to Fragment A using the action declared in the Nav Graph
            navController.navigate(R.id.action_startingFragment_to_fragmentA)
        }

        // With args
        binding?.buttonToFragmentAArgs?.setOnClickListener {

            /*
             * Navigate to Fragment A using the action declared in the Nav Graph
             * Navigate with arguments using SafeArgs' generated directions
             */
            val directions: NavDirections =
                StartingFragmentDirections.actionStartingFragmentToFragmentA("Doc", "Great Scott!")

            navController.navigate(directions)
        }

        binding?.buttonToSecondActivity?.setOnClickListener{
            navController.navigate(R.id.secondActivity)
        }

        binding?.buttonToCheckout?.setOnClickListener{
            navController.navigate(R.id.checkout_nav_graph)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()

        binding = null
    }
}