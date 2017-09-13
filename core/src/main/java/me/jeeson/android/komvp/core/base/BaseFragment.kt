package me.jeeson.android.komvp.core.base

import android.content.Context
import android.support.v4.app.Fragment
import com.trello.rxlifecycle2.android.FragmentEvent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.HasSupportFragmentInjector
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.Subject
import me.jeeson.android.komvp.core.integration.lifecycle.FragmentLifecycleable
import javax.inject.Inject

/**
 * @Description:
 * @Anthor: Jeeson
 * @Time: 2017/8/31 15:51
 */
abstract class BaseFragment : Fragment(), IBaseFragment, HasSupportFragmentInjector, FragmentLifecycleable {

    @Inject
    lateinit var childFragmentInjector: DispatchingAndroidInjector<Fragment>

    internal val mLifecycleSubject = BehaviorSubject.create<FragmentEvent>()

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return childFragmentInjector
    }

    override fun provideLifecycleSubject(): Subject<FragmentEvent> {
        return mLifecycleSubject
    }
}