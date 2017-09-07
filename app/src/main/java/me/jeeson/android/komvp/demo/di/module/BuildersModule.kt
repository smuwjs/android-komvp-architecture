package me.jeeson.android.komvp.demo.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import me.jeeson.android.komvp.core.di.scope.ActivityScope
import me.jeeson.android.komvp.demo.mvp.ui.MainActivity

/**
 * @Description:
 * *
 * @Anthor: Jeeson
 * *
 * @Time: 2017/8/28 9:04
 */
@Module
abstract class BuildersModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = arrayOf(MainModule::class))
    internal abstract fun mainActivity(): MainActivity
}
