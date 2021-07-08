package com.example.frag_recycle;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.frag_recycle.adapter.DataListAdapter;
import com.example.frag_recycle.model.DataModel;
import com.example.frag_recycle.presenter.MainActivityPresenter;

import java.util.ArrayList;

public class FragmentA extends Fragment implements MainActivityPresenter.View ,ItemClickListener {
    RecyclerView recyclerView;
    MainActivityPresenter mainPresenter;
    DataListAdapter adapter;
    private DetailFragment mDetailFragment;
    Context mContext;
    TextView name;
    Button mButton;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_a, container, false);
        recyclerView = rootView.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        mButton= rootView.findViewById(R.id.btn_add);

        //setting adapter to recycler view
        adapter = new DataListAdapter(mContext);
     //   adapter.registerCallback(this);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);

        //creating instance of presenter class
        mainPresenter = new MainActivityPresenter(this);

       mainPresenter.initData();
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainPresenter.addNewData();
            }
        });
        return rootView;
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext=context;
        if(context instanceof DetailFragment)
            mDetailFragment = (DetailFragment)context;
    }
    @Override
    public void addDatas(ArrayList<DataModel> datas) {
        adapter.submitList(datas);
        adapter.notifyDataSetChanged();
    }

   public interface DetailFragment{
        void onDetailFragment(DataModel dataModel);
   }

    @Override
    public void onClick(View view, DataModel mDataModel) {
        //Log.d("Rohith ","Rohith asdsd");


        Log.d("Rohith ","Rohith asdsd"+mDataModel);
        mDetailFragment.onDetailFragment(mDataModel);
    }
}
