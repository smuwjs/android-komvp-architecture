package me.jeeson.android.komvp.core.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.trello.rxlifecycle2.android.ActivityEvent
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.Subject
import me.jeeson.android.komvp.core.integration.lifecycle.ActivityLifecycleable
import javax.inject.Inject

/**
 * @Description:
 * @Anthor: Jeeson
 * @Time: 2017/8/31 15:44
 */
abstract class BaseActivity : AppCompatActivity(), IBaseActivity, HasSupportFragmentInjector, ActivityLifecycleable {

    @Inject
    lateinit var mFragmentInjector: DispatchingAndroidInjector<Fragment>

    internal val mLifecycleSubject = BehaviorSubject.create<ActivityEvent>()

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return mFragmentInjector
    }


    override fun provideLifecycleSubject(): Subject<ActivityEvent> {
        return mLifecycleSubject
    }


}