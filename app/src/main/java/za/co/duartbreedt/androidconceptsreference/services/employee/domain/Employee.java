package za.co.duartbreedt.androidconceptsreference.services.employee.domain;

import java.io.Serializable;

public class Employee implements Serializable {

    private EmployeeData data;

    public EmployeeData getData() {
        return data;
    }

    public void setData(EmployeeData data) {
        this.data = data;
    }
}
