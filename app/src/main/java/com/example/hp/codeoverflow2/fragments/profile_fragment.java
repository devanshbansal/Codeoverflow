package com.example.hp.codeoverflow2.fragments;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.hp.codeoverflow2.R;
import com.example.hp.codeoverflow2.adapters.home_adapter;
import com.example.hp.codeoverflow2.article_activity;
import com.example.hp.codeoverflow2.model.Articlelist;

public class profile_fragment extends Fragment implements AdapterView.OnItemClickListener {
    Articlelist [] arr;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        return inflater.inflate(R.layout.user_profile, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {


    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


    }


}
