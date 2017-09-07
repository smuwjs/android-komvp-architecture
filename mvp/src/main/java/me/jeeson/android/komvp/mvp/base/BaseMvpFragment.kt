package me.jeeson.android.komvp.mvp.base

import android.content.Context
import me.jeeson.android.komvp.core.base.BaseFragment
import me.jeeson.android.komvp.mvp.IModel
import me.jeeson.android.komvp.mvp.IView
import javax.inject.Inject

/**
 * @Description:
 * @Anthor: Jeeson
 * @Time: 2017/9/6 14:25
 */
abstract class BaseMvpFragment<P : BasePresenter<*,*>> : BaseFragment() , IView{

    @Inject
    lateinit var mPresenter: P

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        @Suppress("UNCHECKED_CAST")
        (mPresenter as BasePresenter<IModel, IView>).mRootView = this
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.onDestroy()
    }
}