package com.neosmart.socio_infonavit_android.Interface;

import com.neosmart.socio_infonavit_android.Modelos.Benevits;
import com.neosmart.socio_infonavit_android.Modelos.BenevitsUser;
import com.neosmart.socio_infonavit_android.Modelos.JsonCredencial;
import com.neosmart.socio_infonavit_android.Modelos.Usuario;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by Yossune Arvez on 23,mayo,2022
 * <p>
 * DevArPez
 */
public interface JsonLigas {

    @POST("v2/member/authentication")
    Call<Usuario> getAuthentication(@Body Map<String, String> body);

    @Headers({ "Content-Type: application/json;charset=UTF-8"})
    @GET("v1/member/landing_benevits")
    Call<BenevitsUser> getBenevits( @Header("Authorization") String auth);

    @POST("v1/member/member_benevits/search")
    Call<ArrayList<Benevits> >getBenevitSearch(@Body Map<String, String> body, @Header("Authorization") String auth);


    //Call<Usuario> getAuthentication(@Header("Content-Type") String content_type, @Body JsonCredencial req);

   // @GET("v1/member/landing_benevits")
    //Call getBenevits ();

}
