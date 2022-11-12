package za.co.duartbreedt.androidconceptsreference.pusheen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import za.co.duartbreedt.androidconceptsreference.databinding.ActivityPusheenDetailsBinding

class PusheenDetailsActivity : AppCompatActivity() {

    private var binding: ActivityPusheenDetailsBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPusheenDetailsBinding.inflate(layoutInflater)

        setContentView(binding?.root)
    }

    override fun onStart() {
        super.onStart()

        val pusheenNames: List<String> = listOf(
            "Vampire Pusheen",
            "Donut Pusheen",
            "Love Bird Pusheen",
            "Snac Pusheen",
            "Mask Pusheen",
            "Summer Pusheen",
            "Telephone Pusheen",
            "Cake Pusheen",
            "Scooter Pusheen",
            "Relax Pusheen",
            "Posh Pusheen",
            "UFO Pusheen",
            "Nessie Pusheen",
            "Nessie Pusheen",
            "Paris Pusheen",
            "Snuggle Pusheen",
            "Father Pusheen",
            "Pudding Pusheen",
            "Unicorn Pusheen",
            "Ducky Pusheen",
            "Bowtie Pusheen",
            "Knitting Pusheen",
            "Fishing Pusheen",
            "Harry Pusheen",
            "McDonalds Pusheen",
            "Pooping Pusheen",
            "Pizza Pusheen",
            "Christmas Sweater Pusheen",
            "Smors Pusheen",
            "Dragon Pusheen",
            "Icecream Pusheen"
        )

        setupPusheenRecyclerView(pusheenNames)
    }

    override fun onDestroy() {
        super.onDestroy()

        binding = null
    }

    private fun setupPusheenRecyclerView(pusheenNames: List<String>) {

        val adapter = PusheenAdapter(pusheenNames)

        binding?.pusheenRecyclerView?.adapter = adapter

        val layoutManager =
            LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)

        binding?.pusheenRecyclerView?.layoutManager = layoutManager
    }
}