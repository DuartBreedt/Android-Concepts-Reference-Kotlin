package za.co.duartbreedt.androidconceptsreference.mvp.model

import android.provider.Contacts
import kotlinx.coroutines.*
import za.co.duartbreedt.androidconceptsreference.mvp.ProfileContract
import za.co.duartbreedt.androidconceptsreference.mvp.model.domain.Profile

class ProfileRepository : ProfileContract.Model {

    override fun getProfile(profileId: Int, onComplete: (profile: Profile) -> Unit) {

        // Create an async job on the IO dispatcher
        val job = CoroutineScope(Job() + Dispatchers.IO)

        // Launch the async job
        job.launch {

            delay(1000L)

            // Get data and perform business logic
            val profile = Profile(1, "Slartibartfast")

            withContext(Dispatchers.Main) {
                // Call callback
                onComplete(profile)
            }
        }
    }
}