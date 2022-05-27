package com.neosmart.socio_infonavit_android.View;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import com.neosmart.socio_infonavit_android.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link View_Launcher#newInstance} factory method to
 * create an instance of this fragment.
 */
public class View_Launcher extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    ImageView logo;
    Animation aminFadeInt;
    SharedPreferences sharedPreferences;
    public View_Launcher() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment View_Launcher.
     */
    // TODO: Rename and change types and number of parameters
    public static View_Launcher newInstance(String param1, String param2) {
        View_Launcher fragment = new View_Launcher();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        aminFadeInt = AnimationUtils.loadAnimation(getContext(),R.anim.fade);

        View v= inflater.inflate(R.layout.fragment_view__launcher, container, false);

        sharedPreferences= this.getActivity().getSharedPreferences("Datos", Context.MODE_PRIVATE);

        logo = (ImageView) v.findViewById(R.id.logoLauncher);
        aminFadeInt.reset();
        logo.clearAnimation();
        logo.startAnimation(aminFadeInt);

        aminFadeInt.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

                Toast.makeText(getContext(), "envio datos login", Toast.LENGTH_SHORT).show();
                String cadena =sharedPreferences.getString("Authorization","");
                System.out.println("CADEA A ENVIAR "+cadena);

                if (cadena.equals("")){
                    View_Login login= new View_Login();

                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    //   fragmentTransaction.setCustomAnimations(R.anim.fade,R.anim.fade,R.anim.fade);
                    fragmentTransaction.replace(R.id.fragment_container, login);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();

                } else {

                    View_Benevits BeneViewBenevits= new View_Benevits();

                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();//comenzamos transacción
                    fragmentTransaction.replace(R.id.fragment_container, BeneViewBenevits);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();

                }


            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        return v;

    }
}