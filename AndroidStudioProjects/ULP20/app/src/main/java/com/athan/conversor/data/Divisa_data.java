package com.athan.conversor.data;

import org.json.JSONObject;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

import com.athan.conversor.entidades.Divisa;

public class Divisa_data {

    private JSONObject jsonObject=null;
    private Context contexto;

    public Divisa_data(Conexion con, Context context) {
        this.jsonObject = con.json();
        this.contexto = context; // Asigna el contexto
    }

    public float cotizacionTipoDolar(Divisa divisa) {

        try {
            float valorCotizacion= (float) jsonObject.getDouble(divisa.getTipoDolar());
             return valorCotizacion;
        } catch (Exception e) {
            cuadroDialogo();
        }
        return 0.0f;

    }

    //Crear cuadro dialogo
    private void cuadroDialogo(){

        //Setear aviso
        AlertDialog.Builder builder=new AlertDialog.Builder(contexto);

        //Armar cuadro aviso
        builder.setTitle("Error");
        builder.setMessage("No se puede obtener la cotizacion");

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
