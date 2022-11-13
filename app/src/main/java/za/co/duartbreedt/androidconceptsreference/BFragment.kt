package za.co.duartbreedt.androidconceptsreference

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import za.co.duartbreedt.androidconceptsreference.databinding.FragmentBBinding

class BFragment : Fragment() {

    companion object {
        private const val KEY_USERNAME = "usernameKey"
        private const val KEY_MESSAGE = "messageKey"

        // Method for creating safe arguments using language features over plugins
        @JvmStatic
        fun bundle(username: String?, message: String?): Bundle =
            Bundle().apply {
                putString(KEY_USERNAME, username)
                putString(KEY_MESSAGE, message)
            }
    }

    private var binding: FragmentBBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        binding = FragmentBBinding.inflate(inflater)

        return binding?.root
    }

    override fun onStart() {
        super.onStart()

        // Get the username stored in the bundle
        val username = arguments?.getString(KEY_USERNAME)
        val message = arguments?.getString(KEY_MESSAGE)

        // Set the secondary text to the stored username and message
        binding?.textSecondary?.text = "$username - $message"
    }

    override fun onDestroyView() {
        super.onDestroyView()

        binding = null
    }
}