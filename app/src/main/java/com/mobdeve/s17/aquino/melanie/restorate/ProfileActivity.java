package com.mobdeve.s17.aquino.melanie.restorate;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class ProfileActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnItemSelectedListener(this::onItemSelectedListener);


        bottomNavigationView.setSelectedItemId(R.id.profile);
    }
    public void logout (View v){
        FirebaseAuth.getInstance().signOut();
        Intent log = new Intent(ProfileActivity.this, LoginActivity.class);
        startActivity(log);

    }

    private boolean onItemSelectedListener(MenuItem item) {
        Intent intent;
        if(item.getItemId() == R.id.home) {
            intent = new Intent(this,MainActivity.class);
            startActivity(intent);
            overridePendingTransition(0,0);
            finish();
            return true;


        } else if(item.getItemId() == R.id.bookmark) {
            intent = new Intent(this,BookmarkActivity.class);
            startActivity(intent);
            overridePendingTransition(0,0);
            finish();
            return true;


        } else if(item.getItemId() == R.id.profile) {

            return true;
        }else if(item.getItemId() == R.id.add) {
            intent = new Intent(this,AddRestoActivity.class);
            startActivity(intent);
            overridePendingTransition(0,0);
            finish();
            return true;
        }else if (item.getItemId() == R.id.review) {
            intent = new Intent(this, AddRestoReview.class);
            startActivity(intent);
            overridePendingTransition(0, 0);
            finish();
            return true;
        }
        return false;
    }
}