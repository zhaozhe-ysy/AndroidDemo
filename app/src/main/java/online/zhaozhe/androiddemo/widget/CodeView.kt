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
import online.zhaozhe.core.utils.dp2px
import java.util.*


class CodeView @JvmOverloads constructor(context: Context,attributeSet: AttributeSet? = null) : AppCompatTextView(context,attributeSet) {

    private val paint: Paint = Paint().apply {
        this.isAntiAlias = true
        this.style = Paint.Style.STROKE
        this.color = context.getColor(R.color.colorAccent)
        this.strokeWidth = 6f.dp2px()
    }
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