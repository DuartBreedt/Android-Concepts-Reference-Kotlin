package za.co.duartbreedt.androidconceptsreference.mvp

import za.co.duartbreedt.androidconceptsreference.mvp.model.ProfileRepository
import za.co.duartbreedt.androidconceptsreference.mvp.model.domain.Profile

class ProfilePresenter(
    private val view: ProfileContract.View
) : ProfileContract.Presenter {

    private val model: ProfileRepository = ProfileRepository()

    override fun onFetchProfileClicked(profileId: Int) {

        view.showLoader()
        view.hideName()

        // Get data from the model
        model.getProfile(profileId) { profile: Profile ->

            // Set the relevant data on the view
            view.setName(profile.name)
            view.showName()
            view.hideLoader()
        }
    }

}