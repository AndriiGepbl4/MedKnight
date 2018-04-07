package com.andrii.plariummedievalknight.items;

import java.util.HashMap;

public class ItemList {

    public ItemList() {
        fillItemList();
    }

    public HashMap <String, Item> items = new HashMap<String, Item>();

    public void fillItemList(){
        items.put("Chain arm", new Item("Chain arm", "armor", 0, 20, 40));
        items.put("Leather arm", new Item("Leather arm", "armor", 0, 10, 25));
        items.put("Hard arm", new Item("Hard arm", "armor", 0, 30, 50));

        items.put("Knife", new Item("Knife", "weapon",5,  0, 10));
        items.put("Axe", new Item("Axe", "weapon",10, 0, 25));
        items.put("Mace", new Item("Mace", "weapon",20, 0, 55));
        items.put("Sword", new Item("Sword", "weapon", 40, 0, 100));

        items.put("Apple", new Item("Apple", "food",0, 0, 5));

        items.put("None", new Item("None", "other",0,0,0));
    }


}
