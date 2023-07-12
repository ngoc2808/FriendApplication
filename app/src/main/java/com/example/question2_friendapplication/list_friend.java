package com.example.question2_friendapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class list_friend extends AppCompatActivity {
    EditText edt_address, edt_handphone, edt_name;
    Button btn_Update;
    GridView gridView;
    DataBaseOpenHelper db = new DataBaseOpenHelper(this);
    ArrayList<Friend_JavaClass> list_friend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.friend_list);

        edt_name = findViewById(R.id.edt_name);
        edt_address = findViewById(R.id.edt_address);
        edt_handphone = findViewById(R.id.edt_handphone);
        gridView = findViewById(R.id.gridView);

        btn_Update=findViewById(R.id.btn_Update);
        //Display all information into gridview after adding friend/ friends
        list_friend = db.getAllFriend();
        ArrayList<String> list_string = new ArrayList<>();
        for (Friend_JavaClass friend_class : list_friend) {
            list_string.add(friend_class.getFriendName() + "");
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(list_friend.this, android.R.layout.simple_list_item_1, list_string);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Friend_JavaClass friend_class = list_friend.get(position);
                edt_address.setText(friend_class.getFriendHomeAddress() + "");
                edt_handphone.setText(friend_class.getFriendHandphone() + "");
                edt_name.setText(friend_class.getFriendName());
            }
        });

        //Solve update button to update the data
        btn_Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.deleteFriend(edt_name.getText().toString());
                Friend_JavaClass friend = new Friend_JavaClass();

                friend.setFriendName(edt_name.getText().toString());
                friend.setFriendHandphone(edt_handphone.getText().toString());
                friend.setFriendHomeAddress(edt_address.getText().toString());
                if (db.insertFriend(friend) > 0)
                    Toast.makeText(getApplicationContext(), "Update successfully", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(), "Update error!", Toast.LENGTH_SHORT).show();
            }
        });

    }

}
