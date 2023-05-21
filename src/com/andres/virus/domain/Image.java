package com.andres.virus.domain;

public class Image implements Viruseable{
    private String name;
    private int quality;

    public Image(String name, int quality) {
        this.name = name;
        this.quality = quality;
    }

    @Override
    public boolean hasVirus() {
        return quality < 1000;
    }

    @Override
    public String getName() {
        return name;
    }
}
