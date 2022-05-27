package com.neosmart.socio_infonavit_android.Interface;

import org.json.JSONException;

/**
 * Created by Yossune Arvez on 23,mayo,2022
 * <p>
 * DevArPez
 */
public interface Inter_Login {

    interface View{
         void MostrarResultadosLogin (int code, String respuesta);
    }

    interface Presenter {
         void EnviaDatosLogin (String correo, String contraseña) throws Exception;
         void ObtienteDatosLogin(int code,String respuesta);
    }

    interface Model {
        void ModelLogin(String cadenaEncriptada) throws JSONException;
    }


}
