package com.example.question2_friendapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class Friend_Delete extends AppCompatActivity {
    Spinner spinner_name;
    Button buttonDelete;
    ArrayList<Friend_JavaClass> list_name;
    DataBaseOpenHelper db = new DataBaseOpenHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend_delete);

        buttonDelete = findViewById(R.id.buttonDelete);
        spinner_name = findViewById(R.id.spinner_nameOfFriends);

        //Load name of friends to spinner
        list_name = db.getAllFriend();
        ArrayList<String> list_item = new ArrayList<>();
        for(Friend_JavaClass friend_class:list_name)
            list_item.add(friend_class.getFriendName());
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list_item);
        spinner_name.setAdapter(adapter);

        //Solve delete button to delete data from spinner
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.deleteFriend(spinner_name.getSelectedItem().toString());
                Toast.makeText( getApplicationContext(), "Delete Successfully",Toast.LENGTH_SHORT).show();
            }
        });
    }

}