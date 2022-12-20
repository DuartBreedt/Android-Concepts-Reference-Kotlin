package za.co.duartbreedt.androidconceptsreference.services.employee.domain

import com.google.gson.annotations.SerializedName

data class EmployeeData(
    val id: Int,
    val email: String,
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("last_name")
    val lastName: String,
    val avatar: String,
)