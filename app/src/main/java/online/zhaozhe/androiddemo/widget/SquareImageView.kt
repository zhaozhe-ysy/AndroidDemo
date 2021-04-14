package online.zhaozhe.androiddemo.widget

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import online.zhaozhe.core.utils.dp
import kotlin.math.min

class SquareImageView(context: Context, attributeSet: AttributeSet)
    : AppCompatImageView(context, attributeSet){

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val size = min(measuredWidth, measuredHeight)
        setMeasuredDimension(size,size)
    }

//    override fun layout(l: Int, t: Int, r: Int, b: Int) {
//        val width = r - l
//        val height = b - t
//        val size= min(width,height)
//        super.layout(l, t, l+size, t + size)
//    }

}