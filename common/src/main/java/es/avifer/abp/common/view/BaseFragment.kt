package es.avifer.abp.common.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import es.avifer.abp.common.viewmodel.BaseViewModel

abstract class BaseFragment : Fragment() {

    abstract val viewModel: BaseViewModel

    open var binding: ViewBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = getInflateBinding(inflater, container)
        return binding?.root
    }

    abstract fun getInflateBinding(inflater: LayoutInflater, container: ViewGroup?): ViewBinding?

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }

}

fun BaseFragment.toast(
    @StringRes idString: Int,
    duration: Int = Toast.LENGTH_SHORT
) {
    Toast.makeText(
        requireContext(),
        getString(idString),
        duration
    ).show()
}

fun BaseFragment.openAppInGooglePlay() = (requireActivity() as? BaseActivity)?.openAppInGooglePlay()

fun BaseFragment.getVersionName() = (requireActivity() as? BaseActivity)?.versionName ?: ""