package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Cuadrado extends AppCompatActivity {
private EditText lado;
private TextView total;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuadrado);
        lado = findViewById(R.id.txtLado);
        total = findViewById(R.id.lblResultado);


    }

    public void calcular(View v){
        Double ldo, area;
        if(Validar()) {
            ldo = Double.parseDouble(lado.getText().toString());
            area = ldo * ldo;
            total.setText("" + area);
        }
    }
    public void limpiar(View v){
        lado.setText("");
        total.setText("");
        lado.requestFocus();
    }
    public void guardar(View v){
        String op, dt, res;
        Operacion d;
        if(ValidarG()) {
            op = getString(R.string.area)+" "+getString(R.string.cuadrado);
            dt = getString(R.string.lado)+ ": " + lado.getText().toString();
            res = total.getText().toString();
            d = new Operacion(op, dt, res);
            d.guardar();
            Toast.makeText(this, getString(R.string.area_guardada), Toast.LENGTH_LONG).show();
        }
    }
    public boolean Validar(){
        if(lado.getText().toString().isEmpty()){
            Toast.makeText(this, getString(R.string.error_calcular), Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }
    public boolean ValidarG(){
        if(lado.getText().toString().isEmpty()){
            Toast.makeText(this, getString(R.string.error_guardar), Toast.LENGTH_LONG).show();
            return false;
        }
        if(total.getText().toString().isEmpty()){
            Toast.makeText(this, getString(R.string.error_guardar), Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }

}