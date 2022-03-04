package es.avifer.abp.feature.splash.ui.viewmodel


import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.ktx.remoteConfig
import es.avifer.abp.common.extensions.needForceUpdate
import es.avifer.abp.common.util.runDelayMain
import es.avifer.abp.common.viewmodel.BaseViewModel
import es.avifer.abp.feature.splash.ui.view.fragment.SplashFragmentDirections


class SplashFragmentViewModel : BaseViewModel() {

    companion object {
        private const val DELAY_SPLASH = 1500L
    }

    fun goToBlockchain(versionName: String, updateApp: () -> Unit) {
        with(Firebase.remoteConfig) {
            fetchAndActivate().addOnCompleteListener {
                if (it.isSuccessful && needForceUpdate(versionName)) {
                    updateApp()

                } else {
                    runDelayMain(DELAY_SPLASH) {
                        navigate(SplashFragmentDirections.navigateFromSplashFeatureToBlockchainFeature())
                    }
                }

            }
        }
    }
}