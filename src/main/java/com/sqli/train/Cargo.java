package com.sqli.train;

public class Cargo implements WagonStrategy{

    private boolean isEmpty;

    public Cargo(boolean isEmpty) {
        this.isEmpty = isEmpty;
    }

    @Override
    public String getRepresentation() {

        return isEmpty?"|____|":"|^^^^|";
    }
}
