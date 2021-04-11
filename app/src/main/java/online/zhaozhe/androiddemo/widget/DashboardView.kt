package online.zhaozhe.androiddemo.widget

import android.content.Context
import android.content.res.Resources
import android.graphics.*
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View
import online.zhaozhe.core.utils.px
import kotlin.math.cos
import kotlin.math.sin

private val RADIUS = 100f.px
private const val OPEN_ANGLE = 120
private val DASH_WIDTH = 2f.px
private val DASH_LENGTH = 10f.px
private val LENGTH = 120f.px

class DashboardView(context: Context,attributeSet: AttributeSet?) : View(context,attributeSet) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val dash = Path()
    private val path = Path()
    private lateinit var pathEffect: PathEffect

    init {
        paint.strokeWidth = 3f.px
        paint.style = Paint.Style.STROKE
        dash.addRect(0f,0f, DASH_WIDTH, DASH_LENGTH,Path.Direction.CCW)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        path.reset()
        path.addArc(width / 2f - 150f.px, height / 2f - 150f.px, width/2f + 150f.px,
            height/2f + 150f.px, 90f + OPEN_ANGLE /2f, 360f - OPEN_ANGLE)
        val pathMeasure = PathMeasure(path, false)
        pathMeasure.length / 20f
        pathEffect = PathDashPathEffect(dash,pathMeasure.length / 20f,0f,PathDashPathEffect.Style.ROTATE)
    }

    override fun onDraw(canvas: Canvas) {
//        画弧线
        canvas.drawPath(path,paint)
//        canvas.drawArc(width / 2f - 150f.px, height / 2f - 150f.px, width/2f + 150f.px,
//            height/2f + 150f.px, 90f + OPEN_ANGLE /2f, 360f - OPEN_ANGLE, false,paint)

//        画刻度
//        paint.pathEffect = PathDashPathEffect(dash,50f,0f,PathDashPathEffect.Style.ROTATE)
        paint.pathEffect = pathEffect
        canvas.drawArc(width / 2f - 150f.px, height / 2f - 150f.px, width/2f + 150f.px,
            height/2f + 150f.px, 90f + OPEN_ANGLE /2f, 360f - OPEN_ANGLE, false,paint)

        paint.pathEffect = null

        canvas.drawLine(width/2f,height/2f,
            width /2f + LENGTH * cos(markToRadians(6)).toFloat(),
            height / 2f + LENGTH * sin(markToRadians(6)).toFloat(),
            paint)
    }

    private fun markToRadians(mark: Int) = Math.toRadians((90f + OPEN_ANGLE /2f + (360f - OPEN_ANGLE) / 20f * mark).toDouble())









//    private val path = Path()
//    private lateinit var pathMeasure: PathMeasure
//    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
//        path.addCircle(width/2f,height/2f, RADIUS, Path.Direction.CCW)
//        path.addRect(width/2f - RADIUS, height/2f,width /2f + RADIUS, height /2f +2* RADIUS,Path.Direction.CW)
//        path.addCircle(width/2f,height/2f, RADIUS * 1.5f,Path.Direction.CCW)
//
//        pathMeasure = PathMeasure(path,false)
//
//        path.fillType = Path.FillType.EVEN_ODD
//    }
//    override fun onDraw(canvas: Canvas) {
//        画直线
//        canvas.drawLine(100f,100f,200f,200f,paint)
//        画圆
//        canvas.drawCircle(width / 2f,height/2f, RADIUS,paint)
//        canvas.drawPath(path,paint)
//    }
}