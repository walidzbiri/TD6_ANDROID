package com.example.android_td6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ReposActivity extends AppCompatActivity {
    private List<Repo> mRepos;
    private RecyclerView mRecyclerView;
    private ReposAdapter mReposAdapter;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        context=this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repos);
        ApplicationContext app=(ApplicationContext)getApplicationContext();

        GithubService githubService=new Retrofit.Builder()
                .baseUrl(GithubService.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(GithubService.class);


        Call <ReposResponse> call=githubService.searchRepos(app.getSearchQuery());
        mRecyclerView=findViewById(R.id.rvRepos);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(context));

        call.enqueue(new Callback<ReposResponse>() {
            @Override
            public void onResponse(Call<ReposResponse> call, Response<ReposResponse> response) {
                ReposResponse repo_response = (ReposResponse) response.body();
                mRepos=repo_response.getRepos();
                mReposAdapter=new ReposAdapter(ReposActivity.this,mRepos);
                mRecyclerView.setAdapter(mReposAdapter);
            }

            @Override
            public void onFailure(Call<ReposResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(),
                        t.getMessage()
                        ,
                        Toast.LENGTH_SHORT).show();
            }
        });


    }

}

