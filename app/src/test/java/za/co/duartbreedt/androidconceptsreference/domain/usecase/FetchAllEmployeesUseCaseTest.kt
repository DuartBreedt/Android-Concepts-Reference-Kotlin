package za.co.duartbreedt.androidconceptsreference.domain.usecase

import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import za.co.duartbreedt.androidconceptsreference.domain.entities.Employee
import za.co.duartbreedt.androidconceptsreference.domain.entities.Ranking
import za.co.duartbreedt.androidconceptsreference.domain.repository.IMyRepository

class FetchAllEmployeesUseCaseTest {
    private val mockRepository = mockk<IMyRepository>()
    private lateinit var useCase: IFetchAllEmployeesUseCase

    @Before
    fun setUp() {
        useCase = FetchAllEmployeesUseCase(mockRepository)
    }

    @Test
    fun fetchAllEmployeesSortsEmployeesByNameInAscendingOrder() {
        every { mockRepository.getDeathStarEmployees() } returns Result.success(employeeList)

        val result = useCase.fetchAllEmployees()

        verify(exactly = 1) { mockRepository.getDeathStarEmployees() }
        Assert.assertEquals(sortedEmployeeList, result.getOrNull())
    }

    @Test
    fun fetchAllEmployeesReturnsFailureIfRepositoryReturnsFailure() {
        every { mockRepository.getDeathStarEmployees() } returns Result.failure(mockThrowable)

        val result = useCase.fetchAllEmployees()

        verify(exactly = 1) { mockRepository.getDeathStarEmployees() }
        Assert.assertTrue(result.isFailure)
        Assert.assertEquals(mockThrowable, result.exceptionOrNull())
    }

    @Test
    fun fetchEmployeesByRankFiltersEmployeesWithSpecifiedRank() {
        every { mockRepository.getDeathStarEmployees() } returns Result.success(employeeList)

        val result = useCase.fetchEmployeesByRank(Ranking.LIEUTENANT)

        Assert.assertEquals(listOf(employeeList[3]), result.getOrNull())
    }

    @Test
    fun fetchEmployeesByRankReturnsFailureIfRepositoryReturnsFailure() {
        every { mockRepository.getDeathStarEmployees() } returns Result.failure(mockThrowable)

        val result = useCase.fetchEmployeesByRank(Ranking.LIEUTENANT)

        verify(exactly = 1) { mockRepository.getDeathStarEmployees() }
        Assert.assertTrue(result.isFailure)
        Assert.assertEquals(mockThrowable, result.exceptionOrNull())
    }

    @Test
    fun fetchTatooineEmployeesReturnsSuccessWhenRepositoryReturnsSuccess() {
        coEvery { mockRepository.getTatooineEmployees() } returns Result.success(employeeList)

        val result = runBlocking { useCase.fetchEmployeesOnTatooine() }

        Assert.assertEquals(employeeList, result.getOrNull())
    }

    companion object {
        var mockThrowable = Throwable("Error Occurred")
        var employeeList = listOf(
            Employee("FLA347192", "Peter Hargreeves", Ranking.CORPORAL),
            Employee("FLA971527", "Manny DelRoy", Ranking.COMMANDER),
            Employee("BVR819284", "Benny", Ranking.CORPORAL),
            Employee("FLA233332", "Lacey Grahams", Ranking.LIEUTENANT)
        )
        var sortedEmployeeList = listOf(
            Employee("BVR819284", "Benny", Ranking.CORPORAL),
            Employee("FLA233332", "Lacey Grahams", Ranking.LIEUTENANT),
            Employee("FLA971527", "Manny DelRoy", Ranking.COMMANDER),
            Employee("FLA347192", "Peter Hargreeves", Ranking.CORPORAL)
        )
    }
}