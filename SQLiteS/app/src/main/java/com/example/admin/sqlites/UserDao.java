package com.example.admin.sqlites;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.example.admin.DB;
import com.example.admin.sqlites.User;

import java.util.ArrayList;
import java.util.List;

public class UserDao {

    private DB database;
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "sach.db";

    private static final String TABLE_USER = "users";

    private static final String COLUMN_USER_ID = "user_id";
    private static final String COLUMN_USER_NAME = "user_name";
    private static final String COLUMN_USER_PASSWORD = "user_password";

    private String CREATE_USER_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_USER + "("
            + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_USER_NAME + " TEXT,"
            + COLUMN_USER_PASSWORD + " TEXT" + ")";

    private String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + TABLE_USER;

    public UserDao(Context context){
        database = new DB(context, "demo.sqlite", null, 1);
        database.queryData(CREATE_USER_TABLE);
    }

    public void addUser(User user) {
        String sql = "INSERT INTO users(user_id,user_name,user_password) VALUES(null,'"+user.getName()+"','"+user.getPassword()+"')";
        database.queryData(sql);
    }

    /**
     * This method is to fetch all user and return the list of user records
     *
     * @return list
     */
    public List<User> getAllUser() {
        List<User> userList = new ArrayList<User>();
        Cursor dataCV = database.getData("SELECT * FROM users");
        User user = null;
        while (dataCV.moveToNext()) {
            //id cot 0
            int id = dataCV.getInt(0);
            String ten = dataCV.getString(1);
            String pass = dataCV.getString(2);
            user = new User(id, ten,pass);
            userList.add(user);
        }
        return userList;
    }

    public boolean checkUser(User us) {
        String query = "SELECT * FROM users "
                + " WHERE user_name = '" + us.getName() + "' "
                + " AND user_password = '" + us.getPassword() + "' ";
        Cursor sv = database.getData(query)  ;
        if (sv.getCount() > 0 ) {
            return true;
        }return false;
    }
    public boolean checkUserName(User us) {
        String query = "SELECT * FROM users "
                + " WHERE user_name = '" + us.getName()+"'";
        Cursor sv = database.getData(query)   ;
        if (sv.getCount() > 0) {
            return true;
        }return false;
    }

}
