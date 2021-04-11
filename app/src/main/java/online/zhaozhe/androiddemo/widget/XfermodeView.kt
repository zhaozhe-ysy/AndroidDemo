package online.zhaozhe.androiddemo.widget

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import online.zhaozhe.core.utils.px


private val XFERMODE = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)

class XfermodeView(context: Context?, attributeSet: AttributeSet?)
    :View(context,attributeSet){

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val bounds = RectF(150f.px, 50f.px, 300f.px, 250f.px)
    private val circleBitmap = Bitmap.createBitmap(150f.px.toInt(),150f.px.toInt(),Bitmap.Config.ARGB_8888)
    private val squareBitmap = Bitmap.createBitmap(150f.px.toInt(),150f.px.toInt(),Bitmap.Config.ARGB_8888)


    init {
        val canvas = Canvas(circleBitmap)
        paint.color = Color.RED
        canvas.drawOval(50f.px,0f.px,150f.px,100f.px,paint)


        paint.color = Color.BLUE
        canvas.setBitmap(squareBitmap)
        canvas.drawRect(0f.px,50f.px,100f.px,150f.px,paint)
    }

    override fun onDraw(canvas: Canvas) {
        val count = canvas.saveLayer(bounds,null)
        canvas.drawBitmap(circleBitmap,150f.px,50f.px,paint)
        paint.xfermode = XFERMODE

        canvas.drawBitmap(squareBitmap,150f.px,50f.px,paint)

        paint.xfermode = null
        canvas.restoreToCount(count)
    }
}