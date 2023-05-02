package es.avifer.abp.feature.blockchain.ui.view.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.StringRes
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import es.avifer.abp.common.extensions.toFormatTwoDecimal
import es.avifer.abp.common.view.BaseFragment
import es.avifer.abp.domain.entities.blockchain.CryptoBo
import es.avifer.abp.feature.blockchain.R
import es.avifer.abp.feature.blockchain.databinding.FragmentHomeBinding
import es.avifer.abp.feature.blockchain.ui.viewmodel.HomeFragmentViewModel

@AndroidEntryPoint
class HomeFragment : BaseFragment() {

    companion object {
        private const val BTC_USD = "BTC-USD"
    }

    override val viewModel by viewModels<HomeFragmentViewModel>()

    override fun getInflateBinding(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentHomeBinding.inflate(inflater, container, false)


    /*
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

     */

    private fun FragmentHomeBinding.setDataCrypto(cryptoBo: CryptoBo) {
        setNameCrypto(cryptoBo.name)
        setRemotePrice(cryptoBo.priceOnline, R.string.icon_dolar)
        setLocalPrice(cryptoBo.priceOffline, R.string.icon_dolar)
    }

    private fun FragmentHomeBinding.setLocalPrice(price: Double?, @StringRes idIconMoney: Int) {
        fragmentHomeLabelLocalPriceEdit.text =
            getString(idIconMoney, price?.toFormatTwoDecimal())
    }

    private fun FragmentHomeBinding.setRemotePrice(price: Double?, @StringRes idIconMoney: Int) {
        fragmentHomeLabelOnlinePriceEdit.text =
            getString(idIconMoney, price?.toFormatTwoDecimal())
    }

    private fun FragmentHomeBinding.setNameCrypto(name: String) {
        fragmentHomeLabelNameCrypto.text = name
    }

}