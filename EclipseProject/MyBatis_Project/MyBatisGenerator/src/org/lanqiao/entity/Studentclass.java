package org.lanqiao.entity;

public class Studentclass {
    private Integer classid;

    private String classinfo;

    public Integer getClassid() {
        return classid;
    }

    public void setClassid(Integer classid) {
        this.classid = classid;
    }

    public String getClassinfo() {
        return classinfo;
    }

    public void setClassinfo(String classinfo) {
        this.classinfo = classinfo == null ? null : classinfo.trim();
    }
}