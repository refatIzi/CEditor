package com.example.dashboard.folder;

public class FileDetect {

    private String name;
    private String time;
    private String information;
    private int image;


    public FileDetect(String name, String time, String information, int image) {
        this.name = name;
        this.time = time;
        this.information = information;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String name) {
        this.time = time;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

}
