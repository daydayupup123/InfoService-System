package com.example.museum;

import android.annotation.SuppressLint;

import android.os.Bundle;


import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {

    //在网上找的是导航栏底部项目>3时，图标和文字仍能同时显示的方法
    @SuppressLint({"RestrictedApi", "WrongConstant"})
    public static void disableShiftMode(BottomNavigationView view) {
        int count = view.getChildCount();
        if (count > 0) {
            BottomNavigationMenuView menuView = (BottomNavigationMenuView) view.getChildAt(0);
            if (menuView != null) {
                menuView.setLabelVisibilityMode(1);
                menuView.updateMenuView();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionbar = getSupportActionBar();
        // 隐藏标题栏
        if (actionbar != null) {
            actionbar.hide();
        }
        BottomNavigationView navView = findViewById(R.id.nav_view);
        disableShiftMode(navView);

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_first, R.id.navigation_finding, R.id.navigation_guide,R.id.navigation_my)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
    }

}
