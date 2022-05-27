package com.neosmart.socio_infonavit_android.Presenter;

import android.widget.Toast;

import com.neosmart.socio_infonavit_android.Ecriptar.EncrypterUtil;
import com.neosmart.socio_infonavit_android.Interface.Inter_Login;
import com.neosmart.socio_infonavit_android.Model.Model_Login;

/**
 * Created by Yossune Arvez on 23,mayo,2022
 * <p>
 *DevArPez
 */
public class Presen_Login implements Inter_Login.Presenter {

    private Inter_Login.View LogLogView;
    private Inter_Login.Model ModLogView;

    public Presen_Login(Inter_Login.View logLogView) {
        LogLogView = logLogView;
        ModLogView = new Model_Login(this);
    }


    @Override
    public void EnviaDatosLogin(String correo, String contraseña) throws Exception {
      String cadenaEncriptada ="";
      String EstructuraCad="";
      String CadLlavePrimEstructuraCadena="";
      String EncripSsRSA ="";
      String Encrrip64="";

        if (LogLogView != null){

            EstructuraCad= correo+":"+ contraseña;
           System.out.println ("Estructura cadena " + EstructuraCad);
            EncrypterUtil encrypterUtil = new EncrypterUtil();
            String cadenaFinal=   encrypterUtil.ecnriptarUsuario(EstructuraCad);
        // String cadenaFinal=   encrypterUtil.ecnriptarUsuario("confpp71@yopmail.com:Contra0123$");
            System.out.println ("encriptada" + cadenaFinal);
            ModLogView.ModelLogin(cadenaFinal);

        }
    }

    @Override
    public void ObtienteDatosLogin(int code, String respuesta) {
        System.out.println ("ObtienteDatosLogin ");
        if(LogLogView!=null){
            System.out.println ("LogLogView!=null " + respuesta);
            LogLogView.MostrarResultadosLogin(code, respuesta);
        }
    }



}
