package com.example.maxzonov.modersoft_testproject.di.component;

import com.example.maxzonov.modersoft_testproject.di.module.AppModule;
import com.example.maxzonov.modersoft_testproject.di.module.MainFragmentModule;
import com.example.maxzonov.modersoft_testproject.di.module.NavigatorModule;
import com.example.maxzonov.modersoft_testproject.di.module.OtherFragmentModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(
        modules = {
                AppModule.class,
                MainFragmentModule.class,
                OtherFragmentModule.class
        })
public interface AppComponent {
    SubComponent subComponent(NavigatorModule navigatorModule);
}
