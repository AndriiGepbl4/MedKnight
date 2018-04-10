package com.andrii.plariummedievalknight.hero;

import android.widget.ImageView;

import com.andrii.plariummedievalknight.items.ItemList;
import com.andrii.plariummedievalknight.items.ItemsMethods;

/**
 * Class contains methods for working with inventory
 */

public class InventoryMethods {

    private HeroInventory heroInventory = new HeroInventory();
    private HeroSkills heroSkills = HeroSkills.getHeroSkills();
    private ItemsMethods itemsMethods = new ItemsMethods();
    private ItemList itemList = new ItemList();

    public void addItem(String item){ // adds an item to inventory's first empty cell
        for (int i = 0; i <  heroInventory.getInventory().length; i++){
            if (heroInventory.getInventory()[i].equals("None")){
                heroInventory.setInventory(i, item);
                break;
            }
        }
    }

    public void addItemByIndex(String item, int index){
        heroInventory.setInventory(index, item);
    }

    public void removeItem(int index){
        heroInventory.setInventory(index, "None");
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

    public boolean isFreeSpace(){ // check if inventory contains an empty slot
        boolean freeSlot = false;
        for (int i = 0; i < heroInventory.getInventory().length; i++){
            if (heroInventory.getInventory()[i].equals("None")){
                freeSlot = true;
                break;
            }
        }
        return freeSlot;
    }

    public void setInventoryImages(String[] stringInvArr, ImageView[] imageInvArr){ // takes inventory array then sets images to inventory's slots
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
