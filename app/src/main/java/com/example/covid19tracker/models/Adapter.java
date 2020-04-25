package com.example.covid19tracker.models;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.example.covid19tracker.R;
import com.example.covid19tracker.Utils;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
    private List<Countries> countries;
    private Context context;
    private AdapterView.OnItemClickListener onItemClickListener;
    public Adapter(List<Countries> countries, Context context) {
        this.countries = countries;
        this.context = context;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new Adapter.MyViewHolder(view);                                                                                                                    // This process happens over and over again for each

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holders, int position) {
        final MyViewHolder holder = holders;
        Countries model = countries.get(position);
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.placeholder(Utils.getRandomDrawbleColor());
        requestOptions.error(Utils.getRandomDrawbleColor());
        requestOptions.diskCacheStrategy(DiskCacheStrategy.ALL);
        requestOptions.centerCrop();

        Glide.with(context)
                .load(model.getUrlToImage())
                .apply(requestOptions)
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        //holder.progressBar.setVisibility(View.GONE);
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        //holder.progressBar.setVisibility(View.GONE);
                        return false;
                    }
                })
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(holder.flag);
                holder.countryName.setText("Country Name :- " + model.getCountry());
                holder.totalRecovered.setText("Total recovered :- " + model.getTotalRecovered());
                holder.totalDeaths.setText("Total deaths :- " + model.getTotalDeaths());
                holder.totalConfirmed.setText("Total confirmed :- " + model.getTotalConfirmed());
                holder.newDeaths.setText("New Deaths :- " + model.getNewDeaths());
                holder.newConfirmed.setText("New confirmed :- " + model.getNewConfirmed());
                holder.newRecovered.setText("New Recovered :- " + model.getNewRecovered());
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView countryName , newConfirmed , totalConfirmed , newDeaths , totalDeaths , newRecovered , totalRecovered;
        ImageView flag;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            countryName = itemView.findViewById(R.id.countryName);
            newConfirmed = itemView.findViewById(R.id.newConfirmed);
            totalConfirmed = itemView.findViewById(R.id.totalConfirmed);
            newDeaths = itemView.findViewById(R.id.newDeaths);
            totalDeaths = itemView.findViewById(R.id.totalDeaths);
            newRecovered = itemView.findViewById(R.id.newRecovered);
            totalRecovered = itemView.findViewById(R.id.totalRecovered);
            flag = itemView.findViewById(R.id.flag);
        }
    }
}
