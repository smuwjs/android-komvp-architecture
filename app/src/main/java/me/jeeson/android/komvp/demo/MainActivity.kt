package me.jeeson.android.komvp.demo

import android.app.Application
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import me.jeeson.android.komvp.core.base.BaseActivity
import me.jeeson.android.komvp.core.utils.RxLifecycleUtils
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var injectApplication : Application
    internal var tv : TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv = findViewById(R.id.sample_text) as TextView

        //测试Dagger2是否正常注入，RxJava是否正常使用
        Observable.fromCallable { "Test Dagger2 and RxJava: inject is successful ?" + (injectApplication!=null) }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(RxLifecycleUtils.bindToLifecycle(this))
                .subscribe { str -> tv?.text = str }

        //测试RxLifecycle在Activity关闭是否能正常停止
        Observable.interval(5, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                //注释后，Activity关闭不能停止,说明RxLifecycle可正常使用
                .compose(RxLifecycleUtils.bindToLifecycle(this))
                .subscribe({Toast.makeText(this, "Test RxLifecycle: hello!", Toast.LENGTH_SHORT).show()})
    }
}
