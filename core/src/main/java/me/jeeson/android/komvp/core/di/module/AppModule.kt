package me.jeeson.android.komvp.core.di.module

import android.app.Application
import dagger.Module
import dagger.Provides
import me.jeeson.android.komvp.core.lifecycle.ActivityLifecycleForRxLifecycle
import javax.inject.Singleton

/**
 * @Description:
 * @Anthor: Jeeson
 * @Time: 2017/8/31 15:58
 */

@Module
class AppModule(val mApplication: Application) {

    @Singleton
    @Provides
    fun provideApplication(): Application {
        return mApplication
    }

    @Singleton
    @Provides
    fun provideActivityLifecycleForRxLifecycle() : ActivityLifecycleForRxLifecycle {
        return ActivityLifecycleForRxLifecycle()
    }

}