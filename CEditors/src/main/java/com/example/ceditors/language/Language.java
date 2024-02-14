package com.example.ceditors.language;

import com.example.serializationutils.SerializationUtils;

import java.io.IOException;
import java.io.Serializable;

public class Language implements Serializable {
    String code;
    String language;
    String[] functions;
    String parameters;
    String error;

    public Language() {
    }

    public Language(String code, String language) {
        this.code = code;
        this.language = language;
    }

    public Language(String code, String language, String[] functions) {
        this.code = code;
        this.language = language;
        this.functions = functions;
    }

    public Language(String code, String language, String[] functions, String parameters) {
        this.code = code;
        this.language = language;
        this.functions = functions;
        this.parameters = parameters;
    }

    public Language(String code, String language, String[] functions, String parameters, String error) {
        this.code = code;
        this.language = language;
        this.functions = functions;
        this.parameters = parameters;
        this.error = error;
    }

    public String[] getFunctions() {
        return functions;
    }

    public void setFunctions(String[] functions) {
        this.functions = functions;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getParameters() {
        return parameters;
    }

    public void setParameters(String parameters) {
        this.parameters = parameters;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Language language(byte[] bytes) {
        try {
            return (Language) SerializationUtils.deserialize(bytes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
