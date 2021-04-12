package online.zhaozhe.core.utils

import android.content.res.Resources
import android.util.TypedValue

val Float.px
  get() = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,this,Resources.getSystem().displayMetrics)

val Float.dp
  get() = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,this,Resources.getSystem().displayMetrics)

val Int.dp
  get() = this.toFloat().dp