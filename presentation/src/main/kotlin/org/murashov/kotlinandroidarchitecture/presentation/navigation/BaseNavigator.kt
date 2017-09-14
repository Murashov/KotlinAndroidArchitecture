package org.murashov.kotlinandroidarchitecture.presentation.navigation

import android.content.Intent
import android.os.Bundle
import org.murashov.kotlinandroidarchitecture.presentation.view.activity.BaseActivity
import ru.terrakok.cicerone.Navigator

/**
 * Created by artemmurashov on 8/28/17.
 */
abstract class BaseNavigator(
        protected val activity: BaseActivity,
        private val factory: FragmentFactory
) : Navigator {
    protected fun changeActivity(intent: Intent, newTask: Boolean) {
        if (newTask) {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }

        activity.startActivity(intent)
    }

    protected fun changeFragment(screenKey: String, args: Bundle?, newStack: Boolean) {
        val transaction = activity.supportFragmentManager.beginTransaction()
                .replace(activity.fragmentContainerId, factory.create(screenKey, args))

        if (!newStack) {
            transaction.addToBackStack(screenKey)
        }

        transaction.commit()
    }

    protected fun backTo(screenKey: String?) {
        activity.supportFragmentManager.popBackStackImmediate(screenKey, 0)
    }
}