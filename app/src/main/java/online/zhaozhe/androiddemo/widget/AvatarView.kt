package online.zhaozhe.androiddemo.widget

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import online.zhaozhe.androiddemo.R
import online.zhaozhe.core.utils.px

private val IMAGE_WIDTH = 200f.px
private val IMAGE_PADDING = 20f.px
private val XFERMODE = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)
class AvatarView(context: Context?, attributeSet: AttributeSet?)
    : View(context,attributeSet) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val bounds = RectF(IMAGE_PADDING, IMAGE_PADDING, IMAGE_PADDING+ IMAGE_WIDTH, IMAGE_PADDING+IMAGE_WIDTH)

    override fun onDraw(canvas: Canvas) {
        val count = canvas.saveLayer(bounds,null)
        canvas.drawOval(IMAGE_PADDING, IMAGE_PADDING, IMAGE_PADDING+ IMAGE_WIDTH, IMAGE_PADDING+IMAGE_WIDTH,paint)
        paint.xfermode = XFERMODE
        canvas.drawBitmap(getAvatar(IMAGE_WIDTH.toInt()), IMAGE_PADDING, IMAGE_PADDING, paint)
        paint.xfermode = null
        canvas.restoreToCount(count)
//        paint.style = Paint.Style.STROKE
//        paint.strokeWidth = 30f
//        canvas.drawOval(IMAGE_PADDING, IMAGE_PADDING, IMAGE_PADDING+ IMAGE_WIDTH, IMAGE_PADDING+IMAGE_WIDTH,paint)
    }

    fun getAvatar(width: Int): Bitmap{

        val options = BitmapFactory.Options();
        options.inJustDecodeBounds = true
        BitmapFactory.decodeResource(resources, R.drawable.avatar_rengwuxian,options)
        options.inJustDecodeBounds = false
        options.inDensity = options.outWidth
        options.inTargetDensity = width
        return BitmapFactory.decodeResource(resources,R.drawable.avatar_rengwuxian,options)
    }


}