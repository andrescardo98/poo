package com.andres.virus.domain;

public class WordDocument extends Document {

    public WordDocument(String name) {
        super(name);
    }

    @Override
    public boolean hasVirus() {
        return this.name.contains("\uD83E\uDDA0");
    }
}
