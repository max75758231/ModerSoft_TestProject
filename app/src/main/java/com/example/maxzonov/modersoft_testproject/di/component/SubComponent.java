package com.example.maxzonov.modersoft_testproject.di.component;

import com.example.maxzonov.modersoft_testproject.MainActivity;
import com.example.maxzonov.modersoft_testproject.di.module.MainFragmentModule;
import com.example.maxzonov.modersoft_testproject.di.module.NavigatorModule;
import com.example.maxzonov.modersoft_testproject.di.module.OtherFragmentModule;
import com.example.maxzonov.modersoft_testproject.di.scope.PerActivity;

import dagger.Subcomponent;

@PerActivity
@Subcomponent (
        modules = {
                MainFragmentModule.class,
                OtherFragmentModule.class,
                NavigatorModule.class
        })
public interface SubComponent {

    void inject(MainActivity mainActivity);
}
