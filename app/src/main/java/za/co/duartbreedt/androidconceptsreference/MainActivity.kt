package za.co.duartbreedt.androidconceptsreference

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import za.co.duartbreedt.Data
import za.co.duartbreedt.androidconceptsreference.databinding.ActivityMainBinding

class MainActivity : ComponentActivity() {

    private lateinit var binding: ActivityMainBinding

    private val dataViewModel: DataViewModel by viewModels()

    private val dataObserver = Observer<Data> {
        // do something with the data
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
    }

    fun getDataWithRetrofit(id: String) {
        // Observe the LiveData
        dataViewModel.liveData.observe(this, dataObserver)

        // Call the function to retrieve data from the API
        dataViewModel.getDataWithRetrofit(id)
    }

    fun getDataWithKtor(id: String) {
        // Observe the LiveData
        dataViewModel.liveData.observe(this, dataObserver)

        // Call the function to retrieve data from the API
        dataViewModel.getDataWithKtor(id)
    }
}