package com.example.maxzonov.modersoft_testproject.ui.main;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.maxzonov.modersoft_testproject.R;
import com.example.maxzonov.modersoft_testproject.model.Catalog;
import com.example.maxzonov.modersoft_testproject.model.Category;
import com.example.maxzonov.modersoft_testproject.ui.adapter.CatalogAdapter;
import com.example.maxzonov.modersoft_testproject.ui.adapter.CategoryAdapter;
import com.example.maxzonov.modersoft_testproject.utils.InternetConnection;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainFragment extends MvpAppCompatFragment implements MainView {

    @InjectPresenter MainPresenter mainPresenter;

    @BindView(R.id.main_tv_share_count) TextView tvShareCount;
    @BindView(R.id.main_tv_share_label) TextView tvShareLabel;
    @BindView(R.id.main_iv_share_icon) ImageView ivShareImage;
    @BindView(R.id.main_iv_share_company) ImageView ivShareCompanyIcon;
    @BindView(R.id.main_tv_share_company) TextView tvShareCompanyName;

    @BindView(R.id.main_tv_category_count) TextView tvCategoryCount;
    @BindView(R.id.main_rv_category) RecyclerView rvCategory;

    @BindView(R.id.main_tv_catalog_count) TextView tvCatalogCount;
    @BindView(R.id.main_rv_catalog) RecyclerView rvCatalog;

    private ImageView ivMainToolbar;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private ProgressBar pbMain;
    private FrameLayout layoutMain;

    private Activity activity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof Activity) {
            activity = (Activity) context;
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);

        initCategoryRecyclerView();
        initCatalogRecyclerView();

        pbMain = activity.findViewById(R.id.main_pb);
        ivMainToolbar = activity.findViewById(R.id.main_iv_header);
        layoutMain = activity.findViewById(R.id.main_frame_layout);
        collapsingToolbarLayout = activity.findViewById(R.id.main_collapsing_toolbar);

        if (InternetConnection.isNetworkAvailable(activity)) {
            mainPresenter.getData();
        } else {
            Toast.makeText(activity, activity.getString(R.string.internet_connection_error),
                    Toast.LENGTH_LONG).show();
        }
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        if (activity != null)
            activity = null;
    }


    @Override
    public void onDetach() {
        super.onDetach();

        if (activity != null)
            activity = null;
    }

    @Override
    public void showShare(String count, String label, String imageUrl, String companyIconUrl, String companyName) {
        tvShareCount.setText(count);
        tvShareLabel.setText(label);
        Picasso.get().load(imageUrl).into(ivShareImage);
        Picasso.get().load(companyIconUrl).into(ivShareCompanyIcon);
        tvShareCompanyName.setText(companyName);
    }

    @Override
    public void showCategory(String count, ArrayList<Category> categories) {
        tvCategoryCount.setText(count);
        CategoryAdapter categoryAdapter = new CategoryAdapter(categories);
        rvCategory.setAdapter(categoryAdapter);
    }

    @Override
    public void showCatalog(String count, ArrayList<Catalog> catalogs) {
        tvCatalogCount.setText(count);
        CatalogAdapter catalogAdapter = new CatalogAdapter(catalogs);
        rvCatalog.setAdapter(catalogAdapter);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void configureToolbar(String imageUrl, String title) {
        Picasso.get().load(imageUrl).into(ivMainToolbar);
        collapsingToolbarLayout.setTitle(title);
    }

    @Override
    public void hideSplashImage() {
        pbMain.setVisibility(View.GONE);
        layoutMain.setVisibility(View.VISIBLE);
    }

    private void initCategoryRecyclerView() {
        LinearLayoutManager layoutManagerCategory =
                new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        rvCategory.setLayoutManager(layoutManagerCategory);
    }

    private void initCatalogRecyclerView() {
        LinearLayoutManager layoutManagerCatalog = new LinearLayoutManager(getContext());
        rvCatalog.setLayoutManager(layoutManagerCatalog);
    }
}