package me.jeeson.android.komvp.mvp.util

import com.trello.rxlifecycle2.LifecycleTransformer
import com.trello.rxlifecycle2.android.ActivityEvent
import com.trello.rxlifecycle2.android.FragmentEvent

import io.reactivex.annotations.NonNull
import me.jeeson.android.komvp.core.integration.lifecycle.ActivityLifecycleable
import me.jeeson.android.komvp.core.integration.lifecycle.FragmentLifecycleable
import me.jeeson.android.komvp.core.integration.lifecycle.Lifecycleable
import me.jeeson.android.komvp.core.utils.Preconditions
import me.jeeson.android.komvp.core.utils.RxLifecycleUtils
import me.jeeson.android.komvp.mvp.IView

/**
 * @Description:
 * *
 * @Anthor: Jeeson
 * *
 * @Time: 2017/9/7 11:43
 */
class MVPRxLifecycleUtils : RxLifecycleUtils() {
    companion object {

        /**
         * 绑定 Activity 的指定生命周期

         * @param view
         * *
         * @param event
         * *
         * @param <T>
         * *
         * @return
        </T> */
        fun <T> bindUntilEvent(@NonNull view: IView,
                               event: ActivityEvent): LifecycleTransformer<T> {
            Preconditions.checkNotNull(view, "view == null")
            if (view is ActivityLifecycleable) {
                return bindUntilEvent(view, event)
            } else {
                throw IllegalArgumentException("view isn't ActivityLifecycleable")
            }
        }

        /**
         * 绑定 Fragment 的指定生命周期

         * @param view
         * *
         * @param event
         * *
         * @param <T>
         * *
         * @return
        </T> */
        fun <T> bindUntilEvent(@NonNull view: IView,
                               event: FragmentEvent): LifecycleTransformer<T> {
            Preconditions.checkNotNull(view, "view == null")
            if (view is FragmentLifecycleable) {
                return bindUntilEvent(view, event)
            } else {
                throw IllegalArgumentException("view isn't FragmentLifecycleable")
            }
        }

        /**
         * 绑定 Activity/Fragment 的生命周期

         * @param view
         * *
         * @param <T>
         * *
         * @return
        </T> */
        fun <T> bindToLifecycle(@NonNull view: IView?): LifecycleTransformer<T> {
            Preconditions.checkNotNull(view, "view == null")
            if (view is Lifecycleable<*>) {
                return bindToLifecycle( view as Lifecycleable<*>)
            } else {
                throw IllegalArgumentException("view isn't Lifecycleable")
            }
        }
    }
}
