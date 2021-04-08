package online.zhaozhe.core.utils

import android.content.res.Resources
import android.widget.Toast

import android.util.TypedValue

import android.util.DisplayMetrics
import online.zhaozhe.core.BaseApplication


object Utils {
    private val displayMetrics: DisplayMetrics = Resources.getSystem().getDisplayMetrics()

    fun dp2px(dp: Float): Float {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, displayMetrics)
    }

    fun toast(string: String?) {
        toast(string, Toast.LENGTH_SHORT)
    }

    fun toast(string: String?, duration: Int) {
        Toast.makeText(BaseApplication.currentApplication(), string, duration).show()
    }

}