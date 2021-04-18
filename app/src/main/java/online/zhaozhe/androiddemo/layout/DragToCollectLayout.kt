package online.zhaozhe.androiddemo.layout

import android.content.ClipData
import android.content.Context
import android.util.AttributeSet
import android.view.DragEvent
import android.view.View
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.children
import online.zhaozhe.core.utils.Utils

class DragToCollectLayout(context: Context, attributeSet: AttributeSet)
    : ConstraintLayout(context,attributeSet) {


    private var dragStarter = View.OnLongClickListener{ v ->
        val text = ClipData.newPlainText("name", v.contentDescription)
        ViewCompat.startDragAndDrop(v, text, DragShadowBuilder(v), null, 0)
    }

    private var dragListener: OnDragListener = CollectListener()

    override fun onFinishInflate() {
        super.onFinishInflate()
        for (child in children){
            if (child is LinearLayout){
                child.setOnDragListener(dragListener)
            } else {
                child.setOnLongClickListener(dragStarter)
            }
        }
    }

    inner class CollectListener : OnDragListener {
        override fun onDrag(v: View, event: DragEvent): Boolean {
            when (event.action) {
                DragEvent.ACTION_DROP -> if (v is LinearLayout) {
                    Utils.toast("The color is ${event.clipData.getItemAt(0).text.toString()}")
                }
            }
            return true
        }
    }
}