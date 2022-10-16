package com.moengageassignment.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.databinding.DataBindingUtil;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.moengageassignment.R;
import com.moengageassignment.databinding.NewsItemsBinding;
import com.moengageassignment.models.Article;

import java.io.InputStream;
import java.util.ArrayList;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.MyViewHolder> {

    private Context mContext;
    private ArrayList<Article> articleArrayList;

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView newsurl, newsTitle;
        public ImageView imgNews;
        public NewsItemsBinding newsItemsBinding;

        public MyViewHolder(NewsItemsBinding newsItemsBinding) {
            super(newsItemsBinding.getRoot());
            this.newsItemsBinding = newsItemsBinding;
            newsurl = newsItemsBinding.tvNewsURL;
            newsTitle = newsItemsBinding.tvnewsTitle;
            imgNews = newsItemsBinding.imgNews;
            newsurl.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.tvNewsURL:
                    Bundle bundle = new Bundle();
                    if (articleArrayList.get(getAdapterPosition()).getUrl() != null) {
                        bundle.putString("newsURL", articleArrayList.get(getAdapterPosition()).getUrl());
                    }
                    Navigation.findNavController(view).navigate(R.id.newdDetails, bundle);
                    break;


            }
        }
    }


    public ArticleAdapter(Context mContext, ArrayList<Article> articleArrayList) {
        this.mContext = mContext;
        this.articleArrayList = articleArrayList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        NewsItemsBinding itemView = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.news_items, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Article article = articleArrayList.get(position);
        holder.newsTitle.setText(article.getTitle());
        if (article.getUrlToImage() != null && article.getUrlToImage() != "") {
            new DownloadImageFromInternet(holder.imgNews, article.getUrlToImage()).execute("1");
        }


    }

    private class DownloadImageFromInternet extends AsyncTask<String, Void, Bitmap> {
        ImageView imageView;
        public String urlImage;

        public DownloadImageFromInternet(ImageView imageView, String urlToImage) {
            this.imageView = imageView;
            this.urlImage = urlToImage;

        }

        protected Bitmap doInBackground(String... urls) {

            Bitmap bimage = null;
            try {
                InputStream in = new java.net.URL(urlImage).openStream();
                bimage = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error Message", e.getMessage());

                bimage = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.ic_home_24dp);

                e.printStackTrace();
            }
            return bimage;
        }

        protected void onPostExecute(Bitmap result) {
            if (result != null)
                imageView.setImageBitmap(result);
        }
    }


    @Override
    public int getItemCount() {
        return articleArrayList.size();
    }
}