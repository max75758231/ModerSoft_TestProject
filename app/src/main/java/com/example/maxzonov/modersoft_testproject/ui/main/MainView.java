package com.example.maxzonov.modersoft_testproject.ui.main;

import com.arellomobile.mvp.MvpView;
import com.example.maxzonov.modersoft_testproject.model.Catalog;
import com.example.maxzonov.modersoft_testproject.model.Category;

import java.util.ArrayList;

public interface MainView extends MvpView {

    void showShare(String count, String label, String imageUrl,
                   String companyIconUrl, String companyName);

    void showCategory(String count, ArrayList<Category> categories);

    void showCatalog(String count, ArrayList<Catalog> catalogs);

    void configureToolbar(String imageUrl, String title);

    void hideSplashImage();

    void onResponseError();
}
