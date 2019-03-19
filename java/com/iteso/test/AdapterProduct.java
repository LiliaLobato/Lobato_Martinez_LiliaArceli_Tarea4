package com.iteso.test;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.iteso.test.beans.ItemProducts;

import java.util.ArrayList;

public class AdapterProduct extends RecyclerView.Adapter<AdapterProduct.ViewHolder> {

    private ArrayList<ItemProducts> mDataSet;
    private Context context;

    public AdapterProduct(ArrayList<ItemProducts> mDataSet, Context context) {
        this.mDataSet = mDataSet;
        this.context = context;
    }

    @NonNull
    @Override
    public AdapterProduct.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product,parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public Button mDetail;
        public TextView mProductTitle;
        public TextView mProductStore;
        public TextView mProductLocation;
        public TextView mProductPhone;
        public ImageView mProductImage;
        public ImageView mProductThumbnail;
        public RelativeLayout mEventLayout;

        public ViewHolder (View v){
            super(v);
            mEventLayout = (RelativeLayout) v.findViewById(R.id.item_product_layout);
            mDetail = (Button) v.findViewById(R.id.item_product_detail);
            mProductTitle = (TextView) v.findViewById(R.id.item_product_title);
            mProductStore = (TextView) v.findViewById(R.id.item_product_store);
            mProductLocation = (TextView) v.findViewById(R.id.item_product_location);
            mProductPhone = (TextView) v.findViewById(R.id.item_product_phone);
            mProductImage = (ImageView) v.findViewById(R.id.item_product_image);
            mProductThumbnail = (ImageView) v.findViewById(R.id.item_product_thumbnail);
        }
    }

    @Override
    public void onBindViewHolder (ViewHolder holder, final int position){
        holder.mProductTitle.setText(mDataSet.get(position).getTitle());
        holder.mProductStore.setText(mDataSet.get(position).getStore());
        holder.mProductLocation.setText(mDataSet.get(position).getLocation());
        holder.mProductPhone.setText(mDataSet.get(position).getPhone());
        switch (mDataSet.get(position).getImage()){
            case 0:
                holder.mProductImage.setImageResource(R.drawable.alienware);
                break;
            case 1:
                holder.mProductImage.setImageResource(R.drawable.mac);
                break;
            case 2:
                holder.mProductImage.setImageResource(R.drawable.micro);
                break;
            case 3:
                holder.mProductImage.setImageResource(R.drawable.pillows);
                break;
            case 4:
                holder.mProductImage.setImageResource(R.drawable.refrigerator);
                break;
            case 5:
                holder.mProductImage.setImageResource(R.drawable.sheets);
                break;
            default:
                holder.mProductImage.setImageResource(R.drawable.alienware);
                break;
        }
        Bitmap bitmap = ((BitmapDrawable)holder.mProductThumbnail.getDrawable()).getBitmap();
        holder.mProductThumbnail.setImageBitmap(bitmap);

        //Toast con información
        holder.mDetail.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(context,mDataSet.get(position).toString(),Toast.LENGTH_LONG).show();
            }
        });

        //Llamada al telefono
        holder.mProductPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL,
                        Uri.parse("tel:" + mDataSet.get(position).getPhone()));
                context.startActivity(intent);
            }
        });

        holder.mEventLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                Intent intent = new Intent(context, Activity_Detail.class);
                intent.putExtra("ITEM", mDataSet.get(position));
                ((ActivityMain)context).startActivityForResult(intent,1);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }
}

