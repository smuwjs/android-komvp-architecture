package me.jeeson.android.komvp.demo.mvp.contract


import io.reactivex.Observable
import me.jeeson.android.komvp.mvp.IModel
import me.jeeson.android.komvp.mvp.IView

interface MainContract {
    interface View : IView {
        fun test()
    }

    interface Model : IModel {
        fun test(): Observable<Long>?
    }
}
