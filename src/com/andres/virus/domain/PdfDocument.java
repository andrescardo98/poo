package com.andres.virus.domain;

public class PdfDocument extends Document{
    public PdfDocument(String name) {
        super(name);
    }

    @Override
    public boolean hasVirus() {
        return this.name.endsWith(".pdf");
    }
}
