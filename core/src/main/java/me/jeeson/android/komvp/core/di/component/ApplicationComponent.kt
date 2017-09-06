package me.jeeson.android.komvp.core.di.component

import android.app.Application
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule
import me.jeeson.android.komvp.core.base.delegate.ApplicationDelegateImpl
import me.jeeson.android.komvp.core.di.module.AppModule
import javax.inject.Singleton

/**
 * @Description:
 * @Anthor: Jeeson
 * @Time: 2017/8/31 15:55
 */

@Singleton
@Component(modules = arrayOf(
        AppModule::class,
        AndroidSupportInjectionModule::class,
        AndroidInjectionModule::class
))
interface ApplicationComponent {

    fun application(): Application

    fun inject(applicationDelegateImpl: ApplicationDelegateImpl)
}