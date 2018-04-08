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

    private HeroSkills(){}

    public static synchronized HeroSkills getHeroSkills(){
        if(heroSkills == null){
            heroSkills = new HeroSkills();
        }
        return heroSkills;
    }

    public int getHeroAttack() {
        return heroAttack;
    }

    public void setHeroAttack(int heroAttack) {
        HeroSkills.heroAttack = heroAttack;
    }

    public int getHeroDefence() {
        return heroDefence;
    }

    public void setHeroDefence(int heroDefence) {
        HeroSkills.heroDefence = heroDefence;
    }

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
