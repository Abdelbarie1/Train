package com.sqli.train;

public class Passeneger implements  WagonStrategy {
    @Override
    public String getRepresentation() {
        return "|OOOO|";
    }
}
