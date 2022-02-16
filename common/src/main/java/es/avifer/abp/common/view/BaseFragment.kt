package es.avifer.abp.common.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import es.avifer.abp.common.R
import es.avifer.abp.common.viewmodel.BaseViewModel

abstract class BaseFragment : Fragment() {

    abstract val viewModel: BaseViewModel

    open var binding: ViewBinding? = null

    abstract fun getBindingCast(): ViewBinding?

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = getInflateBinding(inflater, container)
        return binding?.root
    }

    abstract fun getInflateBinding(inflater: LayoutInflater, container: ViewGroup?): ViewBinding?

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initDefaultObserverWaiting()
        initDefaultObserverError()
    }

    open fun initDefaultObserverWaiting() {
        viewModel.defaultWaitingNotification.observe(viewLifecycleOwner) {
            it?.let {
                getHostActivity()?.visibilityLoading(it)
            } ?: kotlin.run { toast(R.string.default_error) }
        }
    }

    open fun initDefaultObserverError() {
        viewModel.defaultErrorNotification.observe(viewLifecycleOwner) {
            it?.let {
                toast(it)
            } ?: kotlin.run { toast(R.string.default_error) }
        }
    }

    private fun getHostActivity() = requireActivity() as? BaseActivity

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