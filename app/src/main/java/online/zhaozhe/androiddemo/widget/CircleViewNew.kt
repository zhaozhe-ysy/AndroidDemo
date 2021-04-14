package online.zhaozhe.androiddemo.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import online.zhaozhe.core.utils.dp

private val RADIUS = 100.dp
private val PADDING = 100.dp
class CircleViewNew(context: Context, attributeSet: AttributeSet)
    : View(context, attributeSet){

    val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val size = ((PADDING + RADIUS) * 2).toInt()
//        val specWidthMode = MeasureSpec.getMode(widthMeasureSpec)
//        val specWidthSize = MeasureSpec.getSize(heightMeasureSpec)
//        val width = when(specWidthMode){
//            MeasureSpec.EXACTLY -> specWidthSize
//            MeasureSpec.AT_MOST -> if (size > specWidthSize) specWidthSize else size
//            else -> size
//
//        }
        val width = resolveSize(size,widthMeasureSpec)
        val height = resolveSize(size,heightMeasureSpec)
        setMeasuredDimension(width,height)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.drawCircle(PADDING + RADIUS, PADDING + RADIUS, RADIUS, paint)
    }
}