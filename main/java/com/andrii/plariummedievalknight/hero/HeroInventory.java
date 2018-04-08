package com.andrii.plariummedievalknight.hero;

public class HeroInventory {

    public static synchronized void HeroInventory(){
        if (heroInventory == null){
            heroInventory = new HeroInventory();
        }
    }

    private static HeroInventory heroInventory;
    private static String[] inventory = {"None", "Apple", "Apple", "Apple", "None", "None", "None", "None"};
    private static int money = 100;
    private static String weapon = "None";
    private static String armor = "None";

    public String[] getInventory() {
        return inventory;
    }

    public void setInventory(int index, String item) {
        this.inventory[index] = item;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public String getArmor() {
        return armor;
    }

    public void setArmor(String armor) {
        this.armor = armor;
    }


}
