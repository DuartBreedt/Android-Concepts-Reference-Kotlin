package za.co.duartbreedt.androidconceptsreference.services.employee

import retrofit2.Response
import retrofit2.http.*
import za.co.duartbreedt.androidconceptsreference.services.employee.domain.Employee

interface EmployeeService {

    @GET("users/{id}")
    suspend fun getEmployee(@Path("id") employeeId: Int): Response<Employee>

    @GET("users")
    suspend fun getEmployees(@Query("tenure") years: Int): Response<Employee>

    @POST("users")
    suspend fun createEmployee(@Body employee: Employee): Response<Employee>

    @PUT("users/{id}")
    suspend fun getEmployee(
        @Path("id") employeeId: Int,
        @Body employee: Employee
    ): Response<Employee>
}