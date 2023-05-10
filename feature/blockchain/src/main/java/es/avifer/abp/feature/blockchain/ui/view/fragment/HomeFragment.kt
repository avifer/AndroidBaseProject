package es.avifer.abp.feature.blockchain.ui.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import es.avifer.abp.common.view.BaseFragment
import es.avifer.abp.feature.blockchain.R
import es.avifer.abp.feature.blockchain.databinding.FragmentHomeBinding
import es.avifer.abp.feature.blockchain.ui.viewmodel.HomeFragmentViewModel

@AndroidEntryPoint
class HomeFragment : BaseFragment() {

    override val viewModel by viewModels<HomeFragmentViewModel>()
    private val adapterList = AdapterList()

    override fun getBindingCast() = binding as? FragmentHomeBinding

    override fun getInflateBinding(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentHomeBinding.inflate(inflater, container, false)

    override fun onViewReady(savedInstanceState: Bundle?) {
        getBindingCast()?.fragmentHomeList?.adapter = adapterList
        adapterList.submitList(
            mutableListOf(
                ListElementVO("Contactos", R.drawable.baseline_person_24),
                ListElementVO("Lectura", R.drawable.baseline_menu_book_24),
                ListElementVO("Espacios", R.drawable.baseline_photo_24),
                ListElementVO("Etiquetaje", R.drawable.baseline_beenhere_24),
                ListElementVO("GPS", R.drawable.baseline_location_on_24),
                ListElementVO("Configuracion", R.drawable.baseline_settings_24),
            )
        )
    }

}