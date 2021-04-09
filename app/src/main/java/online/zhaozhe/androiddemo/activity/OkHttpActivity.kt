package online.zhaozhe.androiddemo.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import okhttp3.*
import online.zhaozhe.androiddemo.R
import java.io.IOException

class OkHttpActivity : AppCompatActivity(){

    private val TAG = OkHttpActivity::class.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_okhttp)


        val url = "https://api.github.com/users/zhaozhe-ysy/repos"

        val client = OkHttpClient()
        val request: Request = Request.Builder()
            .url(url)
            .build()

        client.newCall(request)
            .enqueue(object: Callback{
                override fun onFailure(call: Call, e: IOException) {
                    Log.e(TAG,"request fail")
                }

                override fun onResponse(call: Call, response: Response) {
                    Log.d(TAG,"Response status code: ${response.code}")
                }

            })

    }
}