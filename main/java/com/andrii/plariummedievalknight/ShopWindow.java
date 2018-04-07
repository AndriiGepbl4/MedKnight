package com.andrii.plariummedievalknight;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.andrii.plariummedievalknight.hero.HeroInventory;
import com.andrii.plariummedievalknight.hero.InventoryMethods;
import com.andrii.plariummedievalknight.items.ItemList;
import com.andrii.plariummedievalknight.items.ItemsMethods;

public class ShopWindow extends AppCompatActivity {

    private Button btnMainWind;
    private Button btnTrader;
    private Button btnInventory;
    private Button btnBuy;
    private Button btnHide;
    private Button btnSell;
    private Button btnHideSellWindow;

    private TextView tvItemName;
    private TextView tvMoney;
    private TextView tvSellItemChars;

    private FrameLayout wndItemChars;
    private FrameLayout flInvHero;
    private FrameLayout flSellItemChars;
    private FrameLayout flInvTrader;

    private ImageView[] ivTraderInvArray = new ImageView[8];
    private ImageView[] ivHeroInvArray = new ImageView[8];

    private ItemsMethods itemsMethods;
    private ItemList itemList;
    private HeroInventory heroInventory;
    private InventoryMethods inventoryMethods;
    private String[] traderInv = {"Sword", "Apple", "Chain arm", "Leather arm", "Hard arm", "Knife", "Axe", "Mace"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        init();
        setInventoryImages();
        setMoney();
        setButtons();
    }

    private void init(){
        itemsMethods = new ItemsMethods();
        itemList = new ItemList();
        heroInventory = new HeroInventory();
        inventoryMethods = new InventoryMethods();

        btnMainWind = (Button)findViewById(R.id.btnShopMainWnd);
        btnTrader = (Button)findViewById(R.id.btnShopShopWnd);
        btnInventory = (Button)findViewById(R.id.btnShopInvWindow);
        btnBuy = (Button)findViewById(R.id.btnBuy);
        btnHide = (Button)findViewById(R.id.btnHide);
        btnSell = (Button)findViewById(R.id.btnSell);
        btnHideSellWindow = (Button)findViewById(R.id.btnHideSellWindow);

        flInvHero = (FrameLayout)findViewById(R.id.flInvHero);
        wndItemChars = (FrameLayout)findViewById(R.id.flBuyItemChars);
        flSellItemChars = (FrameLayout) findViewById(R.id.flSellItemChars);
        flInvTrader = (FrameLayout)findViewById(R.id.flInvTrader);

        tvItemName = (TextView) findViewById(R.id.tvItemName);
        tvMoney = (TextView) findViewById(R.id.tvMoney);
        tvSellItemChars = (TextView)findViewById(R.id.tvSellItemChars);

        ivTraderInvArray[0] = (ImageView) findViewById(R.id.ivTraderInv01);
        ivTraderInvArray[1] = (ImageView) findViewById(R.id.ivTraderInv02);
        ivTraderInvArray[2] = (ImageView) findViewById(R.id.ivTraderInv03);
        ivTraderInvArray[3] = (ImageView) findViewById(R.id.ivTraderInv04);
        ivTraderInvArray[4] = (ImageView) findViewById(R.id.ivTraderInv05);
        ivTraderInvArray[5] = (ImageView) findViewById(R.id.ivTraderInv06);
        ivTraderInvArray[6] = (ImageView) findViewById(R.id.ivTraderInv07);
        ivTraderInvArray[7] = (ImageView) findViewById(R.id.ivTraderInv08);

        ivHeroInvArray[0] = (ImageView) findViewById(R.id.ivHeroShopInv01);
        ivHeroInvArray[1] = (ImageView) findViewById(R.id.ivHeroShopInv02);
        ivHeroInvArray[2] = (ImageView) findViewById(R.id.ivHeroShopInv03);
        ivHeroInvArray[3] = (ImageView) findViewById(R.id.ivHeroShopInv04);
        ivHeroInvArray[4] = (ImageView) findViewById(R.id.ivHeroShopInv05);
        ivHeroInvArray[5] = (ImageView) findViewById(R.id.ivHeroShopInv06);
        ivHeroInvArray[6] = (ImageView) findViewById(R.id.ivHeroShopInv07);
        ivHeroInvArray[7] = (ImageView) findViewById(R.id.ivHeroShopInv08);
    }

    private void setInventoryImages(){
        inventoryMethods.setInventoryImages(traderInv, ivTraderInvArray);
        inventoryMethods.setInventoryImages(HeroInventory.getInventory(), ivHeroInvArray);
    }

    private void setMoney(){
        tvMoney.setText("Money " + heroInventory.getMoney());
    }

    private void buyWindow(final String item){
        wndItemChars.setVisibility(View.VISIBLE);
        flInvHero.setVisibility(View.INVISIBLE);

        tvItemName.setText(itemsMethods.getItemCharacteristic(item));

        btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buyBtnClick(item);
            }
        });
    }

    private void buyBtnClick(String item){
        if (itemList.items.get(item).getPrice() > heroInventory.getMoney()){
            tvItemName.setText("You don't have enought money to buy " + "\n" + itemList.items.get(item).getName());
        } else if (!(inventoryMethods.isFreeSpace())){
            tvItemName.setText("Your inventory is overfilled");
        } else {
            heroInventory.setMoney(heroInventory.getMoney() - itemList.items.get(item).getPrice());
            inventoryMethods.addItem(item);
            setMoney();
            setInventoryImages();
            hideWndItemChars();
        }
    }

    private void sellWindow(final int index){
        String item = heroInventory.getInventory()[index];
        if(!("None").equals(item)) {
            flSellItemChars.setVisibility(View.VISIBLE);
            flInvTrader.setVisibility(View.INVISIBLE);

            tvSellItemChars.setText(itemsMethods.getItemCharacteristic(item));
            btnSell.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    sellBtnClick(index);
                }
            });
        }
    }

    private void sellBtnClick(int index){
        String item = heroInventory.getInventory()[index];
        heroInventory.setMoney(heroInventory.getMoney() + itemList.items.get(item).getPrice());
        setMoney();
        inventoryMethods.removeItem(index);
        setInventoryImages();
        hideSellWindow();
    }

    private void hideWndItemChars(){
        wndItemChars.setVisibility(View.INVISIBLE);
        flInvHero.setVisibility(View.VISIBLE);
    }

    private void hideSellWindow(){
        flSellItemChars.setVisibility(View.INVISIBLE);
        flInvTrader.setVisibility(View.VISIBLE);
    }

    private void setButtons(){
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.btnShopMainWnd:
                        startActivity(new Intent(ShopWindow.this, MainWindow.class));
                        break;
                    case R.id.btnShopInvWindow:
                        startActivity(new Intent(ShopWindow.this, InventoryWindow.class));
                        break;

                    case R.id.ivTraderInv01:
                        buyWindow(traderInv[0]);
                        break;
                    case R.id.ivTraderInv02:
                        buyWindow(traderInv[1]);
                        break;
                    case R.id.ivTraderInv03:
                        buyWindow(traderInv[2]);
                        break;
                    case R.id.ivTraderInv04:
                        buyWindow(traderInv[3]);
                        break;
                    case R.id.ivTraderInv05:
                        buyWindow(traderInv[4]);
                        break;
                    case R.id.ivTraderInv06:
                        buyWindow(traderInv[5]);
                        break;
                    case R.id.ivTraderInv07:
                        buyWindow(traderInv[6]);
                        break;
                    case R.id.ivTraderInv08:
                        buyWindow(traderInv[7]);
                        break;

                    case R.id.ivHeroShopInv01:
                        sellWindow(0);
                        break;
                    case R.id.ivHeroShopInv02:
                        sellWindow(1);
                        break;
                    case R.id.ivHeroShopInv03:
                        sellWindow(2);
                        break;
                    case R.id.ivHeroShopInv04:
                        sellWindow(3);
                        break;
                    case R.id.ivHeroShopInv05:
                        sellWindow(4);
                        break;
                    case R.id.ivHeroShopInv06:
                        sellWindow(5);
                        break;
                    case R.id.ivHeroShopInv07:
                        sellWindow(6);
                        break;
                    case R.id.ivHeroShopInv08:
                        sellWindow(7);
                        break;
                    case R.id.btnHide:
                        hideWndItemChars();
                        break;
                    case R.id.btnHideSellWindow:
                        hideSellWindow();
                        break;
                }
            }
        };

        btnMainWind.setOnClickListener(onClickListener);
        btnInventory.setOnClickListener(onClickListener);
        btnHide.setOnClickListener(onClickListener);
        btnHideSellWindow.setOnClickListener(onClickListener);

        for (int i = 0; i < ivTraderInvArray.length; i++) {
            ivTraderInvArray[i].setOnClickListener(onClickListener);
        }

        for (int i = 0; i < ivHeroInvArray.length; i++){
            ivHeroInvArray[i].setOnClickListener(onClickListener);
        }
    }
}
