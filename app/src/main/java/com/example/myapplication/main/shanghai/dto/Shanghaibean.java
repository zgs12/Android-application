package com.example.myapplication.main.shanghai.dto;

import java.util.ArrayList;

public class Shanghaibean {
    private  int mItemType = IShanghaiItemType.VERTICAL;
    private  String mDec;
    private  boolean isShowImg;

    private ArrayList<Shanghaibean> data;

    public int getmItemType() {
        return mItemType;
    }

    public Shanghaibean setmItemType(int mItemType) {
        this.mItemType = mItemType;
        return this;
    }

    public String getmDec() {
        return mDec;
    }

    public Shanghaibean setmDec(String mDec) {
        this.mDec = mDec;
        return this;
    }

    public boolean isShowImg() {
        return isShowImg;
    }

    public Shanghaibean setShowImg(boolean showImg) {
        isShowImg = showImg;
        return this;
    }

    public ArrayList<Shanghaibean> getData() {
        return data;
    }

    public Shanghaibean setData(ArrayList<Shanghaibean> data) {
        this.data = data;
        return this;
    }
    public interface IShanghaiItemType{
        int VERTICAL = 0;
        int HORIZONTAL = 1;
    }

}
