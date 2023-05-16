package com.andres.phone.domain;

public class FingerPhone extends BasicPhone implements Validation {
    private String fingerPrint;

    public FingerPhone(String imei, String brand, Person owner) {
        super(imei, brand, owner);
        this.fingerPrint = owner.getFingerPrint();
    }

    @Override
    public boolean validate(Person person) {
        if (this.fingerPrint.equals(person.getFingerPrint())){
            return true;
        }

        System.out.println("Incorrect finger print");
        return super.validate(person);
    }
}
