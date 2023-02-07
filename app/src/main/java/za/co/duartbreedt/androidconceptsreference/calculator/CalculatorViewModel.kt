package za.co.duartbreedt.androidconceptsreference.calculator

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*

class CalculatorViewModel : ViewModel() {

    var resultObservable = MutableLiveData<Int>()

    fun calculate(number: Int) {

        // Create a new coroutine and execute it
        viewModelScope.launch {

            val result = giveMeThisNumberBackButSlower(number)

            // Send result into the LiveData stream
            resultObservable.postValue(result)
        }
    }

    fun calculateBadly(number: Int) = runBlocking{
        launch(Dispatchers.Main) {
            val result = giveMeThisNumberBackButSlower(number)

            // Send result into the LiveData stream
            resultObservable.postValue(result)
        }
    }

    private suspend fun giveMeThisNumberBackButSlower(n: Int): Int {
        delay(n * 1000L)
        return n
    }
}