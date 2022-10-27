package cl.isisur.proyectoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;

public class Registrar extends AppCompatActivity implements AdapterView.OnItemSelectedListener  {

    EditText nombresen;
    EditText apellidosen;
    EditText fechanacen;
    EditText telefonoen;
    EditText correoen;
    Button btncrear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        nombresen = findViewById(R.id.nombres);
        apellidosen = findViewById(R.id.apellidos);
        fechanacen = findViewById(R.id.fechanac);
        telefonoen = findViewById(R.id.telefono);
        correoen = findViewById(R.id.correo);
        btncrear = findViewById(R.id.btncrear);

        btncrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle enviaDatos = new Bundle();
                enviaDatos.putString("keyDatos",nombresen.getText().toString());
                enviaDatos.putString("keyDatos1",apellidosen.getText().toString());
                enviaDatos.putString("keyDatos2",fechanacen.getText().toString());
                enviaDatos.putString("keyDatos3",telefonoen.getText().toString());
                enviaDatos.putString("keyDatos4",correoen.getText().toString());

                Intent i = new Intent(Registrar.this,PerfilUs.class);
                i.putExtras(enviaDatos);
                startActivity(i);

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