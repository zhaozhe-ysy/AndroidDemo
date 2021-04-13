package online.zhaozhe.androiddemo.widget

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.View
import online.zhaozhe.androiddemo.drawable.MeshDrawable
import online.zhaozhe.core.utils.dp

class DrawableView(context: Context, attributeSet: AttributeSet)
    : View(context,attributeSet) {

    private val drawable = MeshDrawable()

    override fun onDraw(canvas: Canvas) {
        drawable.setBounds(50.dp.toInt(), 80.dp.toInt(), width, height)
        drawable.draw(canvas)
    }
}