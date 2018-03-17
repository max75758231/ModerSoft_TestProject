package com.example.maxzonov.modersoft_testproject.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.maxzonov.modersoft_testproject.R;
import com.example.maxzonov.modersoft_testproject.model.Catalog;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CatalogAdapter extends RecyclerView.Adapter<CatalogAdapter.CatalogViewHolder> {

    private ArrayList<Catalog> catalogs;

    public CatalogAdapter(ArrayList<Catalog> catalogs) {
        this.catalogs = catalogs;
    }

    @NonNull
    @Override
    public CatalogViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.catalog_item_view, parent, false);
        return new CatalogViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CatalogViewHolder holder, int position) {
        String name = catalogs.get(position).getName();
        String rating = catalogs.get(position).getRating();
        String street = catalogs.get(position).getStreet();
        String house = catalogs.get(position).getHouse();
        String imageUrl = catalogs.get(position).getImage().getImageUrl();

        holder.textViewName.setText(name);
        holder.textViewRating.setText(rating);
        holder.textViewAddress.setText(street + ", " + house);
        holder.ratingBar.setRating(Float.parseFloat(rating));
        Picasso.get().load(imageUrl).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return catalogs.size();
    }


    public class CatalogViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.catalog_item_iv) ImageView imageView;
        @BindView(R.id.catalog_item_tv_name) TextView textViewName;
        @BindView(R.id.catalog_item_tv_rating) TextView textViewRating;
        @BindView(R.id.catalog_item_tv_address) TextView textViewAddress;
        @BindView(R.id.catalog_item_rb) RatingBar ratingBar;

        public CatalogViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
