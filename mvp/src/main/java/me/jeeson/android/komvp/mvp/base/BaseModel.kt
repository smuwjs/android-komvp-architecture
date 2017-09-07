package me.jeeson.android.komvp.mvp.base

import me.jeeson.android.komvp.core.integration.manager.IRepositoryManager
import me.jeeson.android.komvp.mvp.IModel

open class BaseModel(var mRepositoryManager: IRepositoryManager?) : IModel {

    override fun onDestroy() {
        mRepositoryManager = null
    }
}
