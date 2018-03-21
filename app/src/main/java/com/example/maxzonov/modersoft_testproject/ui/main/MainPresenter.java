package com.example.maxzonov.modersoft_testproject.ui.main;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.maxzonov.modersoft_testproject.model.Blocks;
import com.example.maxzonov.modersoft_testproject.model.Catalog;
import com.example.maxzonov.modersoft_testproject.model.Category;
import com.example.maxzonov.modersoft_testproject.model.Data;
import com.example.maxzonov.modersoft_testproject.model.List;
import com.example.maxzonov.modersoft_testproject.model.ResponseData;
import com.example.maxzonov.modersoft_testproject.model.Share;
import com.example.maxzonov.modersoft_testproject.retrofit.ApiService;
import com.example.maxzonov.modersoft_testproject.retrofit.RetrofitClient;

import java.util.ArrayList;
import java.util.Random;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {

    private static final String CITY_ID = "468902";

    public void getData(CompositeDisposable compositeDisposable) {

        ApiService apiService = RetrofitClient.getApiService();
        compositeDisposable.add(apiService.getJson(CITY_ID)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::handleResponse, this::handleResponseError));
    }

    private void handleResponse(ResponseData responseData) {
        Data data = responseData.getData();
        Blocks blocks = data.getBlocks();
        Share share = blocks.getShare();

        chooseRandomShare(share);

        String categoryCount = String.valueOf(blocks.getCategories().size());

        ArrayList<Category> categories = blocks.getCategories();
        ArrayList<Catalog> catalogs = blocks.getCatalogs();

        filterArray(catalogs);

        String catalogCount = String.valueOf(catalogs.size());

        String mainHeaderImageUrl = data.getImage();
        String mainHeaderTitle = data.getTitle();

        getViewState().showCategory(categoryCount, categories);
        getViewState().showCatalog(catalogCount, catalogs);
        getViewState().configureToolbar(mainHeaderImageUrl, mainHeaderTitle);
        getViewState().hideSplashImage();
    }

    private void handleResponseError(Throwable error) {
        getViewState().onResponseError(error);
    }

    private void chooseRandomShare(Share share) {

        String shareCount = share.getCount();

        Random random = new Random();
        int randomShare = random.nextInt(Integer.parseInt(shareCount));

        List shareList = share.getLists().get(randomShare);

        String shareLabel = shareList.getName();
        String shareImageUrl = shareList.getIconUrl();
        String shareCompanyIcon = shareList.getCompanyImage();
        String shareCompanyName = shareList.getCompanyName();

        getViewState().showShare(shareCount, shareLabel, shareImageUrl, shareCompanyIcon, shareCompanyName);
    }

    /**
     * A method that removes unexisting (fake) or incorrect items
     * @param array catalog list
     */
    private void filterArray(ArrayList<Catalog> array) {

        for (int i = 0; i < array.size(); i++) {
            if (array.get(i).getName() == null) {
                array.remove(i);
            }
        }
    }
}