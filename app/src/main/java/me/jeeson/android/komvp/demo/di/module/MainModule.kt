package me.jeeson.android.komvp.demo.di.module

import dagger.Module
import dagger.Provides
import me.jeeson.android.komvp.core.di.scope.ActivityScope
import me.jeeson.android.komvp.demo.mvp.contract.MainContract
import me.jeeson.android.komvp.demo.mvp.model.MainModel
import me.jeeson.android.komvp.demo.mvp.ui.MainActivity

/**
 * @Description:
 * *
 * @Anthor: Jeeson
 * *
 * @Time: 2017/7/5 16:57
 */

@Module
class MainModule {

    @ActivityScope
    @Provides
    fun provideMainModel(model: MainModel): MainContract.Model {
        return model
    }

    @ActivityScope
    @Provides
    fun provideMainView(mainActivity : MainActivity) : MainContract.View {
        return mainActivity
    }
}
