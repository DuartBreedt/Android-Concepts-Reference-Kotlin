package za.co.duartbreedt.androidconceptsreference.employee;

import static za.co.duartbreedt.androidconceptsreference.services.RetrofitClient.JSON_MEDIA_TYPE;

import android.util.Log;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import za.co.duartbreedt.androidconceptsreference.employee.domain.Employee;
import za.co.duartbreedt.androidconceptsreference.services.RetrofitClient;
import za.co.duartbreedt.androidconceptsreference.services.employee.EmployeeService;
import za.co.duartbreedt.androidconceptsreference.services.employee.domain.EmployeeDTO;

public class EmployeeRepository {

    private static final String tag = EmployeeRepository.class.getSimpleName();

    // Instantiate Retrofit client
    private final EmployeeService service = RetrofitClient.instance.create(EmployeeService.class);

    public Response<Employee> getEmployee(int employeeId) {

        // Make HTTP request
        Call<EmployeeDTO> getEmployeeCall = service.getEmployee(employeeId);

        try {

            // Prevent the loader from flashing if the response is too quick
            Thread.sleep(1000L);

            Response<EmployeeDTO> employeeResponse = getEmployeeCall.execute();

            if (!employeeResponse.isSuccessful() || employeeResponse.body() == null) {

                // Log real error response
                Log.e(tag, "Failed to retrieve employee: " + employeeResponse.code() + ": " + employeeResponse.message() + ": " + employeeResponse.errorBody());

                // Return friendly error response to apps
                return Response.error(404, ResponseBody.create(JSON_MEDIA_TYPE, "Oops! Something went wrong. Please try again later."));

            } else {

                // Convert DTO to domain model for the apps use
                Employee employee = new Employee(
                    employeeResponse.body().getData().getFirstName() + " " + employeeResponse.body().getData().getLastName()
                );

                // Return successful response
                return Response.success(employee);
            }

        } catch (InterruptedException | IOException exception) {

            // Log exception
            Log.e(tag, "Failed to retrieve employee: " + exception.getMessage(), exception);

            // Return friendly error response to apps
            return Response.error(404, ResponseBody.create(JSON_MEDIA_TYPE, "Oops! Something went wrong. Please try again later."));
        }
    }

}
