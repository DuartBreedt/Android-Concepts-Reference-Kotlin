package za.co.duartbreedt.androidconceptsreference.employee

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import retrofit2.Response
import za.co.duartbreedt.androidconceptsreference.services.RetrofitClient
import za.co.duartbreedt.androidconceptsreference.services.employee.EmployeeService
import za.co.duartbreedt.androidconceptsreference.services.employee.domain.Employee

class EmployeeViewModel : ViewModel() {

    var employeeObservable = MutableLiveData<Employee?>()

    // Instantiate Retrofit client
    private val service = RetrofitClient.instance.create(EmployeeService::class.java)

    fun getEmployee(employeeId: Int) {

        // Create a new coroutine block
        viewModelScope.launch {

            try {

                // Prevent the loader from flashing if the response is too quick
                delay(1000L)

                // Make HTTP request
                val employeeResponse: Response<Employee> = service.getEmployee(employeeId)

                // Send result into the LiveData stream
                employeeObservable.postValue(employeeResponse.body())

            } catch (exception: Exception) {
                // Handle exceptions
                throw RuntimeException("Oops! Something went wrong!", exception)
            }
        }
    }
}