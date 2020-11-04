package com.alimonapps.onlinelibrary.ui.discover

import com.alimonapps.onlinelibrary.R
import com.alimonapps.onlinelibrary.databinding.ItemAudioSearchBinding
import com.alimonapps.onlinelibrary.datamodel.searchaudio.Result
import com.xwray.groupie.databinding.BindableItem

class AudioSearchItem(private val item: Result, val clickHandler: (item: Result) -> Unit) :
    BindableItem<ItemAudioSearchBinding>() {

    override fun getLayout(): Int {
        return R.layout.item_audio_search
    }

    override fun bind(viewBinding: ItemAudioSearchBinding, position: Int) {
        viewBinding.searchItem = item
        viewBinding.root.setOnClickListener {
            clickHandler(item)
        }
    }

}
