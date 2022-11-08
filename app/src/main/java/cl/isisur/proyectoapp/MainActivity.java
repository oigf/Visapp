package cl.isisur.proyectoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button ventana;
    Button registrar;
    private CheckBox chkSeleccionar;
    private String mensaje;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ventana = (Button) findViewById(R.id.ventana);
        registrar =(Button)findViewById(R.id.btnregistrar);
        chkSeleccionar = (CheckBox) findViewById(R.id.checkBoxseleccionar);



        ventana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if (chkSeleccionar.isChecked() == true)
                {
                    mensaje = "Seleccionado";
                    Toast toast =Toast.makeText(MainActivity.this, mensaje , Toast.LENGTH_SHORT);
                    toast.show();
                    Intent i = new Intent( MainActivity.this, activity2.class);
                    startActivity(i);

                }else{
                    mensaje = "No se ha Seleccionado";
                    Toast toast =Toast.makeText(MainActivity.this, mensaje , Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.START, 90, 0);
                    toast.show();
                }

            }
        });

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if (chkSeleccionar.isChecked() == true)
                {
                    mensaje = "Nuevo Registro";
                    Toast toast =Toast.makeText(MainActivity.this, mensaje , Toast.LENGTH_SHORT);
                    toast.show();
                    Intent i = new Intent( MainActivity.this, activity2.class);
                    startActivity(i);

                }else{
                    mensaje = "Registro antiguo";
                    Toast toast =Toast.makeText(MainActivity.this, mensaje , Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.START, 90, 0);
                    toast.show();
                    Intent intent = new Intent( MainActivity.this, Registrar.class);
                    startActivity(intent);
                }

            }
        });

    }


}