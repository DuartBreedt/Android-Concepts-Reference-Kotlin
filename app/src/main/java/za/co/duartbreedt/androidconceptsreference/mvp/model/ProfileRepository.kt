package za.co.duartbreedt.androidconceptsreference.mvp.model

import kotlinx.coroutines.*
import za.co.duartbreedt.androidconceptsreference.mvp.ProfileContract
import za.co.duartbreedt.androidconceptsreference.mvp.model.domain.Profile

class ProfileRepository : ProfileContract.Model {

    override fun getProfile(profileId: Int, onComplete: (profile: Profile) -> Unit) {

        // Start async scope on the IO dispatcher
        CoroutineScope(Job() + Dispatchers.IO).launch {

            delay(1000L)

            // Get data and perform business logic
            val profile = Profile(1, "")

            // Call callback
            onComplete(profile)
        }
    }
}