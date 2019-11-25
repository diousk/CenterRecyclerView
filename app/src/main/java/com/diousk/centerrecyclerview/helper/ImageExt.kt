package com.diousk.centerrecyclerview.helper

import android.content.Context
import android.graphics.Bitmap
import android.renderscript.Allocation
import android.renderscript.Element
import android.renderscript.RenderScript
import android.renderscript.ScriptIntrinsicBlur
import android.opengl.ETC1.getHeight
import android.opengl.ETC1.getWidth



class ImageUtils(context: Context) {

    private var renderScript: RenderScript = RenderScript.create(context)

    fun gaussianBlur(radius:Int,original: Bitmap):Bitmap{
        val input = Allocation.createFromBitmap(renderScript,original)
        val output = Allocation.createTyped(renderScript,input.type)
        val scriptInterinsicBlur = ScriptIntrinsicBlur.create(renderScript, Element.U8_4(renderScript))
        scriptInterinsicBlur.setRadius(radius.toFloat())
        scriptInterinsicBlur.setInput(input)
        scriptInterinsicBlur.forEach(output)
        output.copyTo(original)
        return original
    }

    fun secondBlur(radius:Int, original: Bitmap): Bitmap {
        val outputBitmap = Bitmap.createBitmap(original)

        for (i in 0..9) {
            val input = Allocation.createFromBitmap(
                renderScript,
                outputBitmap
            ) //use this constructor for best performance, because it uses USAGE_SHARED mode which reuses memory
            val output = Allocation.createTyped(renderScript, input.type)
            val script = ScriptIntrinsicBlur.create(renderScript, Element.U8_4(renderScript))

            script.setRadius(25f)
            script.setInput(input)
            script.forEach(output)
            output.copyTo(outputBitmap)
        }
        return outputBitmap
    }
}