package com.athan.conversor.data;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class Conexion {

    private static URL url;
    private static HttpURLConnection conexion;
    private static StringBuilder response = null;
    private static JSONObject json = null;
    private Context context;

    //Constructor
    public Conexion(Context contexto) {
        this.context=contexto;

        try {
            url = new URL("https://criptoya.com/api/dolar");
            conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestMethod("GET");
        } catch (ProtocolException e) {
            cuadroDialogo();
        } catch (MalformedURLException e) {
            cuadroDialogo();
        } catch (IOException e) {
            cuadroDialogo();
        }

        // Inicializa response como un nuevo StringBuilder
        response = new StringBuilder();
    }

    public JSONObject json() {
        if (response.length() == 0) { // Verifica si response ya ha sido llenado

            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();
                json = new JSONObject(response.toString());
            } catch (IOException e) {
                cuadroDialogo();
            } catch (JSONException e) {
                cuadroDialogo();
            }
        }
        return json;
    }


    //Crear cuadro dialogo
    private void cuadroDialogo(){

        //Setear aviso
        AlertDialog.Builder builder=new AlertDialog.Builder(context);

        //Armar cuadro aviso
        builder.setTitle("Error");
        builder.setMessage("Ha ocurrido un error en la conexion");

        //Agregar boton "OK"
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {

                if(i==0){
                    dialog.dismiss();
                }

            }
        });

        //Crear cuadro de dialogo
        AlertDialog dialog= builder.create();

        dialog.show();

    }
}
