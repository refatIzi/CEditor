package com.example.communication.connect;

import com.example.dashboard.status.DetectFile;
import com.example.serializationutils.SerializationUtils;

import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Сonnected implements Serializable {
    AConnect[] connect;

    public Сonnected(AConnect[] connect) {
        this.connect=connect;
    }

    public Сonnected() {

    }

    public AConnect[] getConnect() {
        return connect;
    }

    public void setConnect(AConnect[] connect) {
        this.connect = connect;
    }


    public Сonnected сonnected(byte[] bytes) {
        try {
            return (Сonnected) SerializationUtils.deserialize(bytes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
