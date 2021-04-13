package online.zhaozhe.androiddemo.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.PointF
import android.util.AttributeSet
import android.view.View
import online.zhaozhe.core.utils.dp

class PointView(context: Context, attributeSet: AttributeSet)
    :View(context, attributeSet){

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var point = PointF(0f,0f)
      set(value) {
          field = value
          invalidate()
      }

    init {
        paint.strokeWidth = 20.dp
        paint.strokeCap = Paint.Cap.ROUND
    }

    override fun onDraw(canvas: Canvas) {
        canvas.drawPoint(point.x,point.y,paint)
    }
}