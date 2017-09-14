package org.murashov.kotlinandroidarchitecture.presentation.navigation

import android.os.Bundle
import org.murashov.kotlinandroidarchitecture.presentation.view.fragment.BaseFragment
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by artemmurashov on 8/31/17.
 */
@Singleton
class FragmentFactory @Inject constructor() {
    fun create(screenKey: String, args: Bundle? = null): BaseFragment {
        throw NotImplementedError()
    }
}