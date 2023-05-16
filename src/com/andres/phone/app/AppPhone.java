package com.andres.phone.app;

import com.andres.phone.domain.*;

import java.util.ArrayList;
import java.util.List;

public class AppPhone {
    public static void main(String[] args) {
        Person alejo = new Person("Alejo","face_1","fingerPrint_1",">><<",8080,"iris_1");
        Person andres = new Person("Andres","face_2","fingerPrint_2","^<>^",2023,"iris_2");
        Person andrea = new Person("Andrea","face_3","fingerPrint_3","<^^>",8080,"iris_3");
        Person carolina = new Person("Carolina","face_4","fingerPrint_4","^<>^",4444,"iris_4");
        Person pedro = new Person("Pedro","face_5","fingerPrint_5","<<^^>>^",3506,"iris_5");

        List<Phone> phones = new ArrayList<>();

        phones.add(new BasicPhone("123-321", "Nokia 1100", alejo));
        phones.add(new FingerPhone("548-335", "iPhone 8", andrea));
        phones.add(new FacePhone("928-619", "iPhone 13", andres));
        phones.add(new PatternPhone("666-444", "Android XX", carolina));
        phones.add(new IrisPhone("551-389","Samsung",pedro));

        phones.forEach(phone -> {
            if (phone instanceof Validation) {
                boolean correctProcess = ((Validation) phone).validate(pedro);
                System.out.println(pedro.getName() + " - " + phone.getBrand() + " - " + correctProcess);
            }
        });
    }
}
