package za.co.duartbreedt.androidconceptsreference

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation.findNavController
import za.co.duartbreedt.androidconceptsreference.databinding.FragmentFirstCheckoutBinding

class FirstCheckoutFragment : Fragment() {

    private var binding: FragmentFirstCheckoutBinding? = null
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        binding = FragmentFirstCheckoutBinding.inflate(inflater)

        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Get the nav controller instance which this view belongs to
        navController = findNavController(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()

        binding = null
    }
}