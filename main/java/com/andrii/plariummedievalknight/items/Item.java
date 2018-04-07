package com.andrii.plariummedievalknight.items;

/**
 * Created by Andrii on 05-Apr-18.
 */

public class Item {

    private String name;
    private String type;
    private int defence;
    private int price;
    private int attack;

    public Item(String name, String type, int attack, int defence, int price) {
        this.name = name;
        this.type = type;
        this.attack = attack;
        this.defence = defence;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefence() {
        return defence;
    }

    public int getPrice() {
        return price;
    }
}
