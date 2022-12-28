package za.co.duartbreedt.androidconceptsreference.explicitintents

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import za.co.duartbreedt.androidconceptsreference.databinding.ActivityEmailListBinding

class EmailListActivity : AppCompatActivity() {

    private var binding: ActivityEmailListBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate layout
        binding = ActivityEmailListBinding.inflate(layoutInflater)

        setContentView(binding?.root)

        binding?.buttonViewEmail?.setOnClickListener {
            onEmailTap(1)
        }
    }

    private fun onEmailTap(emailId: Int) {
        val intent: Intent = EmailViewActivity.newIntent(this, emailId)
        startActivity(intent)
    }
}