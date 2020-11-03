package com.alimonapps.onlinelibrary.ui.audio

import com.alimonapps.onlinelibrary.R
import com.alimonapps.onlinelibrary.databinding.ItemAudioBinding
import com.alimonapps.onlinelibrary.datamodel.bestpodcast.Podcast
import com.xwray.groupie.databinding.BindableItem

class AudioListItem(private val item: Podcast, val clickHandler: (item: Podcast) -> Unit) :
    BindableItem<ItemAudioBinding>() {

    override fun getLayout(): Int {
        return R.layout.item_audio
    }


    override fun bind(viewBinding: ItemAudioBinding, position: Int) {
        viewBinding.item = item
        viewBinding.root.setOnClickListener {
            clickHandler(item)
        }
    }


}
