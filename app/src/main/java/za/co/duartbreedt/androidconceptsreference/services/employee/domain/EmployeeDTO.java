package za.co.duartbreedt.androidconceptsreference.services.employee.domain;

import java.io.Serializable;

public class EmployeeDTO implements Serializable {

    private EmployeeDataDTO data;

    public EmployeeDataDTO getData() {
        return data;
    }

    public void setData(EmployeeDataDTO data) {
        this.data = data;
    }
}
