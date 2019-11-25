package com.diousk.centerrecyclerview.view

import android.view.View
import android.widget.ImageView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.bumptech.glide.Glide
import com.diousk.centerrecyclerview.R
import com.diousk.centerrecyclerview.data.Album
import com.diousk.centerrecyclerview.helper.KotlinEpoxyHolder

@EpoxyModelClass(layout = R.layout.view_holder_item)
abstract class ImageHolder : EpoxyModelWithHolder<ImageHolder.ViewHolder>() {
    @EpoxyAttribute
    lateinit var album: Album

    @EpoxyAttribute(EpoxyAttribute.Option.DoNotHash)
    lateinit var listener: (Album) -> Unit

    override fun bind(holder: ViewHolder) {
        Glide.with(holder.itemPhoto).load(album.resourceId).into(holder.itemPhoto)
        holder.container.setOnClickListener { listener.invoke(album) }
    }

    override fun unbind(holder: ViewHolder) {
        holder.container.setOnClickListener(null)
    }

    class ViewHolder : KotlinEpoxyHolder() {
        val container by bind<View>(R.id.itemContainer)
        val itemPhoto by bind<ImageView>(R.id.itemPhoto)
    }
}