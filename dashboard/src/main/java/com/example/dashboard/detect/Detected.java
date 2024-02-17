package com.example.dashboard.detect;


import com.example.serializationutils.SerializationUtils;

import java.io.IOException;
import java.io.Serializable;

public class Detected implements Serializable {

    public Detected verification(byte[] bytes) {
        try {
            return (Detected) SerializationUtils.deserialize(bytes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
