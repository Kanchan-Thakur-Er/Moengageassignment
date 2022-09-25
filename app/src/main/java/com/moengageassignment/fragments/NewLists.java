package com.moengageassignment.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.moengageassignment.R;
import com.moengageassignment.activities.MainActivity;
import com.moengageassignment.adapter.ArticleAdapter;
import com.moengageassignment.databinding.FragmentNewListsBinding;
import com.moengageassignment.models.Article;
import com.moengageassignment.viewmodels.NewsListModel;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 *
 */
public class NewLists extends Fragment implements View.OnClickListener {
    FragmentNewListsBinding fragmentNewListsBinding;
    private View view;
ArrayList<Article> articleArrayList;
    public NewLists() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }
    ArticleAdapter articleAdapter;
    private void setNewsList(ArrayList<Article> articleArrayList) {
        this.articleArrayList=articleArrayList;
         articleAdapter = new ArticleAdapter(getActivity().getApplicationContext(), articleArrayList);
        fragmentNewListsBinding.rvNewsList.setAdapter(articleAdapter);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        fragmentNewListsBinding.rvNewsList.setLayoutManager(manager);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentNewListsBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_new_lists, container, false);
        view = fragmentNewListsBinding.getRoot();
        init();
        return view;
    }

    private void init() {
        fragmentNewListsBinding.btnSortNew.setOnClickListener(this);
        fragmentNewListsBinding.btnSortOld.setOnClickListener(this);
        NewsListModel newsListModel = ((MainActivity)getActivity()).getViewModel();
        newsListModel.getNewsData().observe(getActivity(), new Observer<ArrayList<Article>>() {
            @Override
            public void onChanged(ArrayList<Article> articleArrayList) {
                setNewsList(articleArrayList);

            }
        });

    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnSortNew:
                Collections.sort(articleArrayList, new Comparator<Article >() {
                    @Override
                    public int compare(Article article1, Article article2) {
                        DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH);
                        Date date1 = null, date2= null;
                        try {
                            date1 = format.parse(article1.getPublishedAt());
                            date2 = format.parse(article2.getPublishedAt());
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }

                        return date1.compareTo(date2);

                    }
                });
                articleAdapter.notifyDataSetChanged();


                break;
            case R.id.btnSortOld:
                Collections.sort(articleArrayList, new Comparator<Article >() {
                    @Override
                    public int compare(Article article1, Article article2) {
                        DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH);
                        Date date1 = null, date2= null;
                        try {
                            date1 = format.parse(article1.getPublishedAt());
                            date2 = format.parse(article2.getPublishedAt());
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }

                        return date2.compareTo(date1);

                    }
                });
                articleAdapter.notifyDataSetChanged();
                break;
        }
    }
}