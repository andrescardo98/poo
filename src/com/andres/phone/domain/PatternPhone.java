package com.andres.phone.domain;

public class PatternPhone extends FingerPhone implements Validation {
    private String pattern;

    public PatternPhone(String imei, String brand, Person owner) {
        super(imei, brand, owner);
        this.pattern = owner.getPattern();
    }

    @Override
    public boolean validate(Person person) {
        if (this.pattern.equals(person.getPattern())) {
            return true;
        }

        System.out.println("Wrong pattern");
        return super.validate(person);
    }
}
