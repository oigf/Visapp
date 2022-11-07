package cl.isisur.proyectoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class activity2 extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    Button siguientepage;
    Button btnsensor;
    String[] Selecione = {"Quedo Buenisimo", "Quedo Bueno", "Quedo presentable", "Quedo malo", "Quedo feo"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        Spinner spin = (Spinner) findViewById(R.id.spinner);
        spin.setOnItemSelectedListener(this);
        siguientepage=(Button)findViewById(R.id.siguientepage);
        btnsensor=(Button)findViewById(R.id.btnsensor);

        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, Selecione);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(aa);

        siguientepage.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent(activity2.this,recicleview.class);
                startActivity(i);
            }
        });

        btnsensor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity2.this,Sensor.class);
                startActivity(intent);
            }
        });

    }



    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
