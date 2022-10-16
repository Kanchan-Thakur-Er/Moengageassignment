package com.moengageassignment.activities;


import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;


import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.moengageassignment.R;

import com.moengageassignment.databinding.ActivityMainBinding;

import com.moengageassignment.viewmodels.NewsListModel;


public class MainActivity extends AppCompatActivity {
    ActivityMainBinding activityMainBinding;
    private AppBarConfiguration appBarConfiguration;
    public NewsListModel newsListModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());

        setSupportActionBar(activityMainBinding.toolbar);
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);


    }

    public NewsListModel getViewModel() {
        if (newsListModel == null)
            newsListModel = new NewsListModel(this);
        return newsListModel;
    }


    @Override
    protected void onResume() {
        Log.d("data", "onresume");
        getViewModel();
        super.onResume();
    }


    @Override
    protected void onStop() {
        Log.d("data", "OnStopCalled");


        super.onStop();
    }
}