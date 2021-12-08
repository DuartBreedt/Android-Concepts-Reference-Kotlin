package za.co.duartbreedt.androidconceptsreference.employee;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import za.co.duartbreedt.androidconceptsreference.employee.domain.Employee;

public interface EmployeeService {

    @GET("users/{id}")
    Call<Employee> getEmployee(@Path("id") int employeeId);

}
