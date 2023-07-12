package com.example.question2_friendapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashSet;
import java.util.jar.Attributes;

public class Friend_Activity extends AppCompatActivity {
EditText editTextName, editTextHandphone, editTextHomeaddress;
Button buttonSave, buttonUpdate;
DataBaseOpenHelper dataBaseOpenHelper = new DataBaseOpenHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend);

        editTextName = findViewById(R.id.editTextName);
        editTextHandphone = findViewById(R.id.editTextHandphone);
        editTextHomeaddress = findViewById(R.id.editTextHomeaddress);
        buttonSave = findViewById(R.id.buttonSave);

        //Solve the save button to save data
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Friend_JavaClass friend = new Friend_JavaClass();
                friend.setFriendName(editTextName.getText().toString());
                friend.setFriendHandphone(editTextHandphone.getText().toString());
                friend.setFriendHomeAddress(editTextHomeaddress.getText().toString());
                if (dataBaseOpenHelper.insertFriend(friend) > 0)
                    Toast.makeText(getApplicationContext(), "Save successfully", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(), "Save error!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}