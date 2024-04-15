package com.example.daliahamed;

import androidx.annotation.NonNull;

public class Menu {
    private String name;
    private String type;
    private String symbol;
    private int  number;

    public Menu() {
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Menu(String name, String type, String symbol, int number) {
        this.name = name;
        this.type = type;
        this.symbol = symbol;
        this.number= number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @NonNull

    @Override
    public String toString() {
        String msg =getName()+" , symbol of element:   " +getType()+ " , Atomic number : " + getNumber();
        return msg;
    }

}
