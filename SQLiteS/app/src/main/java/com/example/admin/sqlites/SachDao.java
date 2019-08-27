package com.example.admin.sqlites;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;
import com.example.admin.DB;
import java.util.ArrayList;
import java.util.List;

public class SachDao {
    private DB database;
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_SACH = "sachs";
    private static final String COLUMN_SACH_ID = "id";
    private static final String COLUMN_SACH_NAME = "name";
    private static final String COLUMN_SACH_LS = "ls";

    private String CREATE_USER_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_SACH + "("
            + COLUMN_SACH_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_SACH_NAME + " TEXT,"
            + COLUMN_SACH_LS + " TEXT" + ")";

    private String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + TABLE_SACH;

    public SachDao(Context context){
        database = new DB(context, "demo.sqlite", null, DATABASE_VERSION);
        database.queryData(CREATE_USER_TABLE);
    }

    public void addSach(Sach s) {
        String sql = "INSERT INTO sachs(id,name,ls) VALUES(null,'"+s.getTen()+"','"+s.getLoai()+"')";
        database.queryData(sql);
    }
    public void updateSach(Sach s) {
        String sql = "UPDATE sachs SET name ='"+s.getTen()+"', ls = '"+s.getLoai()+"' WHERE id ='"+s.getId()+"'";
        database.queryData(sql);
    }

    public void deleteSach(Sach s) {
        String sql = "DElETE FROM sachs WHERE id='"+s.getId()+"'";
        database.queryData(sql);
    }
    public List<Sach> getAllSach() {
        List<Sach> sachList = new ArrayList<Sach>();
        Cursor dataCV = database.getData("SELECT * FROM sachs");
        Sach s = null;
        while (dataCV.moveToNext()) {
            //id cot 0
            int id = dataCV.getInt(0);
            String ten = dataCV.getString(1);
            String ls = dataCV.getString(2);
            s = new Sach(id, ten,ls);
            sachList.add(s);
        }
        return sachList;
    }

    public List<Sach> getAllSachByLS(String s_ls) {
        List<Sach> sachList = new ArrayList<Sach>();
        Cursor dataCV = database.getData("SELECT * FROM sachs WHERE ls LIKE '%"+s_ls+"%'");
        Sach s = null;
        while (dataCV.moveToNext()) {
            //id cot 0
            int id = dataCV.getInt(0);
            String ten = dataCV.getString(1);
            String ls = dataCV.getString(2);
            s = new Sach(id, ten,ls);
            sachList.add(s);
        }
        return sachList;
    }

}
