package com.example.dashboard.folder;

public class Explorer {

    private String name;
    private String time_create;
    private String metadate;
    private int image;


    public Explorer(String name, String time_create, String metadate, int image) {
        this.name = name;
        this.time_create = time_create;
        this.metadate = metadate;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime_create() {
        return time_create;
    }

    public void setTime_create(String name) {
        this.time_create = time_create;
    }

    public String getMetadate() {
        return metadate;
    }

    public void setMetadate(String metadate) {
        this.metadate = metadate;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

}
