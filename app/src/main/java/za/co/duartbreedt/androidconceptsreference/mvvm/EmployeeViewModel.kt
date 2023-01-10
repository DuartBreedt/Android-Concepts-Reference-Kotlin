package za.co.duartbreedt.androidconceptsreference.mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import za.co.duartbreedt.androidconceptsreference.mvvm.model.EmployeeRepository
import za.co.duartbreedt.androidconceptsreference.mvvm.model.domain.Employee

class EmployeeViewModel : ViewModel() {

    var employeeObservable = MutableLiveData<Employee?>()

    // Instantiate Retrofit client
    private val repository = EmployeeRepository()

    fun getEmployee(employeeId: Int) {

        // Create a new coroutine block
        viewModelScope.launch {

            // Prevent the loader from flashing if the response is too quick
            delay(1000L)

            val employeeResponse: Employee = repository.getEmployee(employeeId)

            // Send result into the LiveData stream
            employeeObservable.postValue(employeeResponse)
        }
    }
}