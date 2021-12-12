package za.co.duartbreedt.androidconceptsreference.services.employee;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import za.co.duartbreedt.androidconceptsreference.services.employee.domain.Employee;

public interface EmployeeService {

    @GET("users/{id}")
    Call<Employee> getEmployee(@Path("id") int employeeId);

    @GET("users")
    Call<Employee> getEmployees(@Query("tenure") int years);

    @POST("users")
    Call<Employee> createEmployee(@Body Employee employee);

    @PUT("users/{id}")
    Call<Employee> getEmployee(
        @Path("id") int employeeId,
        @Body Employee employee
    );
}
