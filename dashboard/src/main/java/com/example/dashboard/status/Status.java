package com.example.dashboard.status;

import com.example.serializationutils.SerializationUtils;

import java.io.IOException;
import java.io.Serializable;

public class Status implements Serializable {
    private CheckHost checkHost;
    private CheckFile[] checkFiles;
    public Status (){

    }
    public Status(CheckHost checkHost, CheckFile[] checkFiles) {
        this.checkHost = checkHost;
        this.checkFiles = checkFiles;
    }

    public Status(CheckFile[] checkFiles) {
        this.checkFiles = checkFiles;
    }
    public Status(CheckHost checkHost) {
        this.checkHost = checkHost;
    }


    public CheckHost getHost() {
        return checkHost;
    }

    public void setHost(CheckHost checkHost) {
        this.checkHost = checkHost;
    }

    public CheckFile[] getCheckFiles() {
        return checkFiles;
    }

    public void setCheckFiles(CheckFile[] checkFiles) {
        this.checkFiles = checkFiles;
    }

    public Status status(byte[] bytes) {
        try {
            return (Status) SerializationUtils.deserialize(bytes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "Status";
    }
}
