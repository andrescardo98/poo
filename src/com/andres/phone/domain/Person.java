package com.andres.phone.domain;

public class Person {
    private String name;
    private String face;
    private String fingerPrint;
    private String pattern;
    private int code;
    private String iris;

    public Person(String name, String face, String fingerPrint, String pattern, int code, String iris) {
        this.name = name;
        this.face = face;
        this.fingerPrint = fingerPrint;
        this.pattern = pattern;
        this.code = code;
        this.iris = iris;
    }

    public String getName() {
        return name;
    }

    public String getFace() {
        return face;
    }

    public String getFingerPrint() {
        return fingerPrint;
    }

    public String getPattern() {
        return pattern;
    }

    public int getCode() {
        return code;
    }

    public String getIris() {
        return iris;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
