package za.co.duartbreedt.androidconceptsreference

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.create
import za.co.duartbreedt.Data
import za.co.duartbreedt.androidconceptsreference.ktor.KtorFactory
import za.co.duartbreedt.androidconceptsreference.retrofit.DataService as RetrofitDataService
import za.co.duartbreedt.androidconceptsreference.ktor.DataService as KtorDataService
import za.co.duartbreedt.androidconceptsreference.retrofit.RetrofitFactory

class DataViewModel(application: Application): AndroidViewModel(application) {

    private val retrofitDataService: RetrofitDataService = RetrofitFactory.getInstance().create()
    private val ktorDataService: KtorDataService = KtorDataService(KtorFactory.getKtorClient())

    val liveData: LiveData<Data> = MutableLiveData()

    fun getDataWithRetrofit(id: String) {
        // Launch a coroutine
        viewModelScope.launch {
            // Post the data received from the API to the LiveData observable
            (liveData as MutableLiveData).postValue(retrofitDataService.getData(id).body())
        }
    }

    fun getDataWithKtor(id: String) {
        // Launch a coroutine
        viewModelScope.launch {
            // Post the data received from the API to the LiveData observable
            (liveData as MutableLiveData).postValue(ktorDataService.getData(id))
        }
    }
}