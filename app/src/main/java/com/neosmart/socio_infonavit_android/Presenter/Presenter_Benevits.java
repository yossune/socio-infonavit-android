package com.neosmart.socio_infonavit_android.Presenter;

import com.neosmart.socio_infonavit_android.Interface.Inter_Benevits;
import com.neosmart.socio_infonavit_android.Model.Model_Benevits;
import com.neosmart.socio_infonavit_android.Modelos.Benevits;
import com.neosmart.socio_infonavit_android.Modelos.BenevitsUser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yossune Arvez on 24,mayo,2022
 * <p>
 * DevArPez
 */
public class Presenter_Benevits implements Inter_Benevits.Presenter {

    private Inter_Benevits.View view;
    private Inter_Benevits.Model model;

    public Presenter_Benevits(Inter_Benevits.View view) {
        this.view = view;
        model  = new Model_Benevits(this);
    }

    @Override
    public void EnviaDatosModel(String autorizacion) {
        if(view!=null){
            System.out.println ("envia datos a modal "+ autorizacion);
            model.ModelObtencionListas( autorizacion);
        }
    }

    @Override
    public void RespuestaModel(String resultado, BenevitsUser body) {
        if(view!=null){
            System.out.println ("envia datos a vistabenetics ");
         view.MostrarVistaLista(resultado, body);
        }
    }

    @Override
    public void SearchDatoBusqueda(String busqueda,String autorizacion) {
        if(view!=null){
            System.out.println ("envia busqueda a modal ");
            model.ModelObtencionSearch(busqueda,autorizacion);
        }
    }

    @Override
    public void RespuestaBusqueda(String respuesta, ArrayList<Benevits> body) {
        if(view!=null){
            System.out.println ("envia datos de busqueda  ");
            view.MostrarVistaListaSearch(respuesta, body);
        }
    }

    @Override
    public void EnviaDatosModelMisBenedits(String autorizacion) {
        if(view!=null){
            model.ModelObtencionMisbebenedits(autorizacion);
        }
    }

    @Override
    public void RespuestaBusquedaMisbenedits(String respuesta, ArrayList<Benevits> body) {
        if(view!=null){
           view.MostrarVistaListaMisbenedits(respuesta,body);
        }
    }


}
