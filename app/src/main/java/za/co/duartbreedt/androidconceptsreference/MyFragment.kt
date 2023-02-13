package za.co.duartbreedt.androidconceptsreference

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import za.co.duartbreedt.androidconceptsreference.databinding.FragmentMyBinding

class MyFragment : Fragment() {

    private var binding: FragmentMyBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate layout
        binding = FragmentMyBinding.inflate(inflater, container, false)

        // Create text view programmatically
        val newTextView = TextView(requireContext())
        newTextView.text = "A programmatically created view in my fragment..."

        // Set the width and height
        val layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        newTextView.layoutParams = layoutParams

        // Add it to the view hierarchy
        binding?.myFragmentRootView?.addView(newTextView)

        return binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()

        // Always dispose of your bindings if you are caching them on Fragments!
        // Fragments outlive their views
        binding = null
    }
}