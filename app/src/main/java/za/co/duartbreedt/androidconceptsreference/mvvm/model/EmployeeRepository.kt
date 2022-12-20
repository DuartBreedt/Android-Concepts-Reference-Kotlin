package za.co.duartbreedt.androidconceptsreference.mvvm.model

import za.co.duartbreedt.androidconceptsreference.services.employee.domain.Employee
import za.co.duartbreedt.androidconceptsreference.services.employee.domain.EmployeeData

class EmployeeRepository {

    suspend fun getEmployee(employeeId: Int): Employee {

        // Business logic

        return Employee(EmployeeData(1, "", "", "", ""))
    }

}