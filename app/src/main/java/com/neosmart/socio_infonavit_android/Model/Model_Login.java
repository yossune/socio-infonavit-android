package com.neosmart.socio_infonavit_android.Model;

import android.content.SharedPreferences;

import com.neosmart.socio_infonavit_android.Conexion.LigaBase;
import com.neosmart.socio_infonavit_android.Interface.Inter_Login;
import com.neosmart.socio_infonavit_android.Interface.JsonLigas;
import com.neosmart.socio_infonavit_android.Modelos.Benevits;
import com.neosmart.socio_infonavit_android.Modelos.BenevitsUser;
import com.neosmart.socio_infonavit_android.Modelos.JsonCredencial;
import com.neosmart.socio_infonavit_android.Modelos.Usuario;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Yossune Arvez on 23,mayo,2022
 * <p>
 * DevArPez
 */
public class Model_Login implements Inter_Login.Model {

    Inter_Login.Presenter PresenterLogin ;

    public Model_Login(Inter_Login.Presenter presenterLogin) {
        PresenterLogin = presenterLogin;
    }

    @Override
    public void ModelLogin(String cadenaEncriptada) throws JSONException {


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl( new LigaBase().getBase_url() )
                .addConverterFactory( GsonConverterFactory.create() ).build();
        JsonLigas jsonLigas =retrofit.create(JsonLigas.class);
        Map<String, String> requestBody= new HashMap<>();
        requestBody.put("credentials", cadenaEncriptada.replaceAll("\\n", ""));
        System.out.println ("map : " + requestBody);

        Call<Usuario> call = jsonLigas.getAuthentication(requestBody);
        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                System.out.println ("responce " + response.toString());
                if (response.isSuccessful()){
                    System.out.println ("model:login    " + response.headers().get("Authorization"));



                   PresenterLogin.ObtienteDatosLogin(response.code(),response.headers().get("Authorization"));

                    System.out.println("***********"+ response.body());



                }else {
                    System.out.println ("model:login  else  " + response.message() +  " request "+ call.request());
                    PresenterLogin.ObtienteDatosLogin(response.code(),response.message());
                }
            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                System.out.println ("model:login  onFailure  " + t.getMessage() + " call "+ call.request());
                PresenterLogin.ObtienteDatosLogin(404,"Servidores no Accesibles, Intente mas tarde");
            }
        });

    }





}
