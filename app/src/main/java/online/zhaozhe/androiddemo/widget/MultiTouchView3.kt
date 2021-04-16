package online.zhaozhe.androiddemo.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.util.SparseArray
import android.view.MotionEvent
import android.view.View
import online.zhaozhe.core.utils.dp

class MultiTouchView3(context: Context, attributeSet: AttributeSet)
    : View(context, attributeSet){

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.STROKE
        strokeWidth = 4.dp
        strokeCap = Paint.Cap.ROUND
        strokeJoin = Paint.Join.ROUND
    }
    private var paths = SparseArray<Path>()

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        for (i in 0 until paths.size()){
            val path = paths.valueAt(i)
            canvas.drawPath(path,paint)
        }
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {

        when (event.actionMasked) {
            MotionEvent.ACTION_DOWN, MotionEvent.ACTION_POINTER_DOWN-> {
                val path = Path()
                val actionIndex = event.actionIndex
                path.moveTo(event.getX(actionIndex), event.getY(actionIndex))
                paths.append(event.getPointerId(actionIndex),path)
                invalidate()
            }
            MotionEvent.ACTION_MOVE -> {
                for (i in 0 until paths.size()){
                    val pointerId = event.getPointerId(i)
                    val path = paths.get(pointerId)
                    path.lineTo(event.getX(i),event.getY(i))
                }
                invalidate()
            }
            MotionEvent.ACTION_UP, MotionEvent.ACTION_POINTER_UP -> {
                val actionIndex = event.actionIndex
                val pointerId = event.getPointerId(actionIndex)
                paths.remove(pointerId)
                invalidate()
            }
        }
        return true
    }
}