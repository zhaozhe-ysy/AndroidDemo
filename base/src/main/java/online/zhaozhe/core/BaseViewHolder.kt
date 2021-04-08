package online.zhaozhe.core

import android.widget.TextView

import androidx.annotation.IdRes

import android.annotation.SuppressLint
import android.view.View

import androidx.annotation.NonNull

import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder


abstract class BaseViewHolder(itemView: View) : ViewHolder(itemView) {

    @SuppressLint("UseSparseArrays")
    private val viewHashMap: MutableMap<Int, View?> = HashMap()

    protected fun <T : View?> getView(@IdRes id: Int): T? {
        var view: View? = viewHashMap[id]
        if (view == null) {
            view = itemView.findViewById(id)
            viewHashMap[id] = view
        }
        return view as T
    }

    protected fun setText(@IdRes id: Int, text: String?) {
        (getView<View>(id) as TextView).text = text
    }
}