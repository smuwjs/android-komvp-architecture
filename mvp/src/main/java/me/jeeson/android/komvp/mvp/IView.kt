package me.jeeson.android.komvp.mvp

interface IView {

    fun showLoading()

    fun hideLoading()

    fun showMessage(message: String)
}
