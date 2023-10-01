package za.co.duartbreedt.androidconceptsreference

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import za.co.duartbreedt.androidconceptsreference.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.i("BOOP", "onCreate ${savedInstanceState?.getString("BOOP")}")

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()

        Log.i("BOOP", "onStart")
    }

    override fun onResume() {
        super.onResume()

        Log.i("BOOP", "onResume")
    }

    override fun onPause() {
        super.onPause()

        Log.i("BOOP", "onPause")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString("BOOP", "Bye cruel world!")

        Log.i("BOOP", "onSaveInstanceState")

        super.onSaveInstanceState(outState)
    }

    override fun onStop() {
        super.onStop()

        Log.i("BOOP", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.i("BOOP", "onDestroy")
    }
}