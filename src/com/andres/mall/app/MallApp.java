package com.andres.mall.app;

import com.andres.mall.domain.Mall;
import com.andres.mall.domain.Store;

public class MallApp {
    public static void main(String[] args) {
        Mall mall = new Mall("San Nicolas");

        for (int i = 1; i < 51; i++) {
            Store store = new Store(i,"Adidas " + i);
            mall.getStores().add(store);
        }
        System.out.println(mall.getStores().size());
        mall.closeStore(49);

        for (Store store : mall.getStores()){
            System.out.println(store.getName());
        }
        mall.closeStore(49);

        //Store adidas = new Store(1, "Adidas");
        //Store pandora = new Store(2, "Pandora");
        //Store nike = new Store(3, "Nike");
        //Store extravagance = new Store(4, "Extravagance");
        //Store frisby = new Store(5, "Frisby");
        //Store creps = new Store(6, "Creps");
        //Store soHappy = new Store(7, "So Happy");
        //Store procinal = new Store(8, "Procinal");
        //Store homecenter = new Store(9, "Homecenter");
        //Store seven = new Store(10, "Seven");

        //mall.getStores().add(adidas);
        //mall.getStores().add(pandora);
        //mall.getStores().add(nike);
        //mall.getStores().add(extravagance);
        //mall.getStores().add(frisby);
        //mall.getStores().add(creps);
        //mall.getStores().add(soHappy);
        //mall.getStores().add(procinal);
        //mall.getStores().add(homecenter);
        //mall.getStores().add(seven);
    }
}
