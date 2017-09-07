package me.jeeson.android.komvp.demo.mvp.presenter

import android.widget.Toast
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import me.jeeson.android.komvp.core.di.scope.ActivityScope
import me.jeeson.android.komvp.core.utils.RxLifecycleUtils
import me.jeeson.android.komvp.demo.mvp.contract.MainContract
import me.jeeson.android.komvp.mvp.base.BasePresenter
import me.jeeson.android.komvp.mvp.util.MVPRxLifecycleUtils
import java.util.concurrent.TimeUnit
import javax.inject.Inject

/**
 * @Description:
 * *
 * @Anthor: Jeeson
 * *
 * @Time: 2017/9/6 14:35
 */
@ActivityScope
class MainPresenter @Inject
constructor(model: MainContract.Model) : BasePresenter<MainContract.Model, MainContract.View>(model) {

    fun test() {
        //测试RxLifecycle在Activity关闭是否能正常停止
        mModel?.test()
                ?.observeOn(AndroidSchedulers.mainThread())
                //注释后，Activity关闭不能停止,说明RxLifecycle可正常使用
                ?.compose(MVPRxLifecycleUtils.bindToLifecycle(mRootView))
                ?.subscribe({mRootView?.test() })

    }

    override fun onDestroy() {
        super.onDestroy()
    }
}