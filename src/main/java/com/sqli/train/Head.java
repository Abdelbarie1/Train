package com.sqli.train;

public class Head implements WagonStrategy{

    private int position;

    public Head(int position) {
        this.position = position;
    }

    @Override
    public String getRepresentation() {

        return position==0?"<HHHH":"HHHH>";
    }
}
