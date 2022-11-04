package com.dhana.telegram_ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    LinearLayout personalChatlayout,groupChatlayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.TablayoutMain);
        personalChatlayout = findViewById(R.id.personalChats);
        groupChatlayout = findViewById(R.id.groupChats);
        tabLayout.addTab(tabLayout.newTab().setText("CHATS"));
        tabLayout.addTab(tabLayout.newTab().setText("GROUPS"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 0:
                        setVisible(personalChatlayout,groupChatlayout);
                        break;

                    case 1:
                        setVisible(groupChatlayout,personalChatlayout);
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void setVisible(LinearLayout personalChatlayout, LinearLayout groupChatlayout) {
        personalChatlayout.setVisibility(View.VISIBLE);
        groupChatlayout.setVisibility(View.GONE);
    }
}