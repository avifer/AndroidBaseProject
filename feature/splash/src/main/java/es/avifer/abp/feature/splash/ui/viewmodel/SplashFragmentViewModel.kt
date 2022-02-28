package es.avifer.abp.feature.splash.ui.viewmodel

import es.avifer.abp.common.util.runDelayMain
import es.avifer.abp.common.viewmodel.BaseViewModel
import es.avifer.abp.feature.splash.ui.view.fragment.SplashFragmentDirections

class SplashFragmentViewModel : BaseViewModel() {

    companion object {
        private const val DELAY_SPLASH = 1500L
    }

    fun goToBlockchain() {
        runDelayMain(DELAY_SPLASH) {
            navigate(SplashFragmentDirections.navigateFromSplashFeatureToBlockchainFeature())
        }
    }

}