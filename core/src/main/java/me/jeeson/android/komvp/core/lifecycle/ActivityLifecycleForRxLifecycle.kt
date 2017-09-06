package me.jeeson.android.komvp.core.lifecycle

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager

import com.trello.rxlifecycle2.android.ActivityEvent

import javax.inject.Inject
import javax.inject.Singleton

import io.reactivex.subjects.Subject


class ActivityLifecycleForRxLifecycle : Application.ActivityLifecycleCallbacks {

    private var mFragmentLifecycle: FragmentManager.FragmentLifecycleCallbacks? = null

    override fun onActivityCreated(activity: Activity?, savedInstanceState: Bundle?) {
        if (activity is ActivityLifecycleable) {
            obtainSubject(activity).onNext(ActivityEvent.CREATE)
            if (activity is FragmentActivity) {
                if (mFragmentLifecycle == null) {
                    mFragmentLifecycle = FragmentLifecycleForRxLifecycle()
                }
                activity.supportFragmentManager.registerFragmentLifecycleCallbacks(mFragmentLifecycle, true)
            }
        }
    }

    override fun onActivityStarted(activity: Activity?) {
        if (activity is ActivityLifecycleable) {
            obtainSubject(activity).onNext(ActivityEvent.START)
        }
    }

    override fun onActivityResumed(activity: Activity?) {
        if (activity is ActivityLifecycleable) {
            obtainSubject(activity).onNext(ActivityEvent.RESUME)
        }
    }

    override fun onActivityPaused(activity: Activity?) {
        if (activity is ActivityLifecycleable) {
            obtainSubject(activity).onNext(ActivityEvent.PAUSE)
        }
    }

    override fun onActivityStopped(activity: Activity?) {
        if (activity is ActivityLifecycleable) {
            obtainSubject(activity).onNext(ActivityEvent.STOP)
        }
    }

    override fun onActivitySaveInstanceState(activity: Activity?, outState: Bundle?) {

    }

    override fun onActivityDestroyed(activity: Activity?) {
        if (activity is ActivityLifecycleable) {
            obtainSubject(activity).onNext(ActivityEvent.DESTROY)
        }
    }

    private fun obtainSubject(activity: Activity?): Subject<ActivityEvent> {
        return (activity as ActivityLifecycleable).provideLifecycleSubject()
    }
}
