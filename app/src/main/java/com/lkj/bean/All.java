package com.lkj.bean;

import java.util.List;

/**
 * Created by LKJ on 2018/6/14.
 */

public class All {
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


}
