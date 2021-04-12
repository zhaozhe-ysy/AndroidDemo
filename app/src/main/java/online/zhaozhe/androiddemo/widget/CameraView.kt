package online.zhaozhe.androiddemo.widget

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import online.zhaozhe.androiddemo.R
import online.zhaozhe.core.utils.dp

private val BITMAP_SIZE = 200.dp
private val BITMAP_PADDING = 100.dp

class CameraView(context: Context, attributeSet: AttributeSet)
    : View(context,attributeSet){

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val bitmap = getAvatar(BITMAP_SIZE.toInt())
    private val cliped = Path().apply {
        addOval(BITMAP_PADDING, BITMAP_PADDING, BITMAP_PADDING + BITMAP_SIZE, BITMAP_PADDING + BITMAP_SIZE, Path.Direction.CCW)
    }
    private val camera = Camera().apply {
        rotateX(30f)
        setLocation(0f,0f, -6 * resources.displayMetrics.density)
    }

    override fun onDraw(canvas: Canvas) {

//        上半部分
        canvas.save()
        canvas.translate((BITMAP_PADDING + BITMAP_SIZE / 2),(BITMAP_PADDING + BITMAP_SIZE / 2))
        canvas.rotate(-30f)
        canvas.clipRect(-BITMAP_SIZE , -BITMAP_SIZE , BITMAP_SIZE , 0f)
        canvas.rotate(30f)
        canvas.translate(-(BITMAP_PADDING + BITMAP_SIZE / 2),-(BITMAP_PADDING + BITMAP_SIZE / 2))
        canvas.drawBitmap(bitmap, BITMAP_PADDING, BITMAP_PADDING,paint)
        canvas.restore()

//        下半部分
        canvas.save()
        canvas.translate((BITMAP_PADDING + BITMAP_SIZE / 2),(BITMAP_PADDING + BITMAP_SIZE / 2))
        canvas.rotate(-30f)
        camera.applyToCanvas(canvas)
        canvas.clipRect(-BITMAP_SIZE , 0f, BITMAP_SIZE, BITMAP_SIZE )
        canvas.rotate(30f)
        canvas.translate(-(BITMAP_PADDING + BITMAP_SIZE / 2),-(BITMAP_PADDING + BITMAP_SIZE / 2))
        canvas.drawBitmap(bitmap, BITMAP_PADDING, BITMAP_PADDING,paint)
        canvas.restore()
    }

//    override fun onDraw(canvas: Canvas) {
//        canvas.clipPath(cliped)
////        canvas.clipRect(BITMAP_PADDING, BITMAP_PADDING, BITMAP_PADDING + BITMAP_SIZE / 2, BITMAP_PADDING + BITMAP_SIZE / 2)
//        canvas.drawBitmap(bitmap, BITMAP_PADDING, BITMAP_PADDING,paint)
//    }

    fun getAvatar(width: Int): Bitmap {

        val options = BitmapFactory.Options();
        options.inJustDecodeBounds = true
        BitmapFactory.decodeResource(resources, R.drawable.avatar_rengwuxian,options)
        options.inJustDecodeBounds = false
        options.inDensity = options.outWidth
        options.inTargetDensity = width
        return BitmapFactory.decodeResource(resources, R.drawable.avatar_rengwuxian,options)
    }
}