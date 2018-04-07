package com.andrii.plariummedievalknight.hero;

import android.widget.ImageView;

import com.andrii.plariummedievalknight.items.Item;
import com.andrii.plariummedievalknight.items.ItemList;
import com.andrii.plariummedievalknight.items.ItemsMethods;

/**
 * Created by Andrii on 07-Apr-18.
 */

public class InventoryMethods {

    HeroInventory heroInventory = new HeroInventory();
    HeroSkills heroSkills = HeroSkills.getHeroSkills();
    ItemsMethods itemsMethods = new ItemsMethods();
    ItemList itemList = new ItemList();

    public void addItem(String item){
        //adds an item to inventory
        for (int i = 0; i <  heroInventory.getInventory().length; i++){
            if (heroInventory.getInventory()[i].equals("None")){
                heroInventory.getInventory()[i] = item;
                break;
            }
        }
    }

    public void addItemByIndex(String item, int index){
        heroInventory.getInventory()[index] = item;
    }

    public void removeItem(int index){
        heroInventory.getInventory()[index] = "None";
    }

    public void removeWeapon(){
        addItem(heroInventory.getWeapon());
        heroSkills.setAddAttack(0);
        heroInventory.setWeapon("None");
    }

    public void removeArmor(){
        addItem(heroInventory.getArmor());
        heroSkills.setAddDefence(0);
        heroInventory.setArmor("None");
    }

    public boolean isFreeSpace(){
        boolean freeSlot = false;
        for (int i = 0; i < heroInventory.getInventory().length; i++){
            if (heroInventory.getInventory()[i].equals("None")){
                freeSlot = true;
                break;
            }
        }
        return freeSlot;
    }

    public void setInventoryImages(String[] stringInvArr, ImageView[] imageInvArr){
        for (int i =0; i < imageInvArr.length; i++){
            itemsMethods.setItemToImage(stringInvArr[i], imageInvArr[i]);
        }
    }

    public void btnWearUseClick(int index, String btnText){
        String itemFromInventrory = heroInventory.getInventory()[index];
        String itemWeaponBuffer = "None";
        String itemArmorBuffer = "None";

        addItemByIndex(itemFromInventrory, index);

        if(btnText.equals("take")){
            itemWeaponBuffer = heroInventory.getWeapon();
            heroInventory.setWeapon(itemFromInventrory);
            addItemByIndex(itemWeaponBuffer, index);

            heroSkills.setAddAttack(itemList.items.get(itemFromInventrory).getAttack());
        }

        if (btnText.equals("wear")){
            itemArmorBuffer = heroInventory.getArmor();
            heroInventory.setArmor(itemFromInventrory);
            addItemByIndex(itemArmorBuffer, index);

            heroSkills.setAddDefence(itemList.items.get(itemFromInventrory).getDefence());
        }

    }

}
