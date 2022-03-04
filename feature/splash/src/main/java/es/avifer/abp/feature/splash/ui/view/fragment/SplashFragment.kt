package es.avifer.abp.feature.splash.ui.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import es.avifer.abp.common.view.BaseFragment
import es.avifer.abp.common.view.getVersionName
import es.avifer.abp.common.view.openAppInGooglePlay
import es.avifer.abp.feature.splash.databinding.FragmentSplashBinding
import es.avifer.abp.feature.splash.ui.viewmodel.SplashFragmentViewModel

class SplashFragment : BaseFragment() {

    override val viewModel by viewModels<SplashFragmentViewModel>()

    override fun getBindingCast() = binding as? FragmentSplashBinding

    override fun getInflateBinding(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentSplashBinding.inflate(inflater, container, false)

    override fun onViewReady(savedInstanceState: Bundle?) {
        viewModel.goToBlockchain(getVersionName()) { openAppInGooglePlay() }
    }

}