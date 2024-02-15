package com.example.communication.connect;

import com.example.serializationutils.SerializationUtils;

import java.io.IOException;
import java.io.Serializable;

public class Сonnected implements Serializable {

    public Сonnected verification(byte[] bytes) {
        try {
            return (Сonnected) SerializationUtils.deserialize(bytes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
