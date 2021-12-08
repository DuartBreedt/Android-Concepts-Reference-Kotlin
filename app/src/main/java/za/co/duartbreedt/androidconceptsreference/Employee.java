package za.co.duartbreedt.androidconceptsreference;

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
