package me.jeeson.android.komvp.core.lifecycle

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.view.View

import com.trello.rxlifecycle2.android.FragmentEvent

import io.reactivex.subjects.Subject


class FragmentLifecycleForRxLifecycle : FragmentManager.FragmentLifecycleCallbacks() {

    override fun onFragmentAttached(fm: FragmentManager?, f: Fragment?, context: Context?) {
        if (f is FragmentLifecycleable) {
            obtainSubject(f).onNext(FragmentEvent.ATTACH)
        }
    }


    override fun onFragmentCreated(fm: FragmentManager?, f: Fragment?, savedInstanceState: Bundle?) {
        if (f is FragmentLifecycleable) {
            obtainSubject(f).onNext(FragmentEvent.CREATE)
        }
    }


    override fun onFragmentViewCreated(fm: FragmentManager?, f: Fragment?, v: View?, savedInstanceState: Bundle?) {
        if (f is FragmentLifecycleable) {
            obtainSubject(f).onNext(FragmentEvent.CREATE_VIEW)
        }
    }

    override fun onFragmentStarted(fm: FragmentManager?, f: Fragment?) {
        if (f is FragmentLifecycleable) {
            obtainSubject(f).onNext(FragmentEvent.START)
        }
    }

    override fun onFragmentResumed(fm: FragmentManager?, f: Fragment?) {
        if (f is FragmentLifecycleable) {
            obtainSubject(f).onNext(FragmentEvent.RESUME)
        }
    }

    override fun onFragmentPaused(fm: FragmentManager?, f: Fragment?) {
        if (f is FragmentLifecycleable) {
            obtainSubject(f).onNext(FragmentEvent.PAUSE)
        }
    }

    override fun onFragmentStopped(fm: FragmentManager?, f: Fragment?) {
        if (f is FragmentLifecycleable) {
            obtainSubject(f).onNext(FragmentEvent.STOP)
        }
    }

    override fun onFragmentViewDestroyed(fm: FragmentManager?, f: Fragment?) {
        if (f is FragmentLifecycleable) {
            obtainSubject(f).onNext(FragmentEvent.DESTROY_VIEW)
        }
    }

    override fun onFragmentDestroyed(fm: FragmentManager?, f: Fragment?) {
        if (f is FragmentLifecycleable) {
            obtainSubject(f).onNext(FragmentEvent.DESTROY)
        }
    }

    override fun onFragmentDetached(fm: FragmentManager?, f: Fragment?) {
        if (f is FragmentLifecycleable) {
            obtainSubject(f).onNext(FragmentEvent.DETACH)
        }
    }

    private fun obtainSubject(fragment: Fragment): Subject<FragmentEvent> {
        return (fragment as FragmentLifecycleable).provideLifecycleSubject()
    }
}
