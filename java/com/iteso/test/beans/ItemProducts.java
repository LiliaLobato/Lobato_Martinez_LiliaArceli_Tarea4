package com.iteso.test.beans;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

public class ItemProducts implements Parcelable{
    private int image, code;
    private String title, store, location, phone, description;

    public ItemProducts() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getStore() {
        return store;
    }

    public String getLocation() {
        return location;
    }

    public String getPhone() {
        return phone;
    }

    public String getDescription() {
        return description;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ItemProducts{" +
                "image=" + image +
                ", title='" + title + '\'' +
                ", store='" + store + '\'' +
                ", location='" + location + '\'' +
                ", phone='" + phone + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public ItemProducts (Parcel in){
        image = in.readInt();
        title = in.readString();
        store = in.readString();
        location = in.readString();
        phone = in.readString();
        code = in.readInt();
        description = in.readString();
    }

    @Override
    public int describeContents()
    {
        return 0;
    }

    @Override
    public void writeToParcel (Parcel dest, int flags){
        dest.writeInt(image);
        dest.writeString(title);
        dest.writeString(store);
        dest.writeString(location);
        dest.writeString(phone);
        dest.writeInt(code);
        dest.writeString(description);

    }

    public static final Parcelable.Creator<ItemProducts> CREATOR =
            new Parcelable.Creator<ItemProducts>() {
        @Override
        public ItemProducts createFromParcel(Parcel source) {
            return new ItemProducts(source);
        }

        @Override
        public ItemProducts[] newArray(int size) {
            return new ItemProducts[size];
        }
    };
}
