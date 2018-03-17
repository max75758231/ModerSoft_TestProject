package com.example.maxzonov.modersoft_testproject.di.module;

import android.support.v4.app.Fragment;

import com.example.maxzonov.modersoft_testproject.ui.main.MainFragment;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class MainFragmentModule {

    @Named("main_fragment")
    @Provides
    public Fragment mainFragment() {
        return new MainFragment();
    }
}
