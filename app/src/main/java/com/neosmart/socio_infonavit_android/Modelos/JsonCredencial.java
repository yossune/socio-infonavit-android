package com.neosmart.socio_infonavit_android.Modelos;

/**
 * Created by Yossune Arvez on 24,mayo,2022
 * <p>
 * DevArPez
 */
public class JsonCredencial {

  private  String credentials ;

    public JsonCredencial() {

    }

    public String getCredentials() {
        return credentials;
    }

    public void setCredentials(String credentials) {
        this.credentials = credentials;
    }

    @Override
    public String toString() {
        return "JsonCredencial{" +
                "credentials='" + credentials + '\'' +
                '}';
    }
}
