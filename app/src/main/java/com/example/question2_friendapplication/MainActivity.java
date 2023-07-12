package com.example.question2_friendapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageGif = (ImageView) findViewById(R.id.imageGif);

        Glide.with(this).load(R.drawable.giphy4).into(imageGif);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //Intent the object in menu to switch to another activity
        switch (item.getItemId()) {
            case R.id.nav_Friend:{
                Intent intent_friend = new Intent(MainActivity.this, Friend_Activity.class);
                startActivity(intent_friend);break;}
            case R.id.nav_Listfriend:{
                Intent intent_ListFriend = new Intent(MainActivity.this, list_friend.class);
                startActivity(intent_ListFriend);break;}
            case R.id.nav_FriendDelete:{
                Intent intent_FriendDelete = new Intent(MainActivity.this, Friend_Delete.class);
                startActivity(intent_FriendDelete);break;}
        }
        return super.onOptionsItemSelected(item);
    }
}
