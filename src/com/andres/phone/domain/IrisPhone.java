package com.andres.phone.domain;

public class IrisPhone extends PatternPhone implements Validation{
    private String iris;

    public IrisPhone(String imei, String brand, Person owner) {
        super(imei, brand, owner);
        this.iris = owner.getIris();
    }

    @Override
    public boolean validate(Person person) {
        if (this.iris.equals(person.getIris())){
            return true;
        }

        System.out.println("Wrong iris!");
        return super.validate(person);
    }
}
