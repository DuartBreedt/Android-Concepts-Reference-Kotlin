package za.co.duartbreedt.androidconceptsreference.fragmentcarousel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import za.co.duartbreedt.androidconceptsreference.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    companion object {

        fun newInstance(): SecondFragment {
            return SecondFragment()
        }
    }

    private var binding: FragmentSecondBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSecondBinding.inflate(inflater)

        return binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()

        binding = null
    }

}