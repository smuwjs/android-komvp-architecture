package me.jeeson.android.komvp.core.base.delegate

import android.app.Application
import android.content.Context
import me.jeeson.android.komvp.core.di.component.ApplicationComponent
import me.jeeson.android.komvp.core.di.component.DaggerApplicationComponent
import me.jeeson.android.komvp.core.di.module.AppModule
import javax.inject.Inject
import me.jeeson.android.komvp.core.integration.lifecycle.ActivityLifecycleForRxLifecycle



/**
 * @Description:
 * @Anthor: Jeeson
 * @Time: 2017/8/31 16:19
 */
class ApplicationDelegateImpl(val context : Context ) : ApplicationDelegate{

    internal var mApplication : Application?= null
    internal var applicationComponent : ApplicationComponent? = null

    @Inject
    lateinit var mActivityLifecycleForRxLifecycle: ActivityLifecycleForRxLifecycle

    override fun getApplicationComponent(): ApplicationComponent? {
        return applicationComponent
    }

    override fun onCreate(application: Application) {

        mApplication = application
        applicationComponent =
        DaggerApplicationComponent
                .builder()
                .appModule(AppModule(application))
                .build()
        applicationComponent?.inject(this)

        mApplication?.registerActivityLifecycleCallbacks(mActivityLifecycleForRxLifecycle)

    }

    override fun attachBaseContext(base: Context?) {
    }

    override fun onTerminate() {
    }

}