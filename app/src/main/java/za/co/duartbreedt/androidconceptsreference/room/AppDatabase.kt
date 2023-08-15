package za.co.duartbreedt.androidconceptsreference.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [
        User::class,
        Plant::class
    ], version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    abstract fun plantDao(): PlantDao
}