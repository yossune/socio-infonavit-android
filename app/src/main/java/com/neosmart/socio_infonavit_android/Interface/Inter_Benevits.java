package com.neosmart.socio_infonavit_android.Interface;

import com.neosmart.socio_infonavit_android.Modelos.Benevits;
import com.neosmart.socio_infonavit_android.Modelos.BenevitsUser;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yossune Arvez on 24,mayo,2022
 * <p>
 * DevArPez
 */
public interface Inter_Benevits {

    interface View{
        void MostrarVistaLista (String resultado, BenevitsUser body);
        void MostrarVistaListaSearch (String respuesta, ArrayList<Benevits> body);
        void MostrarVistaListaMisbenedits (String resultado, ArrayList<Benevits> body);
    }

    interface Presenter {
        void EnviaDatosModel (String autorizacion) ;
        void RespuestaModel(String resultado, BenevitsUser body);
        void SearchDatoBusqueda (String busqueda,String autorizacion);
        void RespuestaBusqueda (String respuesta, ArrayList<Benevits> body);
        void EnviaDatosModelMisBenedits (String autorizacion) ;
        void RespuestaBusquedaMisbenedits (String respuesta, ArrayList<Benevits> body);
    }

    interface Model {
        void ModelObtencionListas(String autorizacion);
        void ModelObtencionSearch (String search,String autorizacion);
        void ModelObtencionMisbebenedits (String autorizacion);

    }
}
