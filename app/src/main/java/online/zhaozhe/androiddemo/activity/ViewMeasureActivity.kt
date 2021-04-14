package online.zhaozhe.androiddemo.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_measure_view.*
import online.zhaozhe.androiddemo.R

class ViewMeasureActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_measure_view)

//        met.postDelayed({met.useFloatingLabel = false},3000)
    }
}