package com.example.maxzonov.modersoft_testproject.di.module;

import android.support.v4.app.Fragment;

import com.example.maxzonov.modersoft_testproject.ui.other.OtherFragment;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class OtherFragmentModule {

    @Named("other_fragment")
    @Provides
    public Fragment otherFragment() {
        return new OtherFragment();
    }
}
