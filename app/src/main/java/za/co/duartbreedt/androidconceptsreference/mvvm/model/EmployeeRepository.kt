package za.co.duartbreedt.androidconceptsreference.mvvm.model

import za.co.duartbreedt.androidconceptsreference.mvvm.model.domain.Employee
import za.co.duartbreedt.androidconceptsreference.mvvm.model.domain.EmployeeData

class EmployeeRepository {

    fun getEmployee(employeeId: Int): Employee {

        // Business logic

        // Return data
        return Employee(EmployeeData(1, "donkey.kong@gmail.com", "Donkey", "Kong", ""))
    }

}