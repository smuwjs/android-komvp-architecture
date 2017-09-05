package me.jeeson.android.komvp.core.base

import me.jeeson.android.komvp.core.di.component.ApplicationComponent

/**
 * @Description:
 * @Anthor: Jeeson
 * @Time: 2017/8/31 15:53
 */
interface IBaseApplication{

    /**
     * 将ApplicationComponent返回出去,供其它地方使用

     * @return
     */
    fun getApplicationComponent(): ApplicationComponent?
}