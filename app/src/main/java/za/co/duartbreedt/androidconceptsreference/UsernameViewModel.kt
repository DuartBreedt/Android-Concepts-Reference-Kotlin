package za.co.duartbreedt.androidconceptsreference

import android.util.Log
import androidx.lifecycle.ViewModel

class UsernameViewModel : ViewModel() {

    var username = "NO_USERNAME"

    init {
        Log.i("BOOTCAMP", "The UsernameViewModel was created!")
    }

    override fun onCleared() {
        super.onCleared()

        Log.i("BOOTCAMP", "The UsernameViewModel was cleared!")
    }
}