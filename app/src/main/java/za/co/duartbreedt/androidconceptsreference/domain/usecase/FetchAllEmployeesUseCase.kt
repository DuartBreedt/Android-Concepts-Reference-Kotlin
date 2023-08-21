package za.co.duartbreedt.androidconceptsreference.domain.usecase

import za.co.duartbreedt.androidconceptsreference.domain.entities.Employee
import za.co.duartbreedt.androidconceptsreference.domain.entities.Ranking
import za.co.duartbreedt.androidconceptsreference.domain.repository.IMyRepository

interface IFetchAllEmployeesUseCase {
    fun fetchAllEmployees(): Result<List<Employee>>
    fun fetchEmployeesByRank(ranking: Ranking): Result<List<Employee>>
    suspend fun fetchEmployeesOnTatooine(): Result<List<Employee>>
}

class FetchAllEmployeesUseCase(private val repository: IMyRepository): IFetchAllEmployeesUseCase {
    override fun fetchAllEmployees(): Result<List<Employee>> {
        val result = repository.getDeathStarEmployees()
        return if (result.isSuccess) {
            result.getOrNull()
                ?.sortedBy { it.name }
                ?.let { Result.success(it) }
                ?: Result.failure(Throwable("Null Result"))
        } else {
            result
        }
    }

    override fun fetchEmployeesByRank(ranking: Ranking): Result<List<Employee>> {
        val result = repository.getDeathStarEmployees()
        return if (result.isSuccess) {
            result.getOrNull()
                ?.filter { it.ranking == ranking }
                ?.let { Result.success(it) }
                ?: Result.failure(Throwable("Null Result"))
        } else {
            result
        }
    }

    override suspend fun fetchEmployeesOnTatooine(): Result<List<Employee>> {
        return repository.getTatooineEmployees()
    }
}