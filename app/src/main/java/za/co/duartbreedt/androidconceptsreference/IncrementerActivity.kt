package za.co.duartbreedt.androidconceptsreference

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import za.co.duartbreedt.androidconceptsreference.databinding.ActivityIncrementerBinding

/**
 * Example of Save Instance State
 */
class IncrementerActivity : AppCompatActivity() {

    companion object {
        // Unique Key for saving and retrieving counter data from bundles
        private const val KEY_COUNTER = "counterKey"
    }

    private var binding: ActivityIncrementerBinding? = null

    // Cached counter value
    private var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate layout
        binding = ActivityIncrementerBinding.inflate(layoutInflater)

        // Restore saved bundle data
        counter = savedInstanceState?.getInt(KEY_COUNTER, 0) ?: 0

        // Set view to restored data
        binding?.textCounter?.text = counter.toString()

        setContentView(binding?.root)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        // Save data to bundle upon destruction
        outState.putInt(KEY_COUNTER, counter)
    }

    override fun onStart() {
        super.onStart()
        binding?.buttonIncrement?.setOnClickListener { onIncrementButtonClicked() }
        binding?.buttonDecrement?.setOnClickListener { onDecrementButtonClicked() }
    }

    private fun onIncrementButtonClicked() {
        counter++
        binding?.textCounter?.text = counter.toString()
    }

    private fun onDecrementButtonClicked() {
        counter--
        binding?.textCounter?.text = counter.toString()
    }
}