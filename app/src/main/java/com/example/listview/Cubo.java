package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Cubo extends AppCompatActivity {
    private EditText lado;
    private TextView total;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cubo);
        lado = findViewById(R.id.txtLado);
        total = findViewById(R.id.lblResultado);

    }
    public void calcular(View v){
        double l, volumen;

        if(Validar()) {
            l = Double.parseDouble(lado.getText().toString());
            volumen = Math.pow(l, 3);
            total.setText("" + volumen);
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
            op = getString(R.string.volumen)+" "+getString(R.string.cilindro);
            dt = getString(R.string.lado)+ ": " + lado.getText().toString();
            res = total.getText().toString();
            d = new Operacion(op, dt, res);
            d.guardar();
            Toast.makeText(this, getString(R.string.volumen_guardado), Toast.LENGTH_LONG).show();
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