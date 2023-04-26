package com.example.androiddatabinding;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.androiddatabinding.databinding.FragmentDataBinding;

public class DataFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentDataBinding binding =
                FragmentDataBinding.inflate(inflater, container, false);

        DataSource dataSource = DataSource.get("Fragment Binding");
        binding.setDataSource(dataSource);

        return binding.getRoot();
    }


}
