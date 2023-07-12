package com.example.question2_friendapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.jar.Attributes;

public class DataBaseOpenHelper extends SQLiteOpenHelper {

    public DataBaseOpenHelper(@Nullable Context context){
        super(context, "The Database ASM", null, 1);
    }

    //Create Friend table
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE FRIEND("+" friendId INTEGER PRIMARY KEY AUTOINCREMENT," +
                "Name text," +
                "Handphone text," +
                "Homeaddress text)");
    }

    //Drop table if database has the same name of table
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS FRIEND");
        onCreate(sqLiteDatabase);
    }

    //Solve insertFriend
    public int insertFriend(Friend_JavaClass friend){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Name", friend.getFriendName());
        contentValues.put("Handphone", friend.getFriendHandphone());
        contentValues.put("HomeAddress", friend.getFriendHomeAddress());
        int result = (int)sqLiteDatabase.insert("FRIEND", null, contentValues);
        sqLiteDatabase.close();
        return result;
    }

    //Create ArrayList to store value
    public ArrayList<Friend_JavaClass> getAllFriend() {
        ArrayList<Friend_JavaClass> list = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from FRIEND", null);
        if (cursor != null)
            cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            list.add(new Friend_JavaClass(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3)));
            cursor.moveToNext();
        }
        cursor.close();
        sqLiteDatabase.close();
        return list;
    }
    //Solve delete button
  public boolean deleteFriend(String Name) {
      SQLiteDatabase db = this.getWritableDatabase();
      return db.delete("FRIEND", "Name = ?", new String[] {Name}) > 0;
    }
}
