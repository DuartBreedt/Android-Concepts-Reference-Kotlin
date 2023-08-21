package za.co.duartbreedt.androidconceptsreference.client.repository

import za.co.duartbreedt.androidconceptsreference.domain.entities.Employee
import za.co.duartbreedt.androidconceptsreference.domain.entities.Ranking
import za.co.duartbreedt.androidconceptsreference.domain.repository.IMyRepository

class MyRepository: IMyRepository {
    override fun getDeathStarEmployees(): Result<List<Employee>> {
        return Result.success(listOf(
            Employee("FLA347192", "Brandon Hunt", Ranking.CORPORAL),
            Employee("FLA971527", "Dennis Brown", Ranking.COMMANDER),
            Employee("LRG377702", "Eric Peterson", Ranking.PRIVATE),
            Employee("BVR002134", "Rachel McAdams", Ranking.PRIVATE),
            Employee("FLA234823", "Leroy Jenkins", Ranking.PRIVATE),
            Employee("LRG720122", "Naomi Black", Ranking.SERGEANT),
            Employee("BVR819284", "Nathan West", Ranking.CORPORAL),
            Employee("FLA233332", "Rick Astley", Ranking.LIEUTENANT),
        ))
    }

    override suspend fun getTatooineEmployees(): Result<List<Employee>> {
        return Result.success(listOf(
            Employee("FLA347192", "Brandon Hunt", Ranking.CORPORAL),
            Employee("FLA971527", "Dennis Brown", Ranking.COMMANDER),
            Employee("LRG377702", "Eric Peterson", Ranking.PRIVATE),
            Employee("BVR002134", "Rachel McAdams", Ranking.PRIVATE),
            Employee("FLA234823", "Leroy Jenkins", Ranking.PRIVATE),
            Employee("LRG720122", "Naomi Black", Ranking.SERGEANT),
            Employee("BVR819284", "Nathan West", Ranking.CORPORAL),
            Employee("FLA233332", "Rick Astley", Ranking.LIEUTENANT),
        ))
    }
}