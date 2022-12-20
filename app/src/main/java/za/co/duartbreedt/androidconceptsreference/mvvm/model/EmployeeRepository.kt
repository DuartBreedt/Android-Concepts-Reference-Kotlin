package za.co.duartbreedt.androidconceptsreference.mvvm.model

import za.co.duartbreedt.androidconceptsreference.services.employee.domain.Employee
import za.co.duartbreedt.androidconceptsreference.services.employee.domain.EmployeeData

class EmployeeRepository {

    fun getEmployee(employeeId: Int): Employee {
        return Employee(EmployeeData(1, "", "", "", ""))
    }

}