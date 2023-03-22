package com.andres.mall.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Mall {
    public static final byte CAPACITY = 50;
    private String name;
    private List<Store> stores;

    public Mall(String name) {
        this.name = name;
        this.stores = new ArrayList<>();
    }

    public boolean openStore(long storeCode, String storeName){
        Store store = this.findStoreByCode(storeCode);

        if (this.stores.size() < CAPACITY && store == null){
            Store storeToAdd = new Store(storeCode, storeName);
            this.stores.add(storeToAdd);
            return true;
        }
        return false;
    }

    public void closeStore(long storeCode){
        Store store = this.findStoreByCode(storeCode);

        if (store != null){
            this.stores.remove(store);
        } else {
            System.out.println("The store with code: " + storeCode + " doesn't exist.");
        }
    }

    public Store findStoreByName(String storeName){
        //Store storetoReturn = null;

        //for (Store store : stores){
        //    if (store.getName().equals(storeName)){
        //        storetoReturn = store;
        //    }
        //}
        //return storetoReturn;

        return this.stores.stream()
                .filter(st -> st.getName().equals(storeName))
                .findFirst().orElse(null);
    }

    public Store findStoreByCode(long storeCode){
        Store storeToReturn = null;

        for (Store store : this.stores){
            if (store.getCode() == storeCode){
                storeToReturn = store;
                break;
            }
        }
        return storeToReturn;

        //return this.stores.stream()
        //        .filter(st -> st.getCode() == storeCode)
        //        .findFirst().orElse(null);
    }

    public List<Store> findStores(String category){
        //return this.stores.stream()
        //       .filter(st -> st.getCategories().equals(category))
        //        .collect(Collectors.toList());

        List<Store> storeByCategory = new ArrayList<>();

        for (Store store : this.stores){
            if (store.getCategories().equals(category)){
                storeByCategory.add(store);
            }
        }
        return storeByCategory;
    }

    public List<Store> findStoresWithTwoOrMoreCategories(){
        //List<Store> storesWithTwoOrMoreCategories = new ArrayList<>();

        //for (Store store : this.stores){
        //    if (store.getCategories().size() > 1){
        //        storesWithTwoOrMoreCategories.add(store);
        //    }
        //}
        //return storesWithTwoOrMoreCategories;
        return this.stores.stream()
                .filter(st -> st.getCategories().size() > 1)
                .collect(Collectors.toList());
    }

    public void orderStoreByName(){
        //this.stores.stream().sorted(Comparator.comparing(Store::getName));
        this.stores.sort(Comparator.comparing(Store::getName));
    }

    public String getName() {
        return name;
    }

    public List<Store> getStores() {
        return stores;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStores(List<Store> stores) {
        this.stores = stores;
    }
}
