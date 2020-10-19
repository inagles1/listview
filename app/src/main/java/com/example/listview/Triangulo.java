package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Triangulo extends AppCompatActivity {
    private EditText base, altura;
    private TextView total;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triangulo);
        base = findViewById(R.id.txtBase);
        altura = findViewById(R.id.txtAltura);
        total = findViewById(R.id.lblResultado);
    }
    public void calcular(View v){
        double b, h, area;
        if(Validar()) {

            b = Double.parseDouble(base.getText().toString());
            h = Double.parseDouble(altura.getText().toString());
            area = (b * h) / 2;
            total.setText("" + area);
        }
    }
    public void limpiar(View v){
        base.setText("");
        altura.setText("");
        total.setText("");
        base.requestFocus();
    }

    public void guardar(View v){
        String op, dt, res;
        Operacion d;

        if(ValidarG()) {
            op = getString(R.string.area)+" "+getString(R.string.triangulo);
            dt = getString(R.string.altura)+ ": " + altura.getText().toString() +"\n"+
                    getString(R.string.base)+ ": " + base.getText().toString();
            res = total.getText().toString();
            d = new Operacion(op, dt, res);
            d.guardar();
            Toast.makeText(this, getString(R.string.area_guardada), Toast.LENGTH_LONG).show();
        }
    }
    public boolean Validar(){
        if(base.getText().toString().isEmpty()){
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
        if(base.getText().toString().isEmpty()){
            Toast.makeText(this, getString(R.string.error_guardar), Toast.LENGTH_LONG).show();
            return false;
        }
        if(altura.getText().toString().isEmpty()){
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