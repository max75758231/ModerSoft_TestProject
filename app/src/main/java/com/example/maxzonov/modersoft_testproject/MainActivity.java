package com.example.maxzonov.modersoft_testproject;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.maxzonov.modersoft_testproject.di.component.SubComponent;
import com.example.maxzonov.modersoft_testproject.di.module.NavigatorModule;
import com.example.maxzonov.modersoft_testproject.navigation.AppNavigator;

import javax.inject.Inject;
import javax.inject.Named;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.nav_view) NavigationView navigationView;
    @BindView(R.id.main_iv_header) ImageView imageViewMainHeader;
    @BindView(R.id.main_collapsing_toolbar) CollapsingToolbarLayout collapsingToolbarLayout;
    @BindView(R.id.app_bar) AppBarLayout appBar;

    private AppNavigator appNavigator;

    @Inject @Named("main_fragment") Fragment fragmentMain;
    @Inject @Named("other_fragment") Fragment fragmentOther;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        setSupportActionBar(toolbar);

        appNavigator = new AppNavigator(getSupportFragmentManager());

        SubComponent subComponent = App.getAppComponent(this)
                .subComponent(new NavigatorModule(appNavigator));
        subComponent.inject(this);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        appNavigator.navigateToFragment(fragmentMain);

        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.nav_main:

                configureToolbar(getString(R.string.nav_main),
                        getResources().getColor(R.color.colorFullTransparent), true);
                break;
            case R.id.nav_share:

                configureToolbar(getString(R.string.nav_share),
                        getResources().getColor(R.color.colorHeaderYellow), false);
                break;
            case R.id.nav_category:
                configureToolbar(getString(R.string.nav_category),
                        getResources().getColor(R.color.colorHeaderCyan), false);
                break;
            case R.id.nav_catalog:
                configureToolbar(getString(R.string.nav_catalog),
                        getResources().getColor(R.color.colorHeaderGreen), false);
                break;
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @TargetApi(Build.VERSION_CODES.M)
    private void configureToolbar(String title, int backgroundColor, boolean isMainFragment) {
        if (isMainFragment) {
            appBar.setExpanded(true);
            imageViewMainHeader.setVisibility(View.VISIBLE);
            appNavigator.navigateToFragment(fragmentMain);
            toolbar.setBackgroundColor(backgroundColor);
            navigationView.getHeaderView(0).setBackgroundColor(getColor(R.color.colorPrimary));
        } else {
            appBar.setExpanded(false);
            toolbar.setBackgroundColor(backgroundColor);
            navigationView.getHeaderView(0).setBackgroundColor(backgroundColor);
            collapsingToolbarLayout.setTitle(title);
            appNavigator.navigateToFragment(fragmentOther);
        }
    }
}