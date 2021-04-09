package online.zhaozhe.androiddemo.activity

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import online.zhaozhe.androiddemo.R
import online.zhaozhe.core.http.retrofit.GitHubService
import retrofit2.Retrofit
import online.zhaozhe.core.http.retrofit.Repo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitActivity : AppCompatActivity() {

    private val TAG = RetrofitActivity::class.simpleName

    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit)

        textView = findViewById(R.id.text_retrofit)

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()


        val service: GitHubService = retrofit.create(GitHubService::class.java)
        val repos: Call<List<Repo>> = service.listRepos("octocat")

        repos.enqueue(object : Callback<List<Repo>> {
            override fun onResponse(call: Call<List<Repo>>, response: Response<List<Repo>>) {
                Log.d(TAG,"Response: ${response.body()?.get(0)?.toString()}")
                textView.text = response.body()?.get(0)?.toString()
            }

            override fun onFailure(call: Call<List<Repo>>, t: Throwable) {
                Log.e(TAG,"request fail!!!")
            }

        })
    }
}