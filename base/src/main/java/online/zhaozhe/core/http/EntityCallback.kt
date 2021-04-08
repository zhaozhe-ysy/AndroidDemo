package online.zhaozhe.core.http

interface EntityCallback<T> {
    fun onSuccess(entity: T)
    fun onFailure(message: String?)
}