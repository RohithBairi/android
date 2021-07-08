package com.example.frag_recycle;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.frag_recycle.adapter.DataListAdapter;
import com.example.frag_recycle.model.DataModel;

public class FragmentB extends Fragment   {
    private TextView mTitle, mMovie;
    Context mContext;
    DataListAdapter mDataListAdapter = null;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_b, container, false);
        mTitle = rootView.findViewById(R.id.txvTitle);
        mMovie = rootView.findViewById(R.id.txvDescription);
        Log.d("Rohith ","Rohith main"+ mTitle + mMovie);
        return rootView;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext=context;
        mDataListAdapter = new DataListAdapter(mContext);

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        Bundle bundle = this.getArguments();
        Log.d("Rohith","Rohith ");

        if(getArguments()!=null) {
            Log.d("Rohith","Rohith ssss");
            // DataModel obj = (DataModel) bundle.getSerializable("your_obj");
            String myInt = getArguments().getString("Object");

            mTitle.setText(myInt);
        }
        super.onCreate(savedInstanceState);
    }
    public void updateText(DataModel model){

//        mTitle = getActivity().findViewById(R.id.txvTitle);
//        mMovie = getActivity().findViewById(R.id.txvDescription);
        Log.d("Rohith ","Rohith "+ mTitle + mMovie);
        mTitle.setText(model.getName());
        mMovie.setText(model.getRollNumber());
    }
}
