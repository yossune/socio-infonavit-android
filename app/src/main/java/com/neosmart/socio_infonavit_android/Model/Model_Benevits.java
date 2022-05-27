package com.neosmart.socio_infonavit_android.Model;

import android.os.Handler;
import android.view.View;

import com.neosmart.socio_infonavit_android.Conexion.LigaBase;
import com.neosmart.socio_infonavit_android.Interface.Inter_Benevits;
import com.neosmart.socio_infonavit_android.Interface.JsonLigas;
import com.neosmart.socio_infonavit_android.Modelos.Benevits;
import com.neosmart.socio_infonavit_android.Modelos.BenevitsUser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Yossune Arvez on 24,mayo,2022
 * <p>
 * DevArPez
 */
public class Model_Benevits implements Inter_Benevits.Model  {
    private Inter_Benevits.Presenter presenter;

    public Model_Benevits(Inter_Benevits.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void ModelObtencionListas(String autorizacion) {
        System.out.println ("llegada de  datos a modal "+ autorizacion);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl( new LigaBase().getBase_url() )
                .addConverterFactory( GsonConverterFactory.create() ).build();
        JsonLigas jsonLigas =retrofit.create(JsonLigas.class);
       Call<BenevitsUser> call = jsonLigas.getBenevits( autorizacion);
        call.enqueue(new Callback<BenevitsUser>() {
            @Override
            public void onResponse(Call<BenevitsUser> call, Response<BenevitsUser> response) {

                System.out.println("***********"+ response.message());
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                            presenter.RespuestaModel(response.message(),response.body());

                    }
                }, 5000);

            }

            @Override
            public void onFailure(Call<BenevitsUser> call, Throwable t) {
                System.out.println ("call " + call.request());
            }
        });


    }
    public void consumirBenevits(String jwt){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl( new LigaBase().getBase_url() )
                .addConverterFactory( GsonConverterFactory.create() ).build();
        JsonLigas jsonLigas =retrofit.create(JsonLigas.class);
        Call<BenevitsUser> call = jsonLigas.getBenevits( jwt);
        call.enqueue(new Callback<BenevitsUser>() {
            @Override
            public void onResponse(Call<BenevitsUser> call, Response<BenevitsUser> response) {
            /*    System.out.println ("call " + call.request());
                System.out.println ("responce " + response.toString());
                System.out.println("***********"+ response.message());
                System.out.println("***********"+ response.code());
                System.out.println("***********"+ response.body());*/
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        for (int i=0;i<5;i++){
                            presenter.RespuestaModel(response.message(),response.body());
                        }
                    }
                }, 5000);
            }

            @Override
            public void onFailure(Call<BenevitsUser> call, Throwable t) {
                System.out.println ("call " + call.request());
            }
        });

    }

    @Override
    public void ModelObtencionSearch(String search, String autorizacion) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl( new LigaBase().getBase_url() )
                .addConverterFactory( GsonConverterFactory.create() ).build();
        JsonLigas jsonLigas =retrofit.create(JsonLigas.class);
        Map<String, String> requestBody= new HashMap<>();
        requestBody.put("query", search);
        System.out.println ("map : " + requestBody);
        Call<ArrayList<Benevits>> call = jsonLigas.getBenevitSearch(requestBody, autorizacion);
        call.enqueue(new Callback<ArrayList<Benevits>>() {
            @Override
            public void onResponse(Call<ArrayList<Benevits>> call, Response<ArrayList<Benevits>> response) {
             /*   System.out.println ("responce " + response.toString());
                System.out.println("***********"+ response.message());
                System.out.println("***********"+ response.body());*/

                if (response.message().equals("OK")){
                    presenter.RespuestaBusqueda(response.message(), response.body());
                }else {
                    consumirBenevits(autorizacion);
                }

            }

            @Override
            public void onFailure(Call<ArrayList<Benevits>> call, Throwable t) {
                System.out.println ("call " + call.request());
            }
        });
    }

    @Override
    public void ModelObtencionMisbebenedits(String autorizacion) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl( new LigaBase().getBase_url() )
                .addConverterFactory( GsonConverterFactory.create() ).build();
        JsonLigas jsonLigas =retrofit.create(JsonLigas.class);
        Call<BenevitsUser> call = jsonLigas.getBenevits( autorizacion);
        call.enqueue(new Callback<BenevitsUser>() {
            @Override
            public void onResponse(Call<BenevitsUser> call, Response<BenevitsUser> response) {

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        for (int i=0;i<5;i++){
                            presenter.RespuestaBusquedaMisbenedits(response.message(),response.body().unlocked);
                        }
                    }
                }, 5000);
            }

            @Override
            public void onFailure(Call<BenevitsUser> call, Throwable t) {
                System.out.println ("call " + call.request());
            }
        });

    }
}
