package online.zhaozhe.core

interface BaseView<T> {
    fun getPresenter(): T
}