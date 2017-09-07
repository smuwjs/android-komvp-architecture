package me.jeeson.android.komvp.core.integration.lifecycle

import io.reactivex.subjects.Subject

interface Lifecycleable<E> {
    fun provideLifecycleSubject(): Subject<E>
}
