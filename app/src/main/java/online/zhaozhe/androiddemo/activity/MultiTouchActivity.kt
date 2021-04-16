package online.zhaozhe.androiddemo.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_multi_touch.*
import online.zhaozhe.androiddemo.R

class MultiTouchActivity : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multi_touch)
        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id){
            R.id.button1 -> {
                multi_touch_1.visibility = View.VISIBLE
                multi_touch_2.visibility = View.GONE
                multi_touch_3.visibility = View.GONE
            }
            R.id.button2 -> {
                multi_touch_1.visibility = View.GONE
                multi_touch_2.visibility = View.VISIBLE
                multi_touch_3.visibility = View.GONE
            }
            R.id.button3 -> {
                multi_touch_1.visibility = View.GONE
                multi_touch_2.visibility = View.GONE
                multi_touch_3.visibility = View.VISIBLE
            }
        }
    }
}