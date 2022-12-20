package za.co.duartbreedt.androidconceptsreference.mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import retrofit2.Response
import za.co.duartbreedt.androidconceptsreference.mvvm.model.EmployeeRepository
import za.co.duartbreedt.androidconceptsreference.services.employee.domain.Employee

class EmployeeViewModel : ViewModel() {

    var employeeObservable = MutableLiveData<Employee?>()

    // Instantiate Retrofit client
    private val repository = EmployeeRepository()

    fun getEmployee(employeeId: Int) {

        // Create a new coroutine block
        viewModelScope.launch {

            try {

                // Prevent the loader from flashing if the response is too quick
                delay(1000L)

                val employeeResponse: Employee = repository.getEmployee(employeeId)

                // Send result into the LiveData stream
                employeeObservable.postValue(employeeResponse)

            } catch (exception: Exception) {
                // Handle exceptions
                throw RuntimeException("Oops! Something went wrong!", exception)
            }
        }
    }
}