package za.co.duartbreedt.androidconceptsreference.domain.entities

data class Employee(val empID: String, val name: String, val ranking: Ranking);

enum class Ranking {
    COMMANDER,
    SERGEANT,
    LIEUTENANT,
    CORPORAL,
    PRIVATE
}