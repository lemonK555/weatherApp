package com.lkj.bean;

/**
 * Created by LKJ on 2018/6/14.
 */

public class Pm {
    String pm_curPm;
    String pm_pm25_num;
    String pm_pm10_num;
    String pm_quality;//空气质量
    String pm_des;//空气描述

    public String getPm_curPm() {
        return pm_curPm;
    }

    public void setPm_curPm(String pm_curPm) {
        this.pm_curPm = pm_curPm;
    }

    public String getPm_pm25_num() {
        return pm_pm25_num;
    }

    public void setPm_pm25_num(String pm_pm25_num) {
        this.pm_pm25_num = pm_pm25_num;
    }

    public String getPm_pm10_num() {
        return pm_pm10_num;
    }

    public void setPm_pm10_num(String pm_pm10_num) {
        this.pm_pm10_num = pm_pm10_num;
    }

    public String getPm_quality() {
        return pm_quality;
    }

    public void setPm_quality(String pm_quality) {
        this.pm_quality = pm_quality;
    }

    public String getPm_des() {
        return pm_des;
    }

    public void setPm_des(String pm_des) {
        this.pm_des = pm_des;
    }
}
