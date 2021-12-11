package za.co.duartbreedt.androidconceptsreference.employee;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import retrofit2.Call;
import retrofit2.Response;
import za.co.duartbreedt.androidconceptsreference.services.RetrofitClient;
import za.co.duartbreedt.androidconceptsreference.services.employee.EmployeeService;
import za.co.duartbreedt.androidconceptsreference.services.employee.domain.Employee;

public class EmployeeViewModel extends ViewModel {

    public MutableLiveData<Employee> employeeObservable = new MutableLiveData<>();

    // Instantiate Retrofit client
    private final EmployeeService service = RetrofitClient.instance.create(EmployeeService.class);

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
            // Make HTTP request
            Call<Employee> getEmployeeCall = service.getEmployee(employeeId);

            try {

                // Prevent the loader from flashing if the response is too quick
                Thread.sleep(1000L);

                Response<Employee> employeeResponse = getEmployeeCall.execute();

                // Send result into the LiveData stream
                employeeObservable.postValue(employeeResponse.body());
            } catch (InterruptedException | IOException exception) {

                // Handle exceptions
                throw new RuntimeException("Oops! Something went wrong!", exception);
            }
        });
    }
}
