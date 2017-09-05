package me.jeeson.android.komvp.core.delegate

import android.app.Application
import android.content.Context
import me.jeeson.android.komvp.core.base.IBaseApplication

/**
 * @Description:
 * @Anthor: Jeeson
 * @Time: 2017/8/31 16:17
 */
interface ApplicationDelegate : IBaseApplication{

    /**
     * 在Application创建时调用
     */
    fun onCreate(application: Application)

    /**
     * 在模拟环境中程序终止时会被调用
     */
    fun onTerminate()


    fun attachBaseContext(base: Context?)
}