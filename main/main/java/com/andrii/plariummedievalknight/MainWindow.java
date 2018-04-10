package com.andrii.plariummedievalknight;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.andrii.plariummedievalknight.hero.HeroSkills;
import com.andrii.plariummedievalknight.items.ItemsMethods;

public class MainWindow extends AppCompatActivity {

    private ImageView ivMainArmor;
    private ImageView ivMainWeapon;

    private TextView tvAttack;
    private TextView tvDefence;

    private Button btnMainWind;
    private Button btnTrader;
    private Button btnInventory;

    private HeroSkills heroSkills = HeroSkills.getHeroSkills();
    private ItemsMethods itemsMethods = new ItemsMethods();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        setViews();
        setButtons();
    }

    private void init(){ // views initialisation
        ivMainArmor = (ImageView)findViewById(R.id.ivMainArmor);
        ivMainWeapon = (ImageView)findViewById(R.id.ivMainWeapon);

        tvAttack = (TextView)findViewById(R.id.tvAttack);
        tvDefence = (TextView)findViewById(R.id.tvDefence);

        btnMainWind = (Button)findViewById(R.id.btnMainWind);
        btnTrader = (Button)findViewById(R.id.btnMainTrader);
        btnInventory = (Button)findViewById(R.id.btnMainInventory);
    }

    private void setViews(){ // sets hero images and text views
        itemsMethods.wearOnHero(ivMainArmor, ivMainWeapon);
        String addedAttack = "";
        String addedDefence = "";

        if(heroSkills.getAddAttack() > 0){
            addedAttack = " (" + heroSkills.getHeroAttack() + " + " + heroSkills.getAddAttack() + ")";}

        if(heroSkills.getAddDefence() > 0){
            addedDefence =  " (" + heroSkills.getHeroDefence() + " + " + heroSkills.getAddDefence() + ")";}

        tvAttack.setText("Attack " + (heroSkills.getHeroAttack() + heroSkills.getAddAttack()) + addedAttack);
        tvDefence.setText("Defence " + (heroSkills.getHeroDefence() + heroSkills.getAddDefence()) + addedDefence);
    }

    private void setButtons(){ // sets methods and click listeners to buttons
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.btnMainTrader:
                        startActivity(new Intent(MainWindow.this, ShopWindow.class));
                        break;
                    case R.id.btnMainInventory:
                        startActivity(new Intent(MainWindow.this, InventoryWindow.class));
                        break;
                }
            }
        };

        btnTrader.setOnClickListener(onClickListener);
        btnInventory.setOnClickListener(onClickListener);
    }
}