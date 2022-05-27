package com.neosmart.socio_infonavit_android.View;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.GridView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.widget.SearchView;

import com.facebook.shimmer.Shimmer;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.neosmart.socio_infonavit_android.Interface.Inter_Benevits;
import com.neosmart.socio_infonavit_android.Modelos.Adapter;
import com.neosmart.socio_infonavit_android.Modelos.AdapterBenevits;
import com.neosmart.socio_infonavit_android.Modelos.Benevits;
import com.neosmart.socio_infonavit_android.Modelos.BenevitsUser;
import com.neosmart.socio_infonavit_android.Presenter.Presenter_Benevits;
import com.neosmart.socio_infonavit_android.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import okhttp3.internal.Util;

import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link View_Benevits#newInstance} factory method to
 * create an instance of this fragment.
 */
public class View_Benevits extends Fragment implements Inter_Benevits.View, SearchView.OnQueryTextListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

     RecyclerView recyclerView ;

    // Adapter adapter;
    AdapterBenevits adapterBenevits;
    LinearLayoutManager linearLayoutManager;
    Boolean isScrolling = false;
    int currentItem, totalItem,scrollOutItem;
    ProgressBar progressBar;
    Inter_Benevits.Presenter presenterBenevits;
    SharedPreferences sharedPreferences;
    ArrayList<Benevits> listaDatos;
    List<Benevits> listbeOUT;
    SearchView searchView;
    String cadenaAutorizacion;
    Toolbar toolbar;
    ShimmerFrameLayout  shimmerFrameLayout;
    public View_Benevits() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment View_Benevits.
     */
    // TODO: Rename and change types and number of parameters
    public static View_Benevits newInstance(String param1, String param2) {
        View_Benevits fragment = new View_Benevits();
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
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =inflater.inflate(R.layout.fragment_view__benevits, container, false);

        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerviewBenevist)  ;

        shimmerFrameLayout = (ShimmerFrameLayout) v.findViewById(R.id.skeletorbenbits);
        linearLayoutManager = new LinearLayoutManager(getContext());
        progressBar =(ProgressBar) v.findViewById(R.id.progress_circular);
        shimmerFrameLayout.startShimmer();
        searchView = (SearchView)  v.findViewById(R.id.search);
        toolbar = (Toolbar) v.findViewById(R.id.toobal);
        toolbar.setTitle("Benevits");
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);
        presenterBenevits= new Presenter_Benevits(this);
       sharedPreferences= this.getActivity().getSharedPreferences("Datos", Context.MODE_PRIVATE);
        cadenaAutorizacion =sharedPreferences.getString("Authorization","");
        mostrarDatos();
        search ();
        return v;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull @NotNull Menu menu, @NonNull @NotNull MenuInflater inflater) {
  inflater.inflate(R.menu.actionbarmenu,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    private void mostrarDatos() {
        System.out.println("CADEA A ENVIAR "+cadenaAutorizacion);
        presenterBenevits.EnviaDatosModel(cadenaAutorizacion);



    }
    private void DateMethod() {
        progressBar.setVisibility(View.VISIBLE);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<5;i++){

                    recyclerView.setLayoutManager(linearLayoutManager);
                    recyclerView.setAdapter(adapterBenevits);
                    adapterBenevits.notifyDataSetChanged();
                    progressBar.setVisibility(View.GONE);
                }
            }
        }, 5000);
    }
    private void search (){
        searchView.setOnQueryTextListener(this);
    }

    @Override
    public void MostrarVistaLista(String resultado, BenevitsUser body) {

        System.out.println ("resultado "+resultado);
        System.out.println ("Size "+body.getLocked().size());
        System.out.println ("Size "+body.getUnlocked().size());
        if (resultado.equals("OK")){
            ArrayList <Benevits> benevits = new ArrayList<>();

            for (int i=0; i < body.getLocked().size();i++){
                body.getLocked().get(i).setBloqueado(true);
            }
            benevits.addAll(body.getUnlocked());
         benevits.addAll(body.getLocked());

 shimmerFrameLayout.stopShimmer();
            shimmerFrameLayout.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
            adapterBenevits= new AdapterBenevits(benevits,getContext());

            recyclerView.setAdapter(adapterBenevits);
            recyclerView.setLayoutManager(linearLayoutManager);





            //   progressBar.setVisibility(View.GONE);
            recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                @Override
                public void onScrollStateChanged(@NonNull @NotNull RecyclerView recyclerView, int newState) {
                    super.onScrollStateChanged(recyclerView, newState);
                    if (newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
                        isScrolling = true;
                    }
                }
                @Override
                public void onScrolled(@NonNull @NotNull RecyclerView recyclerView, int dx, int dy) {
                    super.onScrolled(recyclerView, dx, dy);
                    currentItem=linearLayoutManager.getChildCount();
                    totalItem = linearLayoutManager.getItemCount();
                    scrollOutItem=linearLayoutManager.findFirstVisibleItemPosition();

                    if (isScrolling && currentItem + scrollOutItem == totalItem){

                        isScrolling=false;
                        DateMethod();
                    }
                }

            });



        }
    }

    @Override
    public void MostrarVistaListaSearch(String respuesta, ArrayList<Benevits> body) {
        if (respuesta.equals("OK")){

            adapterBenevits= new AdapterBenevits(body,getContext());
         shimmerFrameLayout.stopShimmer();
            shimmerFrameLayout.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
            recyclerView.setAdapter(adapterBenevits);
            recyclerView.setLayoutManager(linearLayoutManager);




            //   progressBar.setVisibility(View.GONE);
            recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                @Override
                public void onScrollStateChanged(@NonNull @NotNull RecyclerView recyclerView, int newState) {
                    super.onScrollStateChanged(recyclerView, newState);
                    if (newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
                        isScrolling = true;
                    }
                }
                @Override
                public void onScrolled(@NonNull @NotNull RecyclerView recyclerView, int dx, int dy) {
                    super.onScrolled(recyclerView, dx, dy);
                    currentItem=linearLayoutManager.getChildCount();
                    totalItem = linearLayoutManager.getItemCount();
                    scrollOutItem=linearLayoutManager.findFirstVisibleItemPosition();

                    if (isScrolling && currentItem + scrollOutItem == totalItem){

                        isScrolling=false;
                        DateMethod();
                    }
                }

            });


        }
    }

    @Override
    public void MostrarVistaListaMisbenedits(String resultado, ArrayList<Benevits> body) {
        if (resultado.equals("OK")){

            adapterBenevits= new AdapterBenevits(body,getContext());
           shimmerFrameLayout.stopShimmer();
            shimmerFrameLayout.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
            recyclerView.setAdapter(adapterBenevits);
            recyclerView.setLayoutManager(linearLayoutManager);




            //   progressBar.setVisibility(View.GONE);
            recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                @Override
                public void onScrollStateChanged(@NonNull @NotNull RecyclerView recyclerView, int newState) {
                    super.onScrollStateChanged(recyclerView, newState);
                    if (newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
                        isScrolling = true;
                    }
                }
                @Override
                public void onScrolled(@NonNull @NotNull RecyclerView recyclerView, int dx, int dy) {
                    super.onScrolled(recyclerView, dx, dy);
                    currentItem=linearLayoutManager.getChildCount();
                    totalItem = linearLayoutManager.getItemCount();
                    scrollOutItem=linearLayoutManager.findFirstVisibleItemPosition();

                    if (isScrolling && currentItem + scrollOutItem == totalItem){

                        isScrolling=false;
                        DateMethod();
                    }
                }

            });


        }
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull @NotNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.cerrarsesion:
                BorrarDtos();
                View_Login login= new View_Login();
                Toast toast = Toast.makeText(getContext(), "Sesion cerrada correctamente", Toast.LENGTH_LONG  );
                toast.show();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();//comenzamos transacción
                fragmentTransaction.replace(R.id.fragment_container, login);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

                    return true;
            case R.id.misbenedits:
                shimmerFrameLayout.startShimmer();

                shimmerFrameLayout.setVisibility(View.VISIBLE);
                recyclerView.setVisibility(View.GONE);
                System.out.println("CADEA A ENVIAR para obtener mis beneditrs  "+cadenaAutorizacion);
                presenterBenevits.EnviaDatosModelMisBenedits(cadenaAutorizacion);
                return true;
            default:
                return super.onOptionsItemSelected(item);


        }

    }

    @Override
    public boolean onQueryTextSubmit(String query) {

        shimmerFrameLayout.startShimmer();
        shimmerFrameLayout.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
        presenterBenevits.SearchDatoBusqueda(query,cadenaAutorizacion);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        shimmerFrameLayout.startShimmer();
        shimmerFrameLayout.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
        presenterBenevits.SearchDatoBusqueda(newText,cadenaAutorizacion);
        return false;
    }
    public void BorrarDtos() {

        SharedPreferences.Editor editor = getActivity().getSharedPreferences("Datos", MODE_PRIVATE).edit();
        editor.clear().apply();
    }
}