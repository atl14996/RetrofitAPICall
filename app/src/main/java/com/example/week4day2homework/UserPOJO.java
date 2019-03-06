package com.example.week4day2homework;

import android.os.Parcel;
import android.os.Parcelable;

public class UserPOJO implements Parcelable {

    String UserName;
    String Address;
    String Phone;
    String SmallImage;
    String LargeImage;

    public UserPOJO(String userName, String address, String phone, String SmallImage, String LargeImage) {
        UserName = userName;
        Address = address;
        Phone = phone;
        SmallImage = SmallImage;
        LargeImage = LargeImage;
    }

    protected UserPOJO(Parcel in) {
        UserName = in.readString();
        Address = in.readString();
        Phone = in.readString();
        SmallImage = in.readString();
        LargeImage = in.readString();
    }

    public static final Creator<UserPOJO> CREATOR = new Creator<UserPOJO>() {
        @Override
        public UserPOJO createFromParcel(Parcel in) {
            return new UserPOJO(in);
        }

        @Override
        public UserPOJO[] newArray(int size) {
            return new UserPOJO[size];
        }
    };

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getSmallImage() {
        return SmallImage;
    }

    public void setSmallImage(String SmallImage) {
        SmallImage = SmallImage;
    }

    public String getLargeImage() {
        return LargeImage;
    }

    public void setLargeImage(String LargeImage) {
        LargeImage = LargeImage;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(UserName);
        dest.writeString(Address);
        dest.writeString(Phone);
        dest.writeString(SmallImage);
        dest.writeString(LargeImage);
    }
}
