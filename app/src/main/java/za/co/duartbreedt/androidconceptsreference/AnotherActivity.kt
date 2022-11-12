package za.co.duartbreedt.androidconceptsreference

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import za.co.duartbreedt.androidconceptsreference.databinding.ActivityAnotherBinding

class AnotherActivity : AppCompatActivity() {

    private var binding: ActivityAnotherBinding? = null

    private val viewModel: UsernameViewModel by lazy {
        ViewModelProvider(this)[UsernameViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.i("BOOTCAMP", "AnotherActivity Created!")

        // Inflate layout
        binding = ActivityAnotherBinding.inflate(layoutInflater)

        setContentView(binding?.root)
    }

    override fun onStart() {
        super.onStart()
        binding?.textPrimary?.text = viewModel.username
    }

    override fun onStop() {
        super.onStop()

        Log.i("BOOTCAMP", "AnotherActivity stopped!")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.i("BOOTCAMP", "AnotherActivity destroyed!")
    }
}