package com.example.mvpdesignpattern;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.mvpdesignpattern.adapter.DataListAdapter;
import com.example.mvpdesignpattern.model.DataModel;
import com.example.mvpdesignpattern.presenter.MainActivityPresenter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MainActivityPresenter.View {
    RecyclerView recyclerView;
    MainActivityPresenter mainPresenter;
    DataListAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.data_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        //setting adapter to recycler view
        adapter = new DataListAdapter();
        recyclerView.setAdapter(adapter);

        //creating instance of presenter class
        mainPresenter = new MainActivityPresenter(this);

        //calling initData method of presenter class in which we added dtudent record
        mainPresenter.initData();
    }


    @Override
    public void addDatas(ArrayList<DataModel> datas) {
        adapter.submitList(datas);
        adapter.notifyDataSetChanged();
    }
}