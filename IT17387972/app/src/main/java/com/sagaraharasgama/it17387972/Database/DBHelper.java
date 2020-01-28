package com.sagaraharasgama.it17387972.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.support.annotation.Nullable;

import com.sagaraharasgama.it17387972.UserProfile;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(@androidx.annotation.Nullable @Nullable Context context, @androidx.annotation.Nullable @Nullable String name, @androidx.annotation.Nullable @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_DB = " CREATE TABLE " + UserProfile.Users.DATABASE_NAME + " ("
                + UserProfile.Users.COLUMN_NAME_USERID + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + UserProfile.Users.COLUMN_NAME_USERNAME + " TEXT ,"
                + UserProfile.Users.COLUMN_NAME_USERDOB + " TEXT ,"
                + UserProfile.Users.COLUMN_NAME_USERGENDER + " TEXT  )";

        db.execSQL(SQL_CREATE_DB);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean addInfo(String userName, String userGender, String userDOB, String userPassword) {
        SQLiteDatabase database = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(UserProfile.Users.COLUMN_NAME_USERNAME, userName);
        contentValues.put(UserProfile.Users.COLUMN_NAME_USERGENDER, userGender);
        contentValues.put(UserProfile.Users.COLUMN_NAME_USERDOB, userDOB);
        contentValues.put(UserProfile.Users.COLUMN_NAME_USERPASSWORD, userPassword);

        long rowID = database.insert(UserProfile.Users.DATABASE_NAME, null, contentValues);

        if (rowID < 0)
            return false;
        else
            return true;
    }

    public boolean updateInfo(String userID, String userName, String userGender, String userDOB, String userPassword) {
        SQLiteDatabase database = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(UserProfile.Users.COLUMN_NAME_USERNAME, userName);
        contentValues.put(UserProfile.Users.COLUMN_NAME_USERGENDER, userGender);
        contentValues.put(UserProfile.Users.COLUMN_NAME_USERDOB, userDOB);
        contentValues.put(UserProfile.Users.COLUMN_NAME_USERPASSWORD, userPassword);
        database.update(UserProfile.Users.DATABASE_NAME, contentValues, "ID = " + userID, null);
        return true;
    }

    public Cursor readAllInfo() {

        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery( "SELECT * FROM " + UserProfile.Users.DATABASE_NAME, null);
        return cursor;
    }

    public Cursor readAllInfo(String userID){
        SQLiteDatabase database = getReadableDatabase();
        Cursor cursor = database.rawQuery("Select * " + "FROM " + UserProfile.Users.DATABASE_NAME + " WHERE " + userID, new String[] {userID} );
        return cursor;
    }

    public void deleteInfo(String userId){
        SQLiteDatabase database = getWritableDatabase();
        SQLiteStatement statement = database.compileStatement("DELETE FROM userInfo WHERE userID = ? ");
        statement.bindLong(1, Long.parseLong(userId));
        statement.execute();
        statement.close();
        database.close();
    }
}