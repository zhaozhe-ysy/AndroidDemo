package online.zhaozhe.core.utils

import android.content.res.Resources
import android.widget.Toast

import android.util.TypedValue

import android.util.DisplayMetrics
import online.zhaozhe.core.BaseApplication

private val displayMetrics: DisplayMetrics = Resources.getSystem().getDisplayMetrics()

fun Float.dp2px() = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this, displayMetrics)


object Utils {

    @JvmOverloads
    fun toast(string: String?, duration: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(BaseApplication.currentApplication, string, duration).show()
    }

}