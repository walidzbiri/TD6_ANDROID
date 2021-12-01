package com.example.android_td6;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ReposResponse {
    @SerializedName("items")
    @Expose
    private List<Repo> repos;

    public List<Repo> getRepos() {
        return repos;
    }

    @NonNull
    @Override
    public String toString() {
        return repos.toString();
    }
}
