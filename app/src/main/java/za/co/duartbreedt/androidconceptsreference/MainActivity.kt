package za.co.duartbreedt.androidconceptsreference

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import za.co.duartbreedt.androidconceptsreference.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
    }

    override fun onDestroy() {
        super.onDestroy()

        binding = null
    }
}