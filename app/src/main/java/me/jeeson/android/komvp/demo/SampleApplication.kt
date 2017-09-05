package me.jeeson.android.komvp.demo

import me.jeeson.android.komvp.core.base.BaseApplication
import me.jeeson.android.komvp.demo.di.component.DaggerSampleAppComponent
import me.jeeson.android.komvp.demo.di.component.SampleAppComponent

/**
 * @Description:
 * @Anthor: Jeeson
 * @Time: 2017/8/31 18:13
 */
class SampleApplication : BaseApplication() {

    private var mSampleAppComponent : SampleAppComponent? = null

    override fun onCreate() {
        super.onCreate()

        mSampleAppComponent = DaggerSampleAppComponent
                .builder()
                .applicationComponent(getApplicationComponent())
                .build()

        mSampleAppComponent?.inject(this)
    }
}