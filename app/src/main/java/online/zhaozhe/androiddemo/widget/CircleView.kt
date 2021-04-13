package online.zhaozhe.androiddemo.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import online.zhaozhe.core.utils.dp

class CircleView(context: Context, attributeSet: AttributeSet)
    :View(context,attributeSet){

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.GREEN
    }
    var radius = 50.dp
        set(value) {
            field = value
            invalidate()
        }

    override fun onDraw(canvas: Canvas) {
        canvas.drawCircle(width/2f,height/2f,radius,paint)
    }

}