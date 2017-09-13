package me.jeeson.android.komvp.core.base

import android.app.Activity
import android.app.Application
import android.content.Context
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import me.jeeson.android.komvp.core.base.delegate.ApplicationDelegate
import me.jeeson.android.komvp.core.base.delegate.ApplicationDelegateImpl
import me.jeeson.android.komvp.core.di.component.ApplicationComponent
import javax.inject.Inject

/**
 * @Description:
 * @Anthor: Jeeson
 * @Time: 2017/8/31 15:52
 */
open class BaseApplication : Application(), IBaseApplication, HasActivityInjector{

    @Inject
    lateinit var mDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    internal var mAppDelegate: ApplicationDelegate? = null

    override fun onCreate() {
        super.onCreate()
        mAppDelegate?.onCreate(this)
    }

    override fun getApplicationComponent(): ApplicationComponent? {
        return mAppDelegate?.getApplicationComponent()
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        mAppDelegate = ApplicationDelegateImpl(this)
        mAppDelegate?.attachBaseContext(base)
    }

    override fun onTerminate() {
        super.onTerminate()
        mAppDelegate?.onTerminate()
    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return mDispatchingAndroidInjector
    }

}