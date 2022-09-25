package com.moengageassignment.fragments;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.moengageassignment.R;
import com.moengageassignment.databinding.FragmentNewsDetailsBinding;

import java.util.Collections;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsDetails extends Fragment  {
    View view;
    FragmentNewsDetailsBinding fragmentNewsDetailsBinding;
    ProgressDialog progressDialog;
    public NewsDetails() {
        // Required empty public constructor
    }

String newsUrl="";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            String url = getArguments().getString("newsURL");

            if(url!=null)
               this.newsUrl=url;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentNewsDetailsBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_news_details, container, false);
        view = fragmentNewsDetailsBinding.getRoot();
        init();
        return view;
    }

    private void init() {

        WebView webView = fragmentNewsDetailsBinding.webviewNewsdetails;

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        Log.d("url:" , newsUrl);
        webView.loadUrl(newsUrl);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);

                return true;
            }
            public void onPageFinished(WebView view, String url) {
fragmentNewsDetailsBinding.progressBar.setVisibility(View.GONE);

            }
        });

    }

   }