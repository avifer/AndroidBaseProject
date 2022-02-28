package es.avifer.abp.feature.splash.ui.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import es.avifer.abp.common.util.runDelayMain
import es.avifer.abp.common.view.BaseFragment
import es.avifer.abp.feature.splash.R
import es.avifer.abp.feature.splash.databinding.FragmentSplashBinding
import es.avifer.abp.feature.splash.ui.viewmodel.SplashFragmentViewModel

class SplashFragment : BaseFragment() {

    companion object {
        private const val DELAY_SPLASH = 1500L
    }

    override val viewModel by viewModels<SplashFragmentViewModel>()

    override fun getBindingCast() = binding as? FragmentSplashBinding

    override fun getInflateBinding(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentSplashBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        runDelayMain(DELAY_SPLASH) {
            navigate(R.id.navigate_from_splash_feature_to_blockchain_feature)
        }
    }

}