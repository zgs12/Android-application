package com.example.myapplication.main.shanghai.dto;

import java.util.ArrayList;
import java.util.Collection;


public class ShanghaiDataManager {
    /**
     * 获取竖向数据
     **/
    public static ArrayList<Shanghaibean> getVerData(int len) {
        ArrayList<Shanghaibean> data = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            Shanghaibean bean = new Shanghaibean();
            bean.setShowImg(false).setmDec("上海欢迎您");
            data.add(bean);
        }
        return data;
    }

    /**
     * 获取横向数据
     **/
    public static ArrayList<Shanghaibean> getHorData(int len) {
        ArrayList<Shanghaibean> data = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            Shanghaibean bean = new Shanghaibean();
            bean.setShowImg(true).setmDec("上海欢迎您");
            data.add(bean);
        }
        return data;
    }

    public static ArrayList<Shanghaibean> getData() {
        ArrayList<Shanghaibean> data = new ArrayList<>();
        data.addAll(getVerData(5));
        data.add(new Shanghaibean().setData(getHorData(10)).setmItemType(Shanghaibean.IShanghaiItemType.HORIZONTAL));
        data.addAll(getVerData(5));
        data.add(new Shanghaibean().setData(getHorData(10)).setmItemType(Shanghaibean.IShanghaiItemType.HORIZONTAL));
        return data;
    }
}
