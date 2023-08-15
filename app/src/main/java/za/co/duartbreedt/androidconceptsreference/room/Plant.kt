package za.co.duartbreedt.androidconceptsreference.room

import androidx.room.Entity
import androidx.room.Ignore

// Composite primary Key
@Entity(tableName = "plants", primaryKeys = ["genus", "species"])
data class Plant(

    val genus: String,

    val species: String,

    @Ignore val selected: Boolean
)
