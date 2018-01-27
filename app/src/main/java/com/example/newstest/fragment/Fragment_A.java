package com.example.newstest.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.newstest.LinearAdapter;
import com.example.newstest.MainActivity;
import com.example.newstest.R;
import com.example.newstest.bean.News;
import com.example.newstest.bean.NewsGson;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONArray;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by sl on 2018/1/24.
 */

public class Fragment_A extends Fragment {

    private RecyclerView recyclerView;
    private NewsGson newsGson ;
    private static final int UPDATE=0;
    private List<NewsGson.News> newList;
    private String AllUrl;
    private LinearAdapter adapter;
    private SwipeRefreshLayout swipeRefresh;
    private String num[]= {"2","3","4","5","6","7","8","9","10","11","12","13","14","15","16"
    ,"17","18","19","20","21","22","23","24","25","26","27","28","29","30"};
    private int i;
    private NewsGson.News[] mList={new NewsGson.News("555","已经到头了","静静日报","http://img2.imgtn.bdimg.com/it/u=2326844720,686927082&fm=27&gp=0.jpg","https://m.baidu.com")};

    public static Fragment_A newInstance(String url){
        Fragment_A fragment_a = new Fragment_A();
        Bundle bundle = new Bundle();
        bundle.putString("URL",url);
        fragment_a.setArguments(bundle);
        return fragment_a;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a,container,false);
        initUrl();

        RequestInfo();
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerView.addItemDecoration(new Mydecoration());

        swipeRefresh = (SwipeRefreshLayout) view.findViewById(R.id.refresh);
        swipeRefresh.setColorSchemeResources(R.color.colorPrimary);
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshNews();
            }
        });

        return view;
    }

    class Mydecoration extends RecyclerView.ItemDecoration{
        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.set(0,0,0,15);
        }
    }

    private void RequestInfo() {
        String url = AllUrl;
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Toast.makeText(getActivity(),e.getMessage().toString(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    String json = response.body().string();
                    Log.i("myshoso", json);
                    Gson gson = new Gson();
                    newsGson = gson.fromJson(json, NewsGson.class);
                    if (newsGson.getCode() == 200){
                        if (newList != null){
                            //newList.clear();
                            newList = newsGson.getNewsList();
                        }else {
                            newList = newsGson.getNewsList();
                        }
                        handler.sendEmptyMessage(UPDATE);
                    }else if (newsGson.getCode() == 250){
                        newList.add(mList[0]);
                    }
                }

            }
        });
    }

    private android.os.Handler handler = new android.os.Handler(){
        public void handleMessage(Message msg){
            super.handleMessage(msg);
            switch (msg.what){
                case UPDATE:
                    initRecycler();
                    break;
            }
        }
    };

    private void initRecycler(){
        adapter = new LinearAdapter(this.getContext(),newList);
        recyclerView.setAdapter(adapter);
    }

    public void refreshNews(){
        i=i+1;
        AllUrl = AllUrl+"&page="+num[i];
        RequestInfo();
        adapter.notifyDataSetChanged();
        swipeRefresh.setRefreshing(false);
    }

    private void initUrl(){
        if (getArguments() != null){
            AllUrl = getArguments().getString("URL");
        }else {
            AllUrl = "http://api.tianapi.com/wxnew/?key=d5e38f3cf90f844bc47b6c663481edfe&num=30";
        }
    }
}
