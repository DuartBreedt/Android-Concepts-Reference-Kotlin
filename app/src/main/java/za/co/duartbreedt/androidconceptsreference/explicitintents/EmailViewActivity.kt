package za.co.duartbreedt.androidconceptsreference.explicitintents

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import za.co.duartbreedt.androidconceptsreference.databinding.ActivityEmailViewBinding

class EmailViewActivity : AppCompatActivity() {

    private var binding: ActivityEmailViewBinding? = null

    companion object {

        private const val EXTRA_EMAIL_ID = "EXTRA_EMAIL_ID"

        fun newIntent(context: Context, emailId: Int): Intent {

            val emailViewIntent: Intent = Intent(context, EmailViewActivity::class.java).apply {
                putExtra(EXTRA_EMAIL_ID, emailId)
            }

            return emailViewIntent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate layout
        binding = ActivityEmailViewBinding.inflate(layoutInflater)

        setContentView(binding?.root)

        val activityArguments: Bundle? = intent.extras
        val emailId: Int? = activityArguments?.getInt(EXTRA_EMAIL_ID)
    }
}