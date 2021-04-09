package online.zhaozhe.androiddemo.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import online.zhaozhe.androiddemo.R
import online.zhaozhe.androiddemo.entity.User
import online.zhaozhe.androiddemo.widget.CodeView
import online.zhaozhe.core.utils.CacheUtils
import online.zhaozhe.core.utils.Utils
import online.zhaozhe.lesson.LessonActivity

class KotlinActivity : AppCompatActivity(), View.OnClickListener  {

    private val usernameKey = "username"
    private val passwordKey = "password"

    private lateinit var et_username: EditText
    private lateinit var et_password: EditText
    private lateinit var et_code: EditText
    private lateinit var btn_login: Button
    private lateinit var img_code: CodeView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)
        et_username = findViewById(R.id.et_username)
        et_password = findViewById(R.id.et_password)
        et_code = findViewById(R.id.et_code)
        btn_login = findViewById(R.id.btn_login)
        img_code = findViewById(R.id.code_view)

        et_username.setText(CacheUtils.get(usernameKey))
        et_password.setText(CacheUtils.get(passwordKey))

        btn_login.setOnClickListener(this)
        img_code.setOnClickListener(this)
    }


    override fun onClick(v: View?) {
        if (v is CodeView){
            v.updateCode()
        } else if (v is Button){
            login()
        }
    }

    private fun login(){
        val username = et_username.text.toString()
        val password = et_password.text.toString()
        val code = et_code.text.toString()


        fun verify(user: User): Boolean{
            if (user.username?.length ?: 0 < 4){
                Utils.toast("用户名不合法")
                return false
            }
            if (user.password?.length ?: 0 < 4){
                Utils.toast("密码不合法")
                return false
            }
            return true
        }

        if (verify(User(username,password,code))){
            CacheUtils.save(usernameKey,username)
            CacheUtils.save(passwordKey,password)
            startActivity(Intent(this, LessonActivity::class.java))
        }
    }
}