package com.example.maxzonov.modersoft_testproject.ui.main;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.maxzonov.modersoft_testproject.model.Blocks;
import com.example.maxzonov.modersoft_testproject.model.Catalog;
import com.example.maxzonov.modersoft_testproject.model.Category;
import com.example.maxzonov.modersoft_testproject.model.Data;
import com.example.maxzonov.modersoft_testproject.model.ResponseData;
import com.example.maxzonov.modersoft_testproject.model.Share;
import com.example.maxzonov.modersoft_testproject.retrofit.ApiService;
import com.example.maxzonov.modersoft_testproject.retrofit.RetrofitClient;

import java.util.ArrayList;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {

    private static final String CITY_ID = "468902";

    private ApiService apiService;

    public MainPresenter() {
        apiService = RetrofitClient.getApiService();
    }

    public void getData() {
        Call<ResponseData> call = apiService.getJson(CITY_ID);
        call.enqueue(new Callback<ResponseData>() {
            @Override
            public void onResponse(Call<ResponseData> call, Response<ResponseData> response) {
                if (response.isSuccessful()) {
                    Data data = response.body().getData();
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
            }

            @Override
            public void onFailure(Call<ResponseData> call, Throwable t) {
            }
        });
    }

    private void chooseRandomShare(Share share) {

        String shareCount = share.getCount();

        Random random = new Random();
        int randomShare = random.nextInt(Integer.parseInt(shareCount));

        String shareLabel = share.getLists().get(randomShare).getName();
        String shareImageUrl = share.getLists().get(randomShare).getIconUrl();
        String shareCompanyIcon = share.getLists().get(randomShare).getCompanyImage();
        String shareCompanyName = share.getLists().get(randomShare).getCompanyName();

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
