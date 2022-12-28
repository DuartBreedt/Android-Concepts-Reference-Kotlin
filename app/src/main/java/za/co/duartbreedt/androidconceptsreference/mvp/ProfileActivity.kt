package za.co.duartbreedt.androidconceptsreference.mvp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import za.co.duartbreedt.androidconceptsreference.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity(), ProfileContract.View {

    private var binding: ActivityProfileBinding? = null
    private val presenter: ProfileContract.Presenter = ProfilePresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate layout
        binding = ActivityProfileBinding.inflate(layoutInflater)

        setContentView(binding?.root)
    }

    override fun onStart() {
        super.onStart()

        binding?.buttonGetProfile?.setOnClickListener {
            presenter.onFetchProfileClicked(1)
        }
    }

    override fun setName(name: String) {
        binding?.textPrimary?.text = name
    }

    override fun hideName() {
        binding?.textPrimary?.isVisible = false
    }

    override fun showName() {
        binding?.textPrimary?.isVisible = true
    }

    override fun showLoader() {
        binding?.loader?.isVisible = true
    }

    override fun hideLoader() {
        binding?.loader?.isVisible = false
    }
}