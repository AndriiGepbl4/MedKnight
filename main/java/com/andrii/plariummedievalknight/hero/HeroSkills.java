package com.andrii.plariummedievalknight.hero;

/**
 * Created by Andrii on 04-Apr-18.
 */

public class HeroSkills {

    private static HeroSkills heroSkills;

    private static int heroAttack = 5;
    private static int heroDefence = 5;
    private static int addAttack = 0;
    private static int addDefence = 0;

    public static int getHeroAttack() {
        return heroAttack;
    }

    public static void setHeroAttack(int heroAttack) {
        HeroSkills.heroAttack = heroAttack;
    }

    public static int getHeroDefence() {
        return heroDefence;
    }

    public static void setHeroDefence(int heroDefence) {
        HeroSkills.heroDefence = heroDefence;
    }

    public static synchronized HeroSkills getHeroSkills(){
        if(heroSkills == null){
            heroSkills = new HeroSkills();
        }
        return heroSkills;
    }

    private HeroSkills(){}

    public int getAddAttack() {
        return addAttack;
    }

    public void setAddAttack(int attack) {
        this.addAttack = attack;
    }

    public int getAddDefence() {
        return addDefence;
    }

    public void setAddDefence(int defence) {
        this.addDefence = defence;
    }


}
