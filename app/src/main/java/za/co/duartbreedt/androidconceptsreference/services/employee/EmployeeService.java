package za.co.duartbreedt.androidconceptsreference.services.employee;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import za.co.duartbreedt.androidconceptsreference.services.employee.domain.EmployeeDTO;

public interface EmployeeService {

    @GET("users/{id}")
    Call<EmployeeDTO> getEmployee(@Path("id") int employeeId);

}
