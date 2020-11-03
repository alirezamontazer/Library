package com.alimonapps.onlinelibrary.ui.book

import com.alimonapps.onlinelibrary.R
import com.alimonapps.onlinelibrary.databinding.ItemBookBinding
import com.alimonapps.onlinelibrary.datamodel.allbooks.Item
import com.alimonapps.onlinelibrary.datamodel.allbooks.VolumeInfo
import com.xwray.groupie.databinding.BindableItem

class BookListItem(private val item: Item, val clickHandler: (item: VolumeInfo) -> Unit) :
    BindableItem<ItemBookBinding>() {

    override fun getLayout(): Int {
        return R.layout.item_book
    }


    override fun bind(viewBinding: ItemBookBinding, position: Int) {
        viewBinding.item = item.volumeInfo
        viewBinding.root.setOnClickListener {
            item.volumeInfo?.let { it1 -> clickHandler(it1) }
        }
    }


}
