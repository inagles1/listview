package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Cono extends AppCompatActivity {
    private EditText area, altura;
    private TextView total;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cono);
        area = findViewById(R.id.txtArea);
        altura = findViewById(R.id.txtAltura);
        total = findViewById(R.id.lblResultado);

    }
    public void calcular(View v){
        double a, h, volumen, x;
        x = 0.33;

        if(Validar()) {
            h = Double.parseDouble(altura.getText().toString());
            a = Double.parseDouble(area.getText().toString());
            volumen = (x * a * h);
            total.setText("" + volumen);
        }
    }
    public void limpiar(View v){
        area.setText("");
        total.setText("");
        area.requestFocus();
    }

    public void guardar(View v){
        String op, dt, res;
        Operacion d;

        if(ValidarG()) {
            op = getString(R.string.volumen)+" "+getString(R.string.cilindro);
            dt = getString(R.string.area)+ ": " + area.getText().toString()+"\n"+
                    getString(R.string.altura)+ ": " + altura.getText().toString();
            res = total.getText().toString();
            d = new Operacion(op, dt, res);
            d.guardar();
            Toast.makeText(this, getString(R.string.volumen_guardado), Toast.LENGTH_LONG).show();
        }
    }
    public boolean Validar(){
        if(area.getText().toString().isEmpty()){
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
        if(area.getText().toString().isEmpty()){
            Toast.makeText(this, getString(R.string.error_guardar), Toast.LENGTH_LONG).show();
            return false;
        }
        if(altura.getText().toString().isEmpty()){
            Toast.makeText(this, getString(R.string.error_calcular), Toast.LENGTH_LONG).show();
            return false;
        }
        if(total.getText().toString().isEmpty()){
            Toast.makeText(this, getString(R.string.error_guardar), Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }
}