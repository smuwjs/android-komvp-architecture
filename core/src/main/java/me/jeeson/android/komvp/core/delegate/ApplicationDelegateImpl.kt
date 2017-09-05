package me.jeeson.android.komvp.core.delegate

import android.app.Application
import android.content.Context
import me.jeeson.android.komvp.core.di.component.ApplicationComponent
import me.jeeson.android.komvp.core.di.component.DaggerApplicationComponent
import me.jeeson.android.komvp.core.di.module.AppModule

/**
 * @Description:
 * @Anthor: Jeeson
 * @Time: 2017/8/31 16:19
 */
class ApplicationDelegateImpl(val context : Context ) : ApplicationDelegate{

    private var mApplication : Application?= null
    private var applicationComponent : ApplicationComponent? = null

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
    }

    override fun attachBaseContext(base: Context?) {
    }

    override fun onTerminate() {
    }

}