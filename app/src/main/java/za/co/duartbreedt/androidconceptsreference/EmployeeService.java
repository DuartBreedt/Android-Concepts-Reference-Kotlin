package za.co.duartbreedt.androidconceptsreference;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface EmployeeService {

    @GET("users/{id}")
    Call<Employee> getEmployee(@Path("id") int employeeId);

}
