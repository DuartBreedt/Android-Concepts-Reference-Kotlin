package za.co.duartbreedt.androidconceptsreference.fragmentcarousel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import za.co.duartbreedt.androidconceptsreference.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    companion object {

        fun newInstance(): FirstFragment {
            return FirstFragment()
        }
    }

    private var binding: FragmentFirstBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentFirstBinding.inflate(inflater)

        return binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()

        binding = null
    }

}