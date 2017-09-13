package me.jeeson.android.komvp.demo.mvp.ui

import android.app.Application
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import me.jeeson.android.komvp.demo.R
import me.jeeson.android.komvp.demo.mvp.contract.MainContract
import me.jeeson.android.komvp.demo.mvp.presenter.MainPresenter
import me.jeeson.android.komvp.mvp.base.BaseMvpActivity
import javax.inject.Inject

class MainActivity : BaseMvpActivity<MainPresenter>() , MainContract.View{

    @Inject
    lateinit var injectApplication : Application
    internal var tv : TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv = findViewById(R.id.sample_text) as TextView

        //测试Dagger2是否正常注入，RxJava是否正常使用
        tv?.text = "Test Dagger2 and RxJava: inject is successful ?" + (injectApplication!=null)
        mPresenter.test()
    }

    override fun test() {
        Toast.makeText(this, "Test RxLifecycle: hello!", Toast.LENGTH_SHORT).show()
    }

    override fun hideLoading() {
    }

    override fun showMessage(message: String) {
    }

    override fun showLoading() {
    }

}
