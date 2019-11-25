package com.diousk.centerrecyclerview.helper

import com.airbnb.epoxy.TypedEpoxyController
import com.diousk.centerrecyclerview.data.Album
import com.diousk.centerrecyclerview.view.imageHolder

class ImageController (
    private val callback: Callback
): TypedEpoxyController<List<Album>>() {

    interface Callback {
        fun onImageClick(album: Album, position: Int)
    }

    override fun buildModels(data: List<Album>?) {
        data?.forEachIndexed { index, album ->
            imageHolder {
                id(album.albumName)
                album(album)
                listener { callback.onImageClick(album, index) }
            }
        }
    }
}