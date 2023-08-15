package za.co.duartbreedt.androidconceptsreference.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// If `tableName` property is not set then the table will be named "User"
@Entity
data class User(

    @PrimaryKey(autoGenerate = true) val id: Int = 0,

    @ColumnInfo(name = "first_name")
    val firstName: String,

    @ColumnInfo(name = "last_name")
    val lastName: String
)
