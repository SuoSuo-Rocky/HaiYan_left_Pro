package org.lanqiao.entity;

public class Studentcard {
    private Integer cardid;

    private String cardiinfo;

    public Integer getCardid() {
        return cardid;
    }

    public void setCardid(Integer cardid) {
        this.cardid = cardid;
    }

    public String getCardiinfo() {
        return cardiinfo;
    }

    public void setCardiinfo(String cardiinfo) {
        this.cardiinfo = cardiinfo == null ? null : cardiinfo.trim();
    }
}