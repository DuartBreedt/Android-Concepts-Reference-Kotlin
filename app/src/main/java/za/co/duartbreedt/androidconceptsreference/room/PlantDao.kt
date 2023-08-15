package za.co.duartbreedt.androidconceptsreference.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update

@Dao
interface PlantDao {

    @Update
    fun updateAll(vararg plants: Plant)

    @Insert
    fun insertAll(vararg plants: Plant)

    @Delete
    fun delete(plant: Plant)
}
