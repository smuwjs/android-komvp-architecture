package me.jeeson.android.komvp.core.utils

import com.trello.rxlifecycle2.LifecycleTransformer
import com.trello.rxlifecycle2.RxLifecycle
import com.trello.rxlifecycle2.android.RxLifecycleAndroid

import io.reactivex.annotations.NonNull
import me.jeeson.android.komvp.core.integration.lifecycle.ActivityLifecycleable
import me.jeeson.android.komvp.core.integration.lifecycle.FragmentLifecycleable
import me.jeeson.android.komvp.core.integration.lifecycle.Lifecycleable

open class RxLifecycleUtils {

    init {
        throw IllegalStateException("you can't instantiate me!")
    }

    companion object {

        fun <T, R> bindUntilEvent(@NonNull lifecycleable: Lifecycleable<R>,
                                  event: R): LifecycleTransformer<T> {
            Preconditions.checkNotNull(lifecycleable, "lifecycleable == null")
            return RxLifecycle.bindUntilEvent(lifecycleable.provideLifecycleSubject(), event)
        }

        fun <T> bindToLifecycle(@NonNull lifecycleable: Lifecycleable<*>): LifecycleTransformer<T> {
            Preconditions.checkNotNull(lifecycleable, "lifecycleable == null")
            if (lifecycleable is ActivityLifecycleable) {
                return RxLifecycleAndroid.bindActivity<T>(lifecycleable.provideLifecycleSubject())
            } else if (lifecycleable is FragmentLifecycleable) {
                return RxLifecycleAndroid.bindFragment<T>(lifecycleable.provideLifecycleSubject())
            } else {
                throw IllegalArgumentException("Lifecycleable not match")
            }
        }
    }

}
