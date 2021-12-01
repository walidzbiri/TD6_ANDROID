package com.example.android_td6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        Button searchButton=(Button) findViewById(R.id.button);
        EditText searchField=(EditText) findViewById(R.id.search);

        searchButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent=new Intent(v.getContext(),ReposActivity.class);
                ApplicationContext app=(ApplicationContext) getApplicationContext();
                app.setSearchQuery(searchField.getText().toString());
                startActivity(intent);
            }
        });
    }
}