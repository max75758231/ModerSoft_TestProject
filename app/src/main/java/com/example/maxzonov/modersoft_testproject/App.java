package com.example.maxzonov.modersoft_testproject;

import android.app.Application;
import android.content.Context;

import com.example.maxzonov.modersoft_testproject.di.component.AppComponent;
import com.example.maxzonov.modersoft_testproject.di.component.DaggerAppComponent;
import com.example.maxzonov.modersoft_testproject.di.module.AppModule;

public class App extends Application {

    private AppComponent appComponent;

    public static AppComponent getAppComponent(Context context) {
        return ((App) context.getApplicationContext()).appComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }
}
