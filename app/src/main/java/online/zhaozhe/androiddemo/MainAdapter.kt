package online.zhaozhe.androiddemo

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import online.zhaozhe.androiddemo.activity.*
import online.zhaozhe.core.BaseViewHolder

class MainAdapter(private val context: Context) : RecyclerView.Adapter<MainAdapter.MainViewHolder>(){

    private val data = arrayOf(
        "kotlin",
        "retrofit",
        "okhttp",
        "ViewMeasure",
        "Animator",
        "CustomView",
        "CustomLayout",
        "ScalableImageView",
        "MultiTouch",
        "TouchViewGroup",
        "Drag"
    )

    private val activityArray = arrayOf(
        KotlinActivity::class.java,
        RetrofitActivity::class.java,
        OkHttpActivity::class.java,
        ViewMeasureActivity::class.java,
        AnimationActivity::class.java,
        CustomViewActivity::class.java,
        CustomLayoutActivity::class.java,
        ScalableImageActivity::class.java,
        MultiTouchActivity::class.java,
        TouchViewGroupActivity::class.java,
        DragActivity::class.java
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_main,parent,false)
        return MainViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.textView.text = data[position]
        holder.textView.setOnClickListener {
            context.startActivity(Intent(context,activityArray[position]))
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }


    class MainViewHolder internal constructor(itemView: View) : BaseViewHolder(itemView){

        val textView: TextView = itemView.findViewById(R.id.item_text)

    }


}