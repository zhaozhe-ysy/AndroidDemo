package online.zhaozhe.androiddemo.entity

//data class User(val userName: String,val password: String, val code: String) {
//}

class User{
    var username: String? = null
    var password: String? = null
    @JvmField
    var code: String? = null

    constructor(){

    }

    constructor(username: String?, password: String?, code: String?){
        this.username = username
        this.password = password
        this.code = code
    }

    fun test(){

    }

}