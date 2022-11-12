package za.co.duartbreedt.androidconceptsreference

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import za.co.duartbreedt.androidconceptsreference.databinding.ActivityMainBinding
import za.co.duartbreedt.androidconceptsreference.pusheen.PusheenDetailsActivity

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate layout
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
    }

    override fun onStart() {
        super.onStart()

        binding?.buttonPrimary?.setOnClickListener { onPrimaryButtonClicked() }
        setupMyCustomView()
    }

    override fun onDestroy() {
        super.onDestroy()

        binding = null
    }

    private fun setupMyCustomView() {

        binding?.myCustomView?.setPrimaryText("My Custom View")
        binding?.myCustomView?.setSecondaryText("Yay!")
    }

    private fun onPrimaryButtonClicked() {

        startActivity(Intent(this, PusheenDetailsActivity::class.java))
    }
}