package za.co.duartbreedt.androidconceptsreference

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import za.co.duartbreedt.androidconceptsreference.databinding.ActivityMainBinding
import za.co.duartbreedt.androidconceptsreference.explicitintents.EmailListActivity
import za.co.duartbreedt.androidconceptsreference.fragmentcarousel.FragmentCarouselActivity
import za.co.duartbreedt.androidconceptsreference.mvp.ProfileActivity
import za.co.duartbreedt.androidconceptsreference.mvvm.EmployeeActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()

        binding.buttonEmployee.setOnClickListener { onEmployeeButtonClicked() }
        binding.buttonProfile.setOnClickListener { onProfileButtonClicked() }
        binding.buttonEmailList.setOnClickListener { onEmailListButtonClicked() }
        binding.buttonContact.setOnClickListener { onContactButtonClicked() }
        binding.buttonFragmentCarousel.setOnClickListener { onFragmentCarouselButtonClicked() }
    }

    private fun onEmployeeButtonClicked() {
        startActivity(Intent(this, EmployeeActivity::class.java))
    }

    private fun onProfileButtonClicked() {
        startActivity(Intent(this, ProfileActivity::class.java))
    }

    private fun onEmailListButtonClicked() {
        startActivity(Intent(this, EmailListActivity::class.java))
    }

    private fun onContactButtonClicked() {

        val intent = Intent()
        intent.action = Intent.ACTION_DIAL
        intent.data = Uri.parse("tel:0123456789")

        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }

    private fun onFragmentCarouselButtonClicked() {
        startActivity(Intent(this, FragmentCarouselActivity::class.java))
    }
}