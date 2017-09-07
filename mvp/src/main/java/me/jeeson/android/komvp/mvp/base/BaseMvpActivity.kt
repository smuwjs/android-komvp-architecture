package me.jeeson.android.komvp.mvp.base

import android.os.Bundle
import me.jeeson.android.komvp.core.base.BaseActivity
import me.jeeson.android.komvp.mvp.IModel
import me.jeeson.android.komvp.mvp.IView
import javax.inject.Inject

/**
 * @Description:
 * *
 * @Anthor: Jeeson
 * *
 * @Time: 2017/9/6 14:19
 */
abstract class BaseMvpActivity<P : BasePresenter<*,*>> : BaseActivity(), IView {

    @Inject
    lateinit var mPresenter: P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        @Suppress("UNCHECKED_CAST")
        (mPresenter as BasePresenter<IModel, IView>).mRootView = this
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.onDestroy()
    }
}
