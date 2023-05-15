package com.andres.phone.domain;

public class BasicPhone extends Phone implements CodeValidable, PatternValidable{
    private int code;
    private String pattern;

    @Override
    public boolean validateCode(int code) {
        return this.code == code;
    }

    @Override
    public boolean validatePattern(String pattern) {
        return this.pattern.equals(pattern);
    }
}
