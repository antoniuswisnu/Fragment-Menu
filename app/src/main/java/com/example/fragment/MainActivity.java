package com.example.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    TabLayoutMediator mediator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabLayout = findViewById(R.id.tabLayout);
        ViewPager2 viewPager2 = findViewById(R.id.pager);

        // Menampilkan Fragment
        SampleAdapter adapter = new SampleAdapter(getSupportFragmentManager(), getLifecycle());
        viewPager2.setAdapter(adapter);

        mediator = new TabLayoutMediator(tabLayout, viewPager2, (tab, position)->{
            if(position == 0){
                tab.setText("Fragment 1");
            } else {
                tab.setText("Fragment 2");
            }
        });
        mediator.attach();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.menu_profile:
                Intent intent = new Intent(this, ProfileActivity.class);
                startActivity(intent);
        }
        switch(item.getItemId()){
            case R.id.menu_favorite:
                Intent intent = new Intent(this, FavoriteActivity.class);
                startActivity(intent);
        }
        switch(item.getItemId()){
            case R.id.menu_setting:
                Intent intent = new Intent(this, SettingActivity.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

}