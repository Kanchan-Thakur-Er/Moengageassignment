package com.moengageassignment.repositories;

import androidx.lifecycle.MutableLiveData;

import com.moengageassignment.activities.MainActivity;
import com.moengageassignment.apiservices.NewsListAsync;
import com.moengageassignment.config.Constant;
import com.moengageassignment.models.Article;
import java.util.ArrayList;

public class NewsListRepository {

    private MutableLiveData<ArrayList<Article>> newsList;
    MainActivity application;

    public NewsListRepository(MainActivity application) {
        newsList = new MutableLiveData<>();
        this.application=application;

   getNewsLists(Constant.BASE_URl);

    }

    public void getNewsLists(String url) {


     new NewsListAsync(new NewsListAsync.NewsAsyncResponse() {
            @Override
            public void processFinish(ArrayList<Article> output) {
                if(output!=null)
                    newsList.postValue(output);
            }
        } ,application).execute("5");

    }

    public MutableLiveData<ArrayList<Article>> getNewsData() {

        return newsList;
    }


}
