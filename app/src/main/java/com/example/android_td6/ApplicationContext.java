package com.example.android_td6;

import android.app.Application;

public class ApplicationContext extends Application {

    private String searchQuery;

    @Override
    public void onCreate(){
        super.onCreate();
    }

    public String getSearchQuery() {
        return searchQuery;
    }

    public void setSearchQuery(String searchQuery) {
        this.searchQuery = searchQuery;
    }

}
