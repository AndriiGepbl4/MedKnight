package com.andrii.plariummedievalknight.items;
import android.widget.ImageView;
import com.andrii.plariummedievalknight.R;
import com.andrii.plariummedievalknight.hero.HeroInventory;

/**
 * Class contains methods for working with items
 */

public class ItemsMethods {

    HeroInventory heroInventory = new HeroInventory();

    public void setItemToImage(String item, ImageView image){ // sets item from inventory to invetory image
        if (item.equals("Chain arm")){image.setImageResource(R.mipmap.inv_chainarm);}
        else if (item.equals("Leather arm")){image.setImageResource(R.mipmap.inv_leather);}
        else if (item.equals("Hard arm")){image.setImageResource(R.mipmap.inv_hardarm);}

        else if (item.equals("Knife")){image.setImageResource(R.mipmap.inv_knife);}
        else if (item.equals("Axe")){image.setImageResource(R.mipmap.inv_axe);}
        else if (item.equals("Mace")){image.setImageResource(R.mipmap.inv_mace);}
        else if (item.equals("Sword")){image.setImageResource(R.mipmap.inv_sword);}

        else if (item.equals("Apple")){image.setImageResource(R.mipmap.inv_apple);}
        else if (item.equals("None")){image.setImageResource(R.mipmap.inv_empty_slot);}
    }

    public String getItemCharacteristic(String item){ // returns String with item characteristics
        ItemList itemList = new ItemList();
        if(!("None").equals(item)){
            return itemList.items.get(item).getName() + "\n" +
                    "attack " + itemList.items.get(item).getAttack() + "\n" +
                    "defence " + itemList.items.get(item).getDefence() + "\n" +
                    "price " + itemList.items.get(item).getPrice();
        } else return "";
    }

    public String setButtonUseItem(String type){ // returns the text that will be added to button
        String btnMessage = "";

        if(type.equals("weapon")){btnMessage = "take";}
        else if (type.equals("armor")){btnMessage = "wear";}
        else if (type.equals("food")){btnMessage = "use";}

        return btnMessage;
    }

    public void wearOnHero(ImageView armorImage, ImageView weaponImage){ // changes hero's image in accordance with inventory
        String armor = heroInventory.getArmor();
        String weapon = heroInventory.getWeapon();

        if (armor.equals("Chain arm")){armorImage.setImageResource(R.mipmap.armr_chainarm);}
        else if (armor.equals("Leather arm")){armorImage.setImageResource(R.mipmap.armr_leather);}
        else if (armor.equals("Hard arm")){armorImage.setImageResource(R.mipmap.armr_hardarm);}
        else if (armor.equals("None")){armorImage.setImageResource(R.mipmap.hero);}

        if (weapon.equals("Knife")){weaponImage.setImageResource(R.mipmap.wpn_knife);}
        else if (weapon.equals("Axe")){weaponImage.setImageResource(R.mipmap.wpn_axe);}
        else if (weapon.equals("Mace")){weaponImage.setImageResource(R.mipmap.wpn_mace);}
        else if (weapon.equals("Sword")){weaponImage.setImageResource(R.mipmap.wpn_sword);}
        else if (weapon.equals("None")){weaponImage.setImageResource(R.mipmap.hero);}
    }
}