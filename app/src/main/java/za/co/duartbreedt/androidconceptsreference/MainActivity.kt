package za.co.duartbreedt.androidconceptsreference

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import kotlinx.coroutines.launch
import za.co.duartbreedt.androidconceptsreference.databinding.ActivityMainBinding
import za.co.duartbreedt.androidconceptsreference.room.AppDatabase
import za.co.duartbreedt.androidconceptsreference.room.User

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "my-app-database"
        ).build()

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()

        // Create Entity
        val userOne = User(firstName = "Crentist", lastName = "The Dentist")

        // Instantiate DAO
        val userDao = db.userDao()

        lifecycleScope.launch { // coroutine on Main

            // Insert entities
            userDao.insertAll(userOne)

            // Get all User entities in the DB
            val users: List<User> = userDao.getAll()

            // Update UI with all User entities
            binding.users.text = users.joinToString { "${it.firstName} ${it.lastName}" }
        }
    }
}