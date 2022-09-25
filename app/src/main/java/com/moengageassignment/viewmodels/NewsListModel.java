package com.moengageassignment.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.moengageassignment.activities.MainActivity;
import com.moengageassignment.models.Article;
import com.moengageassignment.models.News;
import com.moengageassignment.repositories.NewsListRepository;

import java.util.ArrayList;
import java.util.List;

public class NewsListModel  extends AndroidViewModel {
    private NewsListRepository newsListRepository;
    private MutableLiveData<ArrayList<Article>> mutableLiveData;
    public NewsListModel(@NonNull MainActivity application) {
        super(application.getApplication());
        newsListRepository=new NewsListRepository(application);
    }

    public MutableLiveData<ArrayList<Article>> getNewsData() {
        if(mutableLiveData==null){
            mutableLiveData = newsListRepository.getNewsData();
        }
        return mutableLiveData;
    }
}
