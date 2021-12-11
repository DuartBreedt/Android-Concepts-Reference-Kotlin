package za.co.duartbreedt.androidconceptsreference.employee;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import retrofit2.Response;
import za.co.duartbreedt.androidconceptsreference.employee.domain.Employee;

public class EmployeeViewModel extends ViewModel {

    public MutableLiveData<Response<Employee>> employeeObservable = new MutableLiveData<>();
    private final EmployeeRepository repository = new EmployeeRepository();

    // Create service to run tasks (Runnable) off the UI Thread
    private final ExecutorService executor = new ThreadPoolExecutor(
        1,               // Minimum number of threads even if they are idling
        10,          // Max number of threads before throwing a RejectedExecutionException
        1000L,          // Time before killing idle threads
        TimeUnit.MILLISECONDS,      // Time unit for the above
        new LinkedBlockingQueue<>() // A queue to hold all the tasks (Runnables)
    );

    public void getEmployee(int employeeId) {

        // Create a new Runnable and execute it
        executor.execute(() -> {

            Response<Employee> employeeResponse = repository.getEmployee(employeeId);

            // Send result into the LiveData stream
            employeeObservable.postValue(employeeResponse);
        });
    }
}
