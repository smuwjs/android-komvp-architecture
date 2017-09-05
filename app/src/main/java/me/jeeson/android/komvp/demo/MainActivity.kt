package me.jeeson.android.komvp.demo

import android.app.Application
import android.os.Bundle
import android.widget.TextView
import me.jeeson.android.komvp.core.base.BaseActivity
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var injectApplication : Application

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tv = findViewById(R.id.sample_text) as TextView
        tv.text = "injectApplication is null ?" + (injectApplication==null)
    }
}
