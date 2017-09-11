package com.igor040897.vkgroup.common.manager;

import android.support.annotation.IdRes;
import android.support.v4.app.FragmentTransaction;

import com.igor040897.vkgroup.ui.activity.BaseActivity;
import com.igor040897.vkgroup.ui.fragment.BaseFragment;

import java.util.Stack;

/**
 * Created by fanre on 8/20/2017.
 */

public class MyFragmentManager {
    public static final int EMPTY_FRAGMENT_STACK_SIZE = 1;

    private Stack<BaseFragment> fragmentStack = new Stack<>();
    private BaseFragment currentFragment;

    public void setFragment(BaseActivity activity, BaseFragment fragment, @IdRes int containerId) {
        if (activity != null && !activity.isFinishing() && !isAlreadyContains(fragment)) {
            FragmentTransaction transaction = createAddTransaction(activity, fragment, false);
            transaction.replace(containerId, fragment);
            commitAddTransaction(activity, fragment, transaction, false);
        }
    }

    public void addFragment(BaseActivity activity, BaseFragment fragment, @IdRes int containerId) {
        if (activity != null && !activity.isFinishing() && !isAlreadyContains(fragment)) {
            FragmentTransaction transaction = createAddTransaction(activity, fragment, true);
            transaction.add(containerId, fragment);
            commitAddTransaction(activity, fragment, transaction, true);
        }
    }

    private FragmentTransaction createAddTransaction(BaseActivity activity, BaseFragment fragment, boolean addToBackStack) {
        FragmentTransaction fragmentTransaction = activity.getSupportFragmentManager().beginTransaction();

        if (addToBackStack) {
            fragmentTransaction.addToBackStack(fragment.getTag());
        }
        return fragmentTransaction;
    }

    private void commitAddTransaction(BaseActivity activity, BaseFragment fragment, FragmentTransaction transaction,
                                      boolean addToBackStack) {
        if (transaction != null) {
            currentFragment = fragment;

            if (!addToBackStack) {
                fragmentStack = new Stack<>();
            }

            fragmentStack.add(fragment);

            commitTransaction(activity, transaction);
        }
    }

    public boolean removeCurrentFragment(BaseActivity activity){
        return removeFragment(activity, currentFragment);
    }

    public boolean removeFragment(BaseActivity activity, BaseFragment fragment) {
        boolean canRemove = fragment != null && fragmentStack.size() > EMPTY_FRAGMENT_STACK_SIZE;
        if(canRemove){
            FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
            fragmentStack.pop();
            currentFragment = fragmentStack.lastElement();
            transaction.remove(fragment);
            commitTransaction(activity, transaction);
        }
        return canRemove;
    }

    private void commitTransaction(BaseActivity activity, FragmentTransaction transactiont) {
        transactiont.commit();
        activity.fragmentOnScreen(currentFragment);
    }

    public boolean isAlreadyContains(BaseFragment fragment) {
        if (fragment == null) {
            return false;
        }
        return currentFragment != null && currentFragment.getClass().getName().equals(fragment.getClass().getName());
    }
}
