package com.japps.trendymovieskotlin.decoration

import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View
import com.japps.trendymovieskotlin.util.getPixelFromDimen

/**
 * Created by jsmirabal on 12/30/2017.
 */
class ItemOffsetDecoration(private var itemOffset: Int): RecyclerView.ItemDecoration() {

    init {
        itemOffset = getPixelFromDimen(itemOffset)
    }

    override fun getItemOffsets(outRect: Rect?, view: View?, parent: RecyclerView?, state: RecyclerView.State?) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect?.set(itemOffset, itemOffset, itemOffset, itemOffset)
    }
}