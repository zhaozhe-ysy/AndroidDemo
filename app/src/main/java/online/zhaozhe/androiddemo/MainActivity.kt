package online.zhaozhe.androiddemo

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import android.widget.LinearLayout
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView



class MainActivity : AppCompatActivity(), View.OnClickListener {



    private val mainAdapter = MainAdapter(this);

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<RecyclerView>(R.id.main_recycler_view).run {
            this.layoutManager = LinearLayoutManager(this@MainActivity)
            this.adapter = mainAdapter
            this.addItemDecoration(DividerItemDecoration(this@MainActivity, LinearLayout.VERTICAL))
        }


    }


    override fun onClick(v: View?) {

    }

}