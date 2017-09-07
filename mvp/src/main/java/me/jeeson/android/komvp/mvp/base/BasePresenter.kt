package me.jeeson.android.komvp.mvp.base


import me.jeeson.android.komvp.mvp.IModel
import me.jeeson.android.komvp.mvp.IPresenter
import me.jeeson.android.komvp.mvp.IView

open class BasePresenter<M : IModel, V : IView> : IPresenter {

     var mModel: M? = null
     var mRootView: V? = null

    constructor(model: M, rootView: V) {
        this.mModel = model
        this.mRootView = rootView
        onStart()
    }

    constructor(model: M) {
        this.mModel = model
        onStart()
    }

    constructor(rootView: V) {
        this.mRootView = rootView
        onStart()
    }

    constructor() {
        onStart()
    }

    override fun onStart() {}

    override fun onDestroy() {
        if (mModel != null)
            mModel!!.onDestroy()
        this.mModel = null
        this.mRootView = null
    }
}
