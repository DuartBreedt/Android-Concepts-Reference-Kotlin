package za.co.duartbreedt.androidconceptsreference.fragmentcarousel

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import za.co.duartbreedt.androidconceptsreference.R
import za.co.duartbreedt.androidconceptsreference.databinding.ActivityFragmentCarouselBinding

class FragmentCarouselActivity : AppCompatActivity() {

    private var binding: ActivityFragmentCarouselBinding? = null

    private val fragmentList: MutableList<Pair<String, Fragment>> = mutableListOf()
    private var currentFragmentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate layout
        binding = ActivityFragmentCarouselBinding.inflate(layoutInflater)

        setContentView(binding?.root)

        populateFragmentList()

        binding?.buttonNextFragment?.setOnClickListener { layoutNextFragment() }
    }

    override fun onStart() {
        super.onStart()

        layoutNextFragment()
    }

    private fun layoutNextFragment() {
        val currentFragmentPair = fragmentList[currentFragmentIndex % fragmentList.size]

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