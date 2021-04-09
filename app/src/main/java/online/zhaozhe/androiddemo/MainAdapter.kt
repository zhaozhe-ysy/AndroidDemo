package online.zhaozhe.androiddemo

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import online.zhaozhe.androiddemo.activity.KotlinActivity
import online.zhaozhe.androiddemo.activity.RetrofitActivity
import online.zhaozhe.core.BaseViewHolder

class MainAdapter(private val context: Context) : RecyclerView.Adapter<MainAdapter.MainViewHolder>(){

    private val data = arrayOf("kotlin","retrofit")

    private val activityArray = arrayOf(KotlinActivity::class.java,RetrofitActivity::class.java)

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