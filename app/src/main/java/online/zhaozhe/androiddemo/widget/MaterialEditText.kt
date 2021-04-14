package online.zhaozhe.androiddemo.widget

import android.animation.ObjectAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.widget.AppCompatEditText
import online.zhaozhe.androiddemo.R
import online.zhaozhe.core.utils.dp

private val TEXT_SIZE = 12.dp
private val TEXT_MARGIN = 8.dp
private val HORIZONTAL_OFFSET = 5.dp
private val VERTICAL_OFFSET = 23.dp
private val EXTRA_VERTICAL_OFFSET = 16.dp

class MaterialEditText(context: Context, attributeSet: AttributeSet)
    :AppCompatEditText(context, attributeSet){

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        textSize = TEXT_SIZE
    }
    private var floatingLabelShown = false
    var floatingLabelFraction = 0f
      set(value) {
          field = value
          invalidate()
      }

    private val animator by lazy {
        ObjectAnimator.ofFloat(this,"floatingLabelFraction",0f,1f)
    }

    var useFloatingLabel = true
      set(value) {
          if (field != value){
              field = value
              if (field){
                  setPadding(paddingLeft, (paddingTop + TEXT_SIZE + TEXT_MARGIN).toInt(), paddingRight,paddingBottom)
              } else {
                  setPadding(paddingLeft, (paddingTop - TEXT_SIZE - TEXT_MARGIN).toInt(), paddingRight,paddingBottom)
              }
          }
      }

    init {
        val typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.MaterialEditText)
        useFloatingLabel = typedArray.getBoolean(R.styleable.MaterialEditText_userFloatingLabel, true)
        if (useFloatingLabel) {
            setPadding(paddingLeft, (paddingTop + TEXT_SIZE + TEXT_MARGIN).toInt(), paddingRight, paddingBottom)
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        paint.alpha = (floatingLabelFraction * 0xff).toInt()
        val currentVerticalValue = VERTICAL_OFFSET + EXTRA_VERTICAL_OFFSET * (1-floatingLabelFraction)
        canvas.drawText(hint.toString(), HORIZONTAL_OFFSET, currentVerticalValue,paint)

    }

    override fun onTextChanged(text: CharSequence?, start: Int, lengthBefore: Int, lengthAfter: Int) {
        if (floatingLabelShown && text.isNullOrEmpty()){
            floatingLabelShown = false
            animator.reverse()
        } else if (!floatingLabelShown && !text.isNullOrEmpty()){
            floatingLabelShown = true
            animator.start()
        }
    }

}