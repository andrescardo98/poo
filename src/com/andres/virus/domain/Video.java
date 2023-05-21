package com.andres.virus.domain;

public class Video implements Viruseable{
    private String name;
    private String quality;

    public Video(String name, String quality) {
        this.name = name;
        this.quality = quality;
    }

    @Override
    public boolean hasVirus() {
        return !quality.equals("4K");
    }

    @Override
    public String getName() {
        return name;
    }
}
