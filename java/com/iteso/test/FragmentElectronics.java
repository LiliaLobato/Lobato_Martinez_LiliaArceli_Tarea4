package com.iteso.test;

import android.content.Intent;
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
import java.util.Iterator;

public class FragmentElectronics extends Fragment {

    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    ArrayList<ItemProducts> myDataSet = new ArrayList<ItemProducts>();

    public FragmentElectronics() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_technology, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.fragment_technology_recycler_view);

        mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        ItemProducts micro = new ItemProducts();
        ItemProducts refrigerator = new ItemProducts();

        micro.setTitle(getString(R.string.micro_title)+"");
        micro.setStore(getString(R.string.micro_store)+"");
        micro.setLocation(getString(R.string.micro_location)+"");
        micro.setPhone(getString(R.string.micro_phone)+"");
        micro.setImage( Integer.parseInt(getString(R.string.micro_image)));
        micro.setDescription(getString(R.string.micro_description)+"");

        refrigerator.setTitle(getString(R.string.refrigerator_title)+"");
        refrigerator.setStore(getString(R.string.refrigerator_store)+"");
        refrigerator.setLocation(getString(R.string.refrigerator_location)+"");
        refrigerator.setPhone(getString(R.string.refrigerator_phone)+"");
        refrigerator.setImage( Integer.parseInt(getString(R.string.refrigerator_image)));
        refrigerator.setDescription(getString(R.string.refrigerator_description)+"");

        myDataSet.add(micro);
        myDataSet.add(refrigerator);
        mAdapter = new AdapterProduct(myDataSet,getActivity());
        recyclerView.setAdapter(mAdapter);

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        ItemProducts itemProduct = data.getParcelableExtra("ITEM");
        Iterator<ItemProducts> iterator = myDataSet.iterator();
        int position = 0;
        while(iterator.hasNext()){
            ItemProducts item = iterator.next();
            if(item.getCode() == itemProduct.getCode()){
                myDataSet.set(position, itemProduct);
                break;
            }
            position++;
        }
        mAdapter.notifyDataSetChanged();
    }
}
