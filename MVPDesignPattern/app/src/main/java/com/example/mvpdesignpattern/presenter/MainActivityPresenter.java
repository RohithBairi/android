package com.example.mvpdesignpattern.presenter;
import android.util.Log;

import com.example.mvpdesignpattern.model.DataModel;

import java.util.ArrayList;
public class MainActivityPresenter {

    private View view;
    DataModel dataModel;
    ArrayList<DataModel> datas=new ArrayList<DataModel>();

    public MainActivityPresenter(View view ) {
        this.view = view;
    }
    public void initData() {
        // student 1
        dataModel = new DataModel(1, "Oliver",11);
        datas.add(dataModel);

        //student 2
        dataModel = new DataModel(2, "George", 12);
        datas.add(dataModel);

        //student 3
        dataModel = new DataModel(3, "Harry" , 4);
        datas.add(dataModel);

        //student 4
        dataModel = new DataModel(4,  "Jack" , 7);
        datas.add(dataModel);

        //student 5
        dataModel = new DataModel(5, "Jacob", 8);
        datas.add(dataModel);

        //student 6
        dataModel = new DataModel(6, "Noah", 5);
        datas.add(dataModel);

        //student 7
        dataModel = new DataModel(7, "Charlie", 6);
        datas.add(dataModel);

        //student 8
        dataModel = new DataModel(8, "Thomas", 3);
        datas.add(dataModel);

        //student 9
        dataModel = new DataModel(10,  "Oscar", 1);
        datas.add(dataModel);

        //student 10
        dataModel = new DataModel(11, "William", 2);
        datas.add(dataModel);

        //student 11
        dataModel = new DataModel(12,  "Henry", 9);
        datas.add(dataModel);


        Log.d("response", "initData: " + datas + "");

        //passing data to interface method addDatas
        view.addDatas(datas);
    }

    //interface of main activity presenter to add data in arraylist of data model
    public interface View {
        void addDatas(ArrayList<DataModel> datas);
    }
}
