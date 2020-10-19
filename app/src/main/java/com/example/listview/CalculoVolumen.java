package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CalculoVolumen extends AppCompatActivity {
    private ListView lst_opciones;
    private String[] opciones;
    private ArrayAdapter<String> adapter;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo_volumen);
        lst_opciones = findViewById(R.id.lstOpciones);
        opciones = getResources().getStringArray(R.array.cal_volumen);
        adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, opciones);
        lst_opciones.setAdapter(adapter);

        lst_opciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                switch (position){
                    case 0:
                        intent = new Intent(CalculoVolumen.this, Esfera.class);
                        startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(CalculoVolumen.this, Cilindro.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(CalculoVolumen.this, Cono.class);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(CalculoVolumen.this, Cubo.class);
                        startActivity(intent);
                        break;
                }
            }
        });
    }
}