package me.jeeson.android.komvp.demo.di.component

import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule
import me.jeeson.android.komvp.core.di.component.ApplicationComponent
import me.jeeson.android.komvp.core.di.scope.ApplicationScope
import me.jeeson.android.komvp.demo.SampleApplication
import me.jeeson.android.komvp.demo.di.module.BuildersModule

/**
 * @Description:
 * @Anthor: Jeeson
 * @Time: 2017/9/5 15:33
 */

@ApplicationScope
@Component(modules = arrayOf(
            BuildersModule::class,
            AndroidSupportInjectionModule::class,
            AndroidInjectionModule::class),
        dependencies = arrayOf(
                ApplicationComponent::class
        ))
interface SampleAppComponent {

    fun inject(sampleApplication: SampleApplication)
}