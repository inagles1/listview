package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Cilindro extends AppCompatActivity {
    private EditText radio, altura;
    private TextView total;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cilindro);
        radio = findViewById(R.id.txtRadio);
        altura = findViewById(R.id.txtAltura);
        total = findViewById(R.id.lblResultado);

    }
    public void calcular(View v){
        double r, h, volumen;
        double pi;
        pi = 3.1416;

        if(Validar()) {
            h = Double.parseDouble(altura.getText().toString());
            r = Double.parseDouble(radio.getText().toString());
            volumen = pi * (Math.pow(r, 2)) * h;
            total.setText("" + volumen);

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
            op = getString(R.string.volumen)+" "+getString(R.string.cilindro);
            dt = getString(R.string.radio)+ ": " + radio.getText().toString()+"\n"+
                    getString(R.string.altura)+ ": " + altura.getText().toString();
            res = total.getText().toString();
            d = new Operacion(op, dt, res);
            d.guardar();
            Toast.makeText(this, getString(R.string.volumen_guardado), Toast.LENGTH_LONG).show();
        }
    }
    public boolean Validar(){
        if(radio.getText().toString().isEmpty()){
            Toast.makeText(this, getString(R.string.error_calcular), Toast.LENGTH_LONG).show();
            return false;
        }
        if(altura.getText().toString().isEmpty()){
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
