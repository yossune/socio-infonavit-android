package com.neosmart.socio_infonavit_android;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;

import com.neosmart.socio_infonavit_android.View.View_Launcher;

public class MainActivity extends AppCompatActivity {

    public MainActivity() {

   //     super( R.layout.activity_main );

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


       /* ActionBar bar =  getSupportActionBar();
        bar.hide();
        View_Launcher Launcher = new View_Launcher();


        if (savedInstanceState == null) {

            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .replace(R.id.fragment_container, Launcher)
                    .addToBackStack(null)
                    .commit();
        }*/



    }
}