package com.athan.conversor.main;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import com.athan.conversor.data.Conexion;
import com.athan.conversor.data.Divisa_data;
import com.athan.conversor.entidades.Divisa;
import com.athan.ulp20.R;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    public static Divisa divisa=new Divisa();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConexionARed conexionAPI=new ConexionARed();

        divisa.setTipoDolar("blue");

        try {
            conexionAPI.execute();
        }catch(Exception e){
            cuadroDialogo();
        }



    }

    //Android requiere hacer hilo aparte para establecer una conexion con internet
    public class ConexionARed extends AsyncTask<Void,Void,Void>{

        Divisa_data divisaData=null;

        //Hacer conexion a la API
        @Override
        protected Void doInBackground(Void... voids) {
            // Realiza la operación de red aquí
            Conexion con = new Conexion(MainActivity.this);
            divisaData = new Divisa_data(con, MainActivity.this);
            return null;
        }

        //Actualizar los TextView
        @Override
        protected void onPostExecute(Void aVoid) {
            // Actualiza la interfaz de usuario aquí, establece el TextView
            TextView tv1 = findViewById(R.id.nombreDivisa);
            tv1.setText(divisa.getTipoDolar());
            float valorDolar = divisaData.cotizacionTipoDolar(divisa);
            divisa.setPrecioVenta(valorDolar);
            TextView tv2 = findViewById(R.id.cotizacionDivisa);
            tv2.setText(divisa.getPrecioVenta() + "");
        }

    }


    private void cuadroDialogo() {
        // Setear aviso
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        // Armar cuadro aviso
        builder.setTitle("Error");
        builder.setMessage("Ha ocurrido un error en la conexión");

        // Agregar botón "OK"
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                if (i == DialogInterface.BUTTON_POSITIVE) {
                    dialog.dismiss();
                }
            }
        });

        // Crear cuadro de diálogo
        AlertDialog dialog = builder.create();

        dialog.show();
    }

}

