package za.co.duartbreedt.androidconceptsreference.fragmentcarousel

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import za.co.duartbreedt.androidconceptsreference.R
import za.co.duartbreedt.androidconceptsreference.databinding.ActivityFragmentCarouselBinding

class FragmentCarouselActivity : AppCompatActivity() {

    private var binding: ActivityFragmentCarouselBinding? = null

    // Holds all the possible fragments we can navigate to
    // Dictionary of fragment class names and the fragment instance
    private val fragmentList: MutableList<Pair<String, Fragment>> = mutableListOf()

    // The currently active fragment
    private var currentFragmentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate layout
        binding = ActivityFragmentCarouselBinding.inflate(layoutInflater)

        setContentView(binding?.root)

        populateFragmentList()

        binding?.buttonNextFragment?.setOnClickListener { layOutNextFragment() }
    }

    override fun onStart() {
        super.onStart()

        layOutNextFragment()
    }

    private fun layOutNextFragment() {
        val currentFragmentPair: Pair<String, Fragment> =
            fragmentList[currentFragmentIndex % fragmentList.size]

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, currentFragmentPair.second, currentFragmentPair.first)
            .addToBackStack(currentFragmentPair.first)
            .commit()

        currentFragmentIndex++
    }

    private fun populateFragmentList() {
        fragmentList.addAll(
            listOf(
                FirstFragment::class.java.name to FirstFragment.newInstance(),
                SecondFragment::class.java.name to SecondFragment.newInstance()
            )
        )
    }
}