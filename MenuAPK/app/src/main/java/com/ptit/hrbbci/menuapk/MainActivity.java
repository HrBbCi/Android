package com.ptit.hrbbci.menuapk;

import android.content.DialogInterface;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;

public class MainActivity extends AppCompatActivity {

    Button btnMenu,btnContextMenu;
    ConstraintLayout manHinh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Popupmenu click
        convert();

        //Dng ky view cho contextMenu
        registerForContextMenu(btnContextMenu);

        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMenu();
            }
        });
    }

    private void convert() {
        btnMenu = findViewById(R.id.btnPopup);
        btnContextMenu = findViewById(R.id.btnContextMenu);
        manHinh = findViewById(R.id.manHinh);
    }

    //Basemenu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_demo,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.menuSetting: break;
            case R.id.menuSearch: break;
            case R.id.menuPhone: break;
            case R.id.menuEmail: break;
            case R.id.menuExit: break;
        }
        return super.onOptionsItemSelected(item);
    }
    //End BaseMenu

    //PopupMenu
    private void showMenu(){
        PopupMenu popupMenu = new PopupMenu(this,btnMenu);
        popupMenu.getMenuInflater().inflate(R.menu.menu_demo,popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menuSetting: break;
                    case R.id.menuSearch: break;
                    case R.id.menuPhone: break;
                    case R.id.menuEmail: break;
                    case R.id.menuExit: break;
                }
                return false;
            }
        });
        popupMenu.show();
    }


    //ContextMenu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_demo,menu);
        menu.setHeaderTitle("Context Menu");
        menu.setHeaderIcon(R.mipmap.ic_launcher);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuSetting: break;
            case R.id.menuSearch: break;
            case R.id.menuPhone: break;
            case R.id.menuEmail: break;
            case R.id.menuExit: break;
        }
        return super.onContextItemSelected(item);
    }

    private void xacNhan(){
        AlertDialog.Builder ab = new AlertDialog.Builder(this);
        ab.setTitle("Intro");
        ab.setIcon(R.mipmap.ic_launcher);
        ab.setMessage("Do you want to delete?");
        ab.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        ab.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        ab.show();
    }
}
