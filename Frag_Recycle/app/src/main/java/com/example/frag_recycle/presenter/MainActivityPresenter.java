package com.example.frag_recycle.presenter;

import android.util.Log;


import com.example.frag_recycle.model.DataModel;

import java.util.ArrayList;

public class MainActivityPresenter {

    private View view;
    DataModel dataModel;
    ArrayList<DataModel> datas=new ArrayList<DataModel>();

    public MainActivityPresenter(View view ) {
        this.view = view;
    }
    public void initData() {

        dataModel = new DataModel(1, "Ala Vaikunthapurramuloo","Sittharala Sirapadu");
        datas.add(dataModel);

        dataModel = new DataModel(2, "Ala Vaikunthapurramuloo", "Samajavaragamana");
        datas.add(dataModel);

        dataModel = new DataModel(3, "Ala Vaikunthapurramuloo" , "Ramuloo Ramulaa");
        datas.add(dataModel);

        dataModel = new DataModel(4,  "Ala Vaikunthapurramuloo" , "OMG Daddy");
        datas.add(dataModel);

        dataModel = new DataModel(5, "Ala Vaikunthapurramuloo", "Buttabomma");
        datas.add(dataModel);


        dataModel = new DataModel(6, "Uppena", "Nee Kannu Neeli Samudram");
        datas.add(dataModel);


        dataModel = new DataModel(7, "Geetha Govindam", "Inkem Inkem Inkem Kaavaale");
        datas.add(dataModel);


        dataModel = new DataModel(8, "Geetha Govindam", "Vachindamma");
        datas.add(dataModel);


        dataModel = new DataModel(10,  "Geetha Govindam", "Tanemandhe Tanemandhe");
        datas.add(dataModel);

        Log.d("response", "initData: " + datas + "");

        //passing data to interface method addDatas
        view.addDatas(datas);
    }

    //interface of main activity presenter to add data in arraylist of data model
    public interface View {
        void addDatas(ArrayList<DataModel> datas);
    }

    public void addNewData(){
        dataModel = new DataModel(1, "Ala ","Sittharala Sirapadu");
        datas.add(dataModel);
        view.addDatas(datas);
    }

}
