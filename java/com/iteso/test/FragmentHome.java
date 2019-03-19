package com.iteso.test;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.iteso.test.beans.ItemProducts;

import java.util.ArrayList;

public class FragmentHome extends Fragment {

    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public FragmentHome() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_technology, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.fragment_technology_recycler_view);

        mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);

        ArrayList<ItemProducts> myDataSet = new ArrayList<ItemProducts>();
        ItemProducts sheets = new ItemProducts();
        ItemProducts pillows = new ItemProducts();

        sheets.setTitle(getString(R.string.sheets_title)+"");
        sheets.setStore(getString(R.string.sheets_store)+"");
        sheets.setLocation(getString(R.string.sheets_location)+"");
        sheets.setPhone(getString(R.string.sheets_phone)+"");
        sheets.setImage( Integer.parseInt(getString(R.string.sheets_image)));
        sheets.setDescription(getString(R.string.sheets_description)+"");

        pillows.setTitle(getString(R.string.pillows_title)+"");
        pillows.setStore(getString(R.string.pillows_store)+"");
        pillows.setLocation(getString(R.string.pillows_location)+"");
        pillows.setPhone(getString(R.string.pillows_phone)+"");
        pillows.setImage( Integer.parseInt(getString(R.string.pillows_image)));
        pillows.setDescription(getString(R.string.pillows_description)+"");

        myDataSet.add(sheets);
        myDataSet.add(pillows);
        mAdapter = new AdapterProduct(myDataSet,getActivity());
        recyclerView.setAdapter(mAdapter);

        return view;
    }
}
