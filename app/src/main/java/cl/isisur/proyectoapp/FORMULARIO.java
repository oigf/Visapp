package cl.isisur.proyectoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FORMULARIO extends AppCompatActivity {

    private EditText ed_nombre,ed_apellido,ed_fechanac,ed_correo,ed_telefono;
    private Button b_agregar,b_ver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        ed_nombre = findViewById(R.id.et_nombre);
        ed_apellido = findViewById(R.id.et_apellido);
        ed_fechanac = findViewById(R.id.et_fechanac);
        ed_correo = findViewById(R.id.et_correo);
        ed_telefono = findViewById(R.id.et_telefono);

        b_agregar = findViewById(R.id.btn_agregar);
        b_ver = findViewById(R.id.btn_ver);

        b_ver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(getApplicationContext(), Leer.class);
                startActivity(i);
            }
        });
        b_agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertar();
            }
        });
    }
    public void insertar()
    {
        try
        {
            String nombre = ed_nombre.getText().toString();
            String apellido = ed_apellido.getText().toString();
            String fecha = ed_fechanac.getText().toString();
            String correo = ed_correo.getText().toString();
            String telefono = ed_telefono.getText().toString();


            SQLiteDatabase db = openOrCreateDatabase("BD_EJEMPLO", Context.MODE_PRIVATE,null);
            db.execSQL("CREATE TABLE IF NOT EXISTS persona(id INTEGER PRIMARY KEY AUTOINCREMENT,nombre VARCHAR,apellido VARCHAR,fecha VARCHAR,correo VARCHAR,telefono VARCHAR)");

            String sql = "insert into persona(nombre,apellido,fecha,correo,telefono)values(?,?,?,?,?)";
            SQLiteStatement statement = db.compileStatement(sql);
            statement.bindString(1,nombre);
            statement.bindString(2,apellido);
            statement.bindString(3,fecha);
            statement.bindString(4,correo);
            statement.bindString(5,telefono);
            statement.execute();
            Toast.makeText(this,"Datos agregados satisfactoriamente en la base de datos.",Toast.LENGTH_LONG).show();

            ed_nombre.setText("");
            ed_apellido.setText("");
            ed_fechanac.setText("");
            ed_correo.setText("");
            ed_telefono.setText("");
            ed_nombre.requestFocus();
        }
        catch (Exception ex)
        {
            Toast.makeText(this,"Error no se pudieron guardar los datos.",Toast.LENGTH_LONG).show();
        }
    }
}
