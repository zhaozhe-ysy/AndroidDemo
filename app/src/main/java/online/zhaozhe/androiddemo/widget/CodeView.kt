package online.zhaozhe.androiddemo.widget

import android.content.Context
import androidx.appcompat.widget.AppCompatTextView
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet

import android.view.Gravity

import android.util.TypedValue
import online.zhaozhe.androiddemo.R
import online.zhaozhe.core.utils.Utils
import java.util.*


class CodeView : AppCompatTextView {

    constructor(context: Context) : this(context,null){

    }

    constructor(context: Context,attributeSet: AttributeSet?): super(context,attributeSet){

    }

    private val paint: Paint = Paint()
    private val codeList = arrayOf(
        "kotlin",
        "android",
        "java",
        "http",
        "https",
        "okhttp",
        "retrofit",
        "tcp/ip"
    )

    init {
        setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f)
        gravity = Gravity.CENTER
        setBackgroundColor(context.getColor(R.color.colorPrimary))
        setTextColor(Color.WHITE)
        paint.isAntiAlias = true
        paint.style = Paint.Style.STROKE
        paint.color = context.getColor(R.color.colorAccent)
        paint.strokeWidth = Utils.dp2px(6f)
        updateCode()
    }

    fun updateCode() {
        val random: Int = Random().nextInt(codeList.size)
        val code = codeList[random]
        text = code
    }

    override fun onDraw(canvas: Canvas) {
        canvas.drawLine(0f, height.toFloat(), width.toFloat(), 0f, paint)
        super.onDraw(canvas)
    }


}