package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Circulo extends AppCompatActivity {
    private EditText radio;
    private TextView total;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circulo);
        radio = findViewById(R.id.txtRadio);
        total = findViewById(R.id.lblResultado);
    }
    public void calcular(View v){
        double r, area;
        double pi;
        pi = 3.1416;
        if(Validar()) {

            r = Double.parseDouble(radio.getText().toString());
            area = (pi * (r * r));
            total.setText("" + area);
        }
    }
    public void limpiar(View v){
        radio.setText("");
        total.setText("");
        radio.requestFocus();
    }

    public void guardar(View v){
        String op, dt, res;
        Operacion d;

        if(ValidarG()) {
            op = getString(R.string.area)+" "+getString(R.string.radio);
            dt = getString(R.string.radio)+ ": " + radio.getText().toString();
            res = total.getText().toString();
            d = new Operacion(op, dt, res);
            d.guardar();
            Toast.makeText(this, getString(R.string.area_guardada), Toast.LENGTH_LONG).show();
        }
    }
    public boolean Validar(){
        if(radio.getText().toString().isEmpty()){
            Toast.makeText(this, getString(R.string.error_calcular), Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }
    public boolean ValidarG(){
        if(radio.getText().toString().isEmpty()){
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