package com.andrii.plariummedievalknight;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.andrii.plariummedievalknight.hero.HeroInventory;
import com.andrii.plariummedievalknight.hero.HeroSkills;
import com.andrii.plariummedievalknight.hero.InventoryMethods;
import com.andrii.plariummedievalknight.items.ItemList;
import com.andrii.plariummedievalknight.items.ItemsMethods;

public class InventoryWindow extends AppCompatActivity {

    private Button btnMainWind;
    private Button btnTrader;
    private Button btnInventory;

    private TextView tvMoney;

    private RelativeLayout rlItemChars;
    private RelativeLayout rlHeroLayout;
    private TextView tvItemChars;
    private Button btnWearUse;
    private Button btnDrop;
    private Button btnHide;
    private Button btnRemoveWpn;
    private Button btnRemoveArmr;

    private ImageView ivArmor;
    private ImageView ivWeapon;

    private ImageView[] ivHeroInvArray = new ImageView[8];
    private ItemsMethods itemsMethods = new ItemsMethods();

    private HeroInventory heroInventory;
    private InventoryMethods inventoryMethods;
    private ItemList itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);

        init();
        setViews();
        setButtons();
    }

    private void init() {
        heroInventory = new HeroInventory();
        inventoryMethods = new InventoryMethods();
        itemList = new ItemList();

        btnMainWind = (Button) findViewById(R.id.btnMainWind);
        btnTrader = (Button) findViewById(R.id.btnMainTrader);
        btnInventory = (Button) findViewById(R.id.btnInventory);
        btnWearUse = (Button) findViewById(R.id.btnWearUse);
        btnDrop = (Button)findViewById(R.id.btnDrop);
        btnHide = (Button)findViewById(R.id.btnHide);
        btnRemoveWpn = (Button)findViewById(R.id.btnRemoveWpn);
        btnRemoveArmr = (Button)findViewById(R.id.btnRemoveArmr);

        tvMoney = (TextView)findViewById(R.id.tvMoney);
        tvItemChars = (TextView)findViewById(R.id.tvItemChars);
        ivArmor = (ImageView)findViewById(R.id.ivInvArmor);
        ivWeapon = (ImageView)findViewById(R.id.ivInvWeapon);

        rlItemChars = (RelativeLayout)findViewById(R.id.rlItemChars);
        rlHeroLayout = (RelativeLayout)findViewById(R.id.rlHeroLayout);

        ivHeroInvArray[0] = (ImageView) findViewById(R.id.ivHeroInv01);
        ivHeroInvArray[1] = (ImageView) findViewById(R.id.ivHeroInv02);
        ivHeroInvArray[2] = (ImageView) findViewById(R.id.ivHeroInv03);
        ivHeroInvArray[3] = (ImageView) findViewById(R.id.ivHeroInv04);
        ivHeroInvArray[4] = (ImageView) findViewById(R.id.ivHeroInv05);
        ivHeroInvArray[5] = (ImageView) findViewById(R.id.ivHeroInv06);
        ivHeroInvArray[6] = (ImageView) findViewById(R.id.ivHeroInv07);
        ivHeroInvArray[7] = (ImageView) findViewById(R.id.ivHeroInv08);
    }

    private void setViews(){
        tvMoney.setText("Money " + heroInventory.getMoney());
        itemsMethods.wearOnHero(ivArmor, ivWeapon);

        if(heroInventory.getArmor().equals("None")){btnRemoveArmr.setVisibility(View.INVISIBLE);}
        else {btnRemoveArmr.setVisibility(View.VISIBLE);}

        if(heroInventory.getWeapon().equals("None")){btnRemoveWpn.setVisibility(View.INVISIBLE);}
        else {btnRemoveWpn.setVisibility(View.VISIBLE);}

        inventoryMethods.setInventoryImages(heroInventory.getInventory(),ivHeroInvArray);
    }

    private void showItemChars(final int index){
        String item = heroInventory.getInventory()[index];
        if(!("None").equals(item)) {
            rlItemChars.setVisibility(View.VISIBLE);
            rlHeroLayout.setVisibility(View.INVISIBLE);

            tvItemChars.setText(itemsMethods.getItemCharacteristic(item));
            btnWearUse.setText(itemsMethods.setButtonUseItem(itemList.items.get(heroInventory.getInventory()[index]).getType()));

            btnWearUse.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    inventoryMethods.btnWearUseClick(index, btnWearUse.getText().toString());
                    setViews();
                    hideItemChars();
                }
            });

            btnDrop.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    inventoryMethods.removeItem(index);
                    setViews();
                    hideItemChars();
                }
            });
        }
    }

    private void hideItemChars(){
        rlItemChars.setVisibility(View.INVISIBLE);
        rlHeroLayout.setVisibility(View.VISIBLE);
    }

    private void setButtons(){
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.btnMainWind:
                        startActivity(new Intent(InventoryWindow.this, MainWindow.class));
                        break;
                    case R.id.btnMainTrader:
                        startActivity(new Intent(InventoryWindow.this, ShopWindow.class));
                        break;

                    case R.id.ivHeroInv01:
                        showItemChars(0);
                                break;
                    case R.id.ivHeroInv02:
                        showItemChars(1);
                        break;
                    case R.id.ivHeroInv03:
                        showItemChars(2);
                        break;
                    case R.id.ivHeroInv04:
                        showItemChars(3);
                        break;
                    case R.id.ivHeroInv05:
                        showItemChars(4);
                        break;
                    case R.id.ivHeroInv06:
                        showItemChars(5);
                        break;
                    case R.id.ivHeroInv07:
                        showItemChars(6);
                        break;
                    case R.id.ivHeroInv08:
                        showItemChars(7);
                        break;

                    case R.id.btnHide:
                        hideItemChars();
                        break;
                    case R.id.btnRemoveWpn:
                        inventoryMethods.removeWeapon();
                        setViews();
                        break;
                    case R.id.btnRemoveArmr:
                        inventoryMethods.removeArmor();
                        setViews();
                        break;
                }
            }
        };

        btnMainWind.setOnClickListener(onClickListener);
        btnTrader.setOnClickListener(onClickListener);
        btnHide.setOnClickListener(onClickListener);
        btnRemoveWpn.setOnClickListener(onClickListener);
        btnRemoveArmr.setOnClickListener(onClickListener);

        for (int i = 0; i < ivHeroInvArray.length; i++){
            ivHeroInvArray[i].setOnClickListener(onClickListener);
        }
    }

}
