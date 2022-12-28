package za.co.duartbreedt.androidconceptsreference.mvp

import za.co.duartbreedt.androidconceptsreference.mvp.model.domain.Profile

interface ProfileContract {

    interface View {
        fun setName(name: String)
        fun hideName()
        fun showName()
        fun showLoader()
        fun hideLoader()
    }

    interface Model {
        fun getProfile(profileId: Int, onComplete: (profile: Profile) -> Unit)
    }

    interface Presenter {
        fun onFetchProfileClicked(profileId: Int)
    }
}