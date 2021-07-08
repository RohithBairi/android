package com.example.frag_recycle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.frag_recycle.model.DataModel;

public class MainActivity extends AppCompatActivity implements FragmentA.DetailFragment{


    public FragmentA frag1 = new FragmentA();
    public FragmentB frag2 = new FragmentB();
    FragmentTransaction ft;
    public static final String FRAGMENT_TAG = "fragmentB";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


    @Override
    public void onDetailFragment(DataModel dataModel) {
        Log.d("Rohith ","Rohith asdsd"+dataModel.getName());

        FragmentB fragmentB = (FragmentB) getFragmentManager().findFragmentById(R.id.fragmentB);

        fragmentB.updateText(dataModel);


    }
}