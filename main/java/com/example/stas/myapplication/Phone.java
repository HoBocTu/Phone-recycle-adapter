package com.example.stas.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public final class Phone implements Parcelable {
    private String name;
    private String desk;
    private int imageResourceId;


    public Phone(String name, String desk, int imageResourceId) {
        this.name = name;
        this.desk = desk;
        this.imageResourceId = imageResourceId;
    }

    protected Phone(Parcel in) {
        name = in.readString();
        desk = in.readString();
        imageResourceId = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(desk);
        dest.writeInt(imageResourceId);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Phone> CREATOR = new Creator<Phone>() {
        @Override
        public Phone createFromParcel(Parcel in) {
            return new Phone(in);
        }

        @Override
        public Phone[] newArray(int size) {
            return new Phone[size];
        }
    };

    public String getName() {
        return name;
    }

    public String getDesk() {
        return desk;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesk(String desk) {
        this.desk = desk;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

}
