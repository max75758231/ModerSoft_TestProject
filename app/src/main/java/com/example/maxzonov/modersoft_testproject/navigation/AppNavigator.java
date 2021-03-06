package com.example.maxzonov.modersoft_testproject.navigation;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.example.maxzonov.modersoft_testproject.R;

public class AppNavigator implements PreviousNavigation {

    private final FragmentManager fragmentManager;

    public AppNavigator(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    /**
     * If backstack has previous fragment, it will be opened
     */
    @Override
    public void navigateToPreviousView() {
        if (hasPreviousView())
            fragmentManager.popBackStack();
    }

    private boolean hasPreviousView() {
        return fragmentManager.getBackStackEntryCount() > 0;
    }

    public void navigateToFragment(Fragment fragment) {
        replaceFragmentWithAddingToBackStack(fragment, "fragment");
    }

    private void replaceFragmentWithAddingToBackStack(Fragment fragment, String fragmentName) {
        fragmentManager.beginTransaction()
                .replace(R.id.main_frame_layout, fragment)
                .addToBackStack(fragmentName)
                .commit();
    }
}