package es.avifer.abp.feature.blockchain.ui.view.fragment

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import es.avifer.abp.feature.blockchain.R
import es.avifer.abp.feature.blockchain.databinding.ViewListHomeBinding

class AdapterList : ListAdapter<ListElementVO, AdapterList.ViewHolderFavoriteCategory>(diffUtils) {

    class ViewHolderFavoriteCategory(private val viewBinding: ViewListHomeBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {

        @SuppressLint("ResourceAsColor")
        fun bind(category: ListElementVO) {
            with(viewBinding) {
                imagenTexto.setImageResource(category.image)
                textoTitulo.text = category.title
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolderFavoriteCategory, position: Int) =
        holder.bind(currentList[position])

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderFavoriteCategory {
        return ViewHolderFavoriteCategory(
            ViewListHomeBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
}

private val diffUtils = object : DiffUtil.ItemCallback<ListElementVO>() {
    override fun areItemsTheSame(
        oldItem: ListElementVO,
        newItem: ListElementVO
    ) = oldItem.title == newItem.title

    override fun areContentsTheSame(
        oldItem: ListElementVO,
        newItem: ListElementVO
    ) = oldItem.title == newItem.title
}