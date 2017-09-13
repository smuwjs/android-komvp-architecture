package me.jeeson.android.komvp.demo.mvp.model

import io.reactivex.Observable
import javax.inject.Inject

import me.jeeson.android.komvp.core.di.scope.ActivityScope
import me.jeeson.android.komvp.core.integration.manager.IRepositoryManager
import me.jeeson.android.komvp.demo.mvp.contract.MainContract
import me.jeeson.android.komvp.mvp.base.BaseModel
import java.util.concurrent.TimeUnit

@ActivityScope
class MainModel @Inject
constructor(repositoryManager: IRepositoryManager) : BaseModel(repositoryManager), MainContract.Model {

    override fun test(): Observable<Long>? {
        return Observable.interval(5, TimeUnit.SECONDS)
    }
}