package com.example.maxzonov.modersoft_testproject.di.module;

import com.example.maxzonov.modersoft_testproject.di.scope.PerActivity;
import com.example.maxzonov.modersoft_testproject.navigation.AppNavigator;

import dagger.Module;
import dagger.Provides;

@Module
public class NavigatorModule {

    private final AppNavigator navigator;

    public NavigatorModule(AppNavigator navigator) {
        this.navigator = navigator;
    }

    @PerActivity
    @Provides
    AppNavigator provideAppNavigator() {
        return navigator;
    }
}
