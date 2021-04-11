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

private val RADIUS = 150f.px
private val ANGELS = floatArrayOf(60f,90f,150f,60f)
private val COLORS = listOf(Color.parseColor("#f47920"),Color.parseColor("#f391a9"),
    Color.parseColor("#1d953f"),Color.parseColor("#8552a1"))
private val OFFSET_LENGTH = 20f.px

class PiewView(context: Context,attributeSet: AttributeSet?) : View(context,attributeSet) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {

    }

    override fun onDraw(canvas: Canvas) {
        var startAngel = 0f

        for ((index, angle) in ANGELS.withIndex()){
            paint.color = COLORS[index]
            if (index == 2){
                canvas.save()
                canvas.translate((OFFSET_LENGTH * cos(Math.toRadians((startAngel + angle / 2f).toDouble()))).toFloat(),
                    (OFFSET_LENGTH * sin(Math.toRadians((startAngel + angle / 2f).toDouble()))).toFloat()
                )
            }
            canvas.drawArc(width / 2f - RADIUS, height / 2f - RADIUS, width/2f + RADIUS,
                height/2f + 150f.px, startAngel, angle, true,paint)
            startAngel += angle
            if (index == 2){
                canvas.restore()
            }
        }
    }










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