package online.zhaozhe.androiddemo.widget

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.text.TextPaint
import android.util.AttributeSet
import android.view.View
import online.zhaozhe.androiddemo.R
import online.zhaozhe.core.utils.dp
import online.zhaozhe.core.utils.getAvatar
import kotlin.math.max

private val IMAGE_SIZE = 150.dp
private val IMAGE_PADDING = 50.dp

class MultilineTextView(context: Context, attributeSet: AttributeSet)
    : View(context, attributeSet){

    val text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur tristique urna tincidunt maximus viverra. Maecenas commodo pellentesque dolor ultrices porttitor. Vestibulum in arcu rhoncus, maximus ligula vel, consequat sem. Maecenas a quam libero. Praesent hendrerit ex lacus, ac feugiat nibh interdum et. Vestibulum in gravida neque. Morbi maximus scelerisque odio, vel pellentesque purus ultrices quis. Praesent eu turpis et metus venenatis maximus blandit sed magna. Sed imperdiet est semper urna laoreet congue. Praesent mattis magna sed est accumsan posuere. Morbi lobortis fermentum fringilla. Fusce sed ex tempus, venenatis odio ac, tempor metus."

    private val textPaint = TextPaint(Paint.ANTI_ALIAS_FLAG).apply {
        textSize = 16.dp
    }

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        textSize = 16.dp
    }
    private val bitmap = getAvatar(resources, IMAGE_SIZE.toInt())
    private val fontMetrics = Paint.FontMetrics()


    override fun onDraw(canvas: Canvas) {

        canvas.drawBitmap(bitmap,width - IMAGE_SIZE, IMAGE_PADDING,paint)
        paint.getFontMetrics(fontMetrics)
        val measuredWidth = floatArrayOf(0f)
        var start = 0;
        var count = 0;
        var verticalOffset = - fontMetrics.top
        var maxWidth: Float
        while ( start < text.length){
            maxWidth = if (verticalOffset + fontMetrics.bottom < IMAGE_PADDING || verticalOffset + fontMetrics.top > IMAGE_PADDING + IMAGE_SIZE){
                width.toFloat()
            } else {
                width.toFloat() - IMAGE_SIZE
            }
            count = paint.breakText(text, start, text.length, true, maxWidth, measuredWidth)
            canvas.drawText(text, start, start + count, 0f, verticalOffset, paint)
            start += count
            verticalOffset += paint.fontSpacing
        }
    }
}