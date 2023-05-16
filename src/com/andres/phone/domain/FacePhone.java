package com.andres.phone.domain;

public class FacePhone extends BasicPhone implements Validation{
    private String face;

    public FacePhone(String imei, String brand, Person owner) {
        super(imei, brand, owner);
        this.face = owner.getFace();
    }

    @Override
    public boolean validate(Person person) {
        if (this.face.equals(person.getFace())){
            return true;
        }
        System.out.println("Face didn't recognized");
        return super.validate(person);
    }
}
