package online.zhaozhe.core.utils

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.widget.Toast

import android.util.TypedValue

import android.util.DisplayMetrics
import online.zhaozhe.core.BaseApplication
import online.zhaozhe.core.R

private val displayMetrics: DisplayMetrics = Resources.getSystem().getDisplayMetrics()

fun Float.dp2px() = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this, displayMetrics)


object Utils {

    @JvmOverloads
    fun toast(string: String?, duration: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(BaseApplication.currentApplication, string, duration).show()
    }

}

fun getAvatar(resources: Resources, width: Int): Bitmap {
    val options = BitmapFactory.Options();
    options.inJustDecodeBounds = true
    BitmapFactory.decodeResource(resources, R.drawable.avatar_rengwuxian,options)
    options.inJustDecodeBounds = false
    options.inDensity = options.outWidth
    options.inTargetDensity = width
    return BitmapFactory.decodeResource(resources,R.drawable.avatar_rengwuxian,options)
}