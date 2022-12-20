package za.co.duartbreedt.androidconceptsreference

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import za.co.duartbreedt.androidconceptsreference.databinding.ActivityMainBinding
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
    }

    private fun onEmployeeButtonClicked() {
        startActivity(Intent(this, EmployeeActivity::class.java))
    }

    private fun onProfileButtonClicked() {
        startActivity(Intent(this, ProfileActivity::class.java))
    }
}