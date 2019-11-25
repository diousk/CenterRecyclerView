package com.diousk.centerrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearSnapHelper
import com.bumptech.glide.Glide
import com.diousk.centerrecyclerview.data.Album
import com.diousk.centerrecyclerview.data.Data
import com.diousk.centerrecyclerview.helper.ImageController
import com.diousk.centerrecyclerview.helper.ItemDecoration
import com.diousk.centerrecyclerview.helper.ScrollListener
import com.diousk.centerrecyclerview.helper.ImageUtils
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ImageController.Callback, ScrollListener.Callback {

    private val controller by lazy {
        ImageController(this)
    }

    private val dataList by lazy {
        Data.getAlbumDatabase()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvImages.setController(controller)
        rvImages.addItemDecoration(ItemDecoration())
        val snapHelper = LinearSnapHelper()
        rvImages.addOnScrollListener(
            ScrollListener(
                snapHelper,
                this
            )
        )
        snapHelper.attachToRecyclerView(rvImages)
        controller.setData(dataList)
    }

    override fun onImageClick(album: Album, position: Int) {
        rvImages.smoothScrollToPosition(position)
    }

    override fun onPositionChanged(position: Int) {
        Log.d("Main", "onPositionChanged $position")
        val album = dataList[position]
        val disposable = Single.fromCallable {
            val bitmap = Glide.with(this).asBitmap().load(album.resourceId).submit().get()
            ImageUtils(this).secondBlur(25, bitmap)
        }
            .subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe ({
                imgBackground.setImageBitmap(it)
            }, {

            })
    }
}
