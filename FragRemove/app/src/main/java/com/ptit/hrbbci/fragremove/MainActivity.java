package com.ptit.hrbbci.fragremove;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    FragmentManager fragmentManager = getFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void AddA(View view) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frameContent, new FragA(), "fragA");
        fragmentTransaction.addToBackStack("fragAAA");
        fragmentTransaction.commit();
    }

    public void AddB(View view) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frameContent, new FragB(), "fragB");
        fragmentTransaction.addToBackStack("fragBBB");
        fragmentTransaction.commit();
    }

    public void AddC(View view) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frameContent, new FragC(), "fragC");
        fragmentTransaction.addToBackStack("fragCCC");
        fragmentTransaction.commit();
    }

    public void RemoveA(View view) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragA fragA = (FragA) getFragmentManager().findFragmentByTag("fragA");
        if (fragA != null) {
            fragmentTransaction.remove(fragA);
            fragmentTransaction.commit();
        } else {
            Toast.makeText(this, "Ko ton tai", Toast.LENGTH_SHORT).show();
        }
    }

    public void RemoveB(View view) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragB fragB = (FragB) getFragmentManager().findFragmentByTag("fragB");
        if (fragB != null) {
            fragmentTransaction.remove(fragB);
            fragmentTransaction.commit();
        } else {
            Toast.makeText(this, "Ko ton tai", Toast.LENGTH_SHORT).show();
        }
    }

    public void RemoveC(View view) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragC fragC = (FragC) getFragmentManager().findFragmentByTag("fragC");
        if (fragC != null) {
            fragmentTransaction.remove(fragC);
            fragmentTransaction.commit();
        } else {
            Toast.makeText(this, "Ko ton tai", Toast.LENGTH_SHORT).show();
        }
    }

    public void Back(View view) {
        getFragmentManager().popBackStack();

    }

    public void Pop(View view) {
        getFragmentManager().popBackStack("fragAAA", 0);
    }

    @Override
    public void onBackPressed() {
        if(getFragmentManager().getBackStackEntryCount() >0){
            getFragmentManager().popBackStack();
        }else{
            super.onBackPressed();
        }
    }
}
