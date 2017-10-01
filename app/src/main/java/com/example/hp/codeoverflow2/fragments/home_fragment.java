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

public class home_fragment extends Fragment implements AdapterView.OnItemClickListener {
    Articlelist [] arr;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Articlelist a1=new Articlelist("Android Development");
        Articlelist a2= new Articlelist("Web Development");

        arr=new Articlelist[5];
        arr[0]=a1;
        arr[1]=a2;
        arr[2]=a2;
        arr[3]=a2;
        arr[4]=a2;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //Log.d("survey",list.toString());

        return inflater.inflate(R.layout.activity_article_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        ListView listView = (ListView) view.findViewById(R.id.lv_article);

        home_adapter surveyListAdapter = new home_adapter(getActivity(), arr);

listView.setAdapter(surveyListAdapter);
        listView.setOnItemClickListener(this);

    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Intent i= new Intent(getContext(),article_activity.class);
        startActivity(i);

    }


}
