package com.example.dashboard.status;

import java.io.Serializable;

public class DetectDir implements Serializable {
    private String name;
    private String time_create;
    private String metadate;

    public DetectDir(String name, String time_create, String metadate) {
        this.name = name;
        this.time_create = time_create;
        this.metadate = metadate;
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

    public void setTime_create(String time_create) {
        this.time_create = time_create;
    }

    public String getMetadate() {
        return metadate;
    }

    public void setMetadate(String metadate) {
        this.metadate = metadate;
    }
}
