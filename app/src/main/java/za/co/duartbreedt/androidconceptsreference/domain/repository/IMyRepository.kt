package za.co.duartbreedt.androidconceptsreference.domain.repository

import za.co.duartbreedt.androidconceptsreference.domain.entities.Employee

interface IMyRepository {
   fun getDeathStarEmployees(): Result<List<Employee>>
   suspend fun getTatooineEmployees(): Result<List<Employee>>
}