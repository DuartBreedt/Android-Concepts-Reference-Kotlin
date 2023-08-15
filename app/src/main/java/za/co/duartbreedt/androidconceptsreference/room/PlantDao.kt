package za.co.duartbreedt.androidconceptsreference.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update

@Dao
interface PlantDao {

    @Update
    suspend fun updateAll(vararg plants: Plant)

    @Insert
    suspend fun insertAll(vararg plants: Plant)

    @Delete
    suspend fun delete(plant: Plant)
}
