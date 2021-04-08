package online.zhaozhe.core

import android.app.Application
import android.content.Context


class BaseApplication : Application() {


    companion object{
        private var currentApplication: Context? = null

        fun currentApplication(): Context {
            return currentApplication!!
        }
    }



    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        currentApplication = this
    }
}