package es.avifer.abp.feature.blockchain.ui.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import es.avifer.abp.common.extensions.toFormatTwoDecimal
import es.avifer.abp.common.view.BaseFragment
import es.avifer.abp.common.view.toast
import es.avifer.abp.domain.entities.blockchain.CryptoBo
import es.avifer.abp.domain.entities.response.getStringError
import es.avifer.abp.feature.blockchain.R
import es.avifer.abp.feature.blockchain.databinding.FragmentHomeBinding
import es.avifer.abp.feature.blockchain.ui.viewmodel.HomeFragmentViewModel

@AndroidEntryPoint
class HomeFragment : BaseFragment() {

    companion object {
        private const val BTC_USD = "BTC-USD"
    }

    override val viewModel by viewModels<HomeFragmentViewModel>()

    override fun getBindingCast() = binding as? FragmentHomeBinding

    override fun getInflateBinding(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentHomeBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getPriceBtc()
        configureSwipeRefresh()
    }

    private fun configureSwipeRefresh() {
        getBindingCast()?.fragmentHomeSwipeRefresh?.setOnRefreshListener {
            viewModel.getDataCryptoListeners(
                cryptoPair = BTC_USD,
                successful = { it?.let { crypto -> getBindingCast()?.setDataCrypto(crypto) } },
                error = { toast(it.getStringError()) },
                loading = { getBindingCast()?.fragmentHomeSwipeRefresh?.isRefreshing = it }
            )
        }
    }

    private fun getPriceBtc() {
        viewModel.getDataCrypto(BTC_USD).observe(viewLifecycleOwner) { result ->
            result?.let { crypto ->
                getBindingCast()?.setDataCrypto(crypto)
            }
        }
    }

    private fun FragmentHomeBinding.setDataCrypto(cryptoBo: CryptoBo) {
        setNameCrypto(cryptoBo.name)
        setRemotePrice(cryptoBo.priceOnline)
        setLocalPrice(cryptoBo.priceOffline)
    }

    private fun FragmentHomeBinding.setLocalPrice(price: Double?) {
        fragmentHomeLabelLocalPriceEdit.text =
            getString(R.string.icon_money, price?.toFormatTwoDecimal())
    }

    private fun FragmentHomeBinding.setRemotePrice(price: Double?) {
        fragmentHomeLabelOnlinePriceEdit.text =
            getString(R.string.icon_money, price?.toFormatTwoDecimal())
    }

    private fun FragmentHomeBinding.setNameCrypto(name: String) {
        fragmentHomeLabelNameCrypto.text = name
    }

}