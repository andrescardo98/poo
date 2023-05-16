package com.andres.phone.domain;

public class BasicPhone extends Phone implements Validation {
    private int code;

    public BasicPhone(String imei, String brand, Person owner) {
        super(imei, brand, owner);
        this.code = owner.getCode();
    }

    @Override
    public boolean validate(Person person) {
        return code == person.getCode();
    }
}
