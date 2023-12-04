package com.athan.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Clientes extends AppCompatActivity implements View.OnClickListener {

    EditText dniTV,apellidoTV,nombreTV,direccionTV,correoTV,telefonoTV,estadoTV;
    Button agregarButton;
    RequestQueue requestQueue;
    private static final String URL1="http://192.168.1.100/appandroidpyme/save.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes);

        iniciarComponentes();

        agregarButton.setOnClickListener(this);

        requestQueue= Volley.newRequestQueue(this);


    }

    private void iniciarComponentes(){

        dniTV=findViewById(R.id.dniTV);
        apellidoTV=findViewById(R.id.apellidoTV);
        nombreTV=findViewById(R.id.nombreTV);
        direccionTV=findViewById(R.id.direccionTV);
        correoTV=findViewById(R.id.correoTV);
        telefonoTV=findViewById(R.id.telefonoTV);
        estadoTV=findViewById(R.id.estadoTV);

        agregarButton=findViewById(R.id.cargarButton);

    }


    @Override
    public void onClick(View v) {

        int id=v.getId();

        if(id==R.id.cargarButton){

        String dni=dniTV.getText().toString().trim();
        String apellido=apellidoTV.getText().toString().trim();
        String nombre=nombreTV.getText().toString().trim();
        String direccion=direccionTV.getText().toString().trim();
        String correo=correoTV.getText().toString().trim();
        String telefono=telefonoTV.getText().toString().trim();
        String estado=estadoTV.getText().toString().trim();
        
        crearCliente(dni,apellido,nombre,direccion,correo,telefono,estado);

        }


    }

    private void crearCliente(String dni, String apellido, String nombre, String direccion, String correo, String telefono, String estado) {

        StringRequest stringRequest=new StringRequest(
                Request.Method.POST,
                URL1,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Toast.makeText(Clientes.this,"Correcto",Toast.LENGTH_SHORT).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        ){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String>parametros=new HashMap<>();
                parametros.put("dni",dni);
                parametros.put("apellido",apellido);
                parametros.put("nombre",nombre);
                parametros.put("direccion",direccion);
                parametros.put("correo",correo);
                parametros.put("telefono",telefono);
                int estadoBoolean=0;
                if(estado.equals("Activo")|| estado.equals("activo")){
                    estadoBoolean=1;
                }
                parametros.put("estado", String.valueOf(estadoBoolean));
                return parametros;
            }
        };

        requestQueue.add(stringRequest);
    }
}