package com.example.ceditors.line;

public class Line {
    public String returnFilterStr(String str) {

        return lineBreak(str);
    }

    private String lineBreak(String str) {
        String text;
        if (str.contains("\n")) {
            String[] arrSpace = str.split("\n");
            text = lineSpace(arrSpace[arrSpace.length - 1]);
        } else {
            text = lineSpace(str);
        }
        return text;
    }

    private String lineSpace(String str) {
        String text;
        if (str.contains(" ")) {
            String[] arrSpace = str.split(" ");
            text = arrSpace[arrSpace.length - 1];
        } else {
            text = str;
        }
        return text;
    }
}
