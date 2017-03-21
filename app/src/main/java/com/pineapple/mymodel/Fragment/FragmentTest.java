package com.pineapple.mymodel.Fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pineapple.mymodel.Adapter.RecyclerViewTest;
import com.pineapple.mymodel.DB.model.TestModel;
import com.pineapple.mymodel.Json.Example;
import com.pineapple.mymodel.R;
import com.pineapple.mymodel.Service.IService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FragmentTest extends Fragment {

    private static final String LOG_TAG = "Test";

    public RecyclerView mRecyclerView;
    public RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public List<TestModel> testList;

    private Retrofit retrofit;
    private static IService service;

    private String key;
    private String value;
    private String baseUrl;

    public FragmentTest() {
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_test, null);

        playRecyler(v);

        new AsynkTest().execute();

        return v;
    }


    private void playRecyler(View v) {
        mRecyclerView = (RecyclerView)v.findViewById(R.id.recycler_view);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new RecyclerViewTest((ArrayList) testList, getActivity());
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }

    private void playRetrofit() {
        retrofit = new Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build();
        service = retrofit.create(IService.class);
        service.listRepos(key, value).enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                try{

                    //Glide.with(FragmentWeater.this).load("http:"+ikon).centerCrop().into(imageWeather);
                    // Picasso.with(getActivity()).load("http:"+ikon).into(imageWeather);

                }catch (Exception e) {

                }
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {

            }
        });
    }

    private class AsynkTest extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {
            try {
                playRetrofit();
            }catch (Exception e) {

            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
        }
    }
}
