package com.lkj.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.List;

/**
 * Created by LKJ on 2018/6/14.
 */

public class All implements Serializable{
    Realtime realtime;
    Life life;
    Pm pm;
    List<Weather> weather;

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public Realtime getRealtime() {
        return realtime;
    }

    public void setRealtime(Realtime realtime) {
        this.realtime = realtime;
    }

    public Life getLife() {
        return life;
    }

    public void setLife(Life life) {
        this.life = life;
    }

    public Pm getPm() {
        return pm;
    }

    public void setPm(Pm pm) {
        this.pm = pm;
    }

//    @Override
//    public int describeContents() {
//
//        return 0;
//    }
//
//    @Override
//    public void writeToParcel(Parcel dest, int flags) {
//        dest.writeValue(getRealtime());
//        dest.writeValue(getLife());
//        dest.writeValue(getWeather());
//        dest.writeValue(getPm());
//
//    }
//    public static final Parcelable.Creator<All> CREATOR=new Parcelable.Creator<All>() {
//        @Override
//        public All createFromParcel(Parcel source) {
//            All all = new All();
//            all.setRealtime(source.readValue());
//            all.setWeather(source.readArrayList());
//            all.setRealtime(source.readValue());
//
//            return author;
//        }
//
//        @Override
//        public Author[] newArray(int size) {
//            //创建一个类型为T，长度为size的数组，仅一句话（return new T[size])即可。方法是供外部类反序列化本类数组使用。
//            return new Author[size];
//        }

}
