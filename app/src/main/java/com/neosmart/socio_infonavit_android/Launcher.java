package com.neosmart.socio_infonavit_android;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;



import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.neosmart.socio_infonavit_android.View.View_Login;

public class Launcher extends AppCompatActivity {

    ImageView logo;
    Animation aminFadeInt;

 ActionBarDrawerToggle drawerToggle;
    public Launcher() {

        //     super( R.layout.activity_launcher );

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        aminFadeInt = AnimationUtils.loadAnimation(this,R.anim.fade);

        logo = (ImageView) findViewById(R.id.logoLauncher);
        aminFadeInt.reset();
        logo.clearAnimation();
        logo.startAnimation(aminFadeInt);
       // drawerToggle = ActionBarDrawerToggle(this,drawerlayout,R.string.open,R.string.close);
        aminFadeInt.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {



            }

            @Override
            public void onAnimationEnd(Animation animation) {
                View_Login login= new View_Login();

                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                //   fragmentTransaction.setCustomAnimations(R.anim.fade,R.anim.fade,R.anim.fade);
                fragmentTransaction.replace(R.id.fragment_container, login);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

}