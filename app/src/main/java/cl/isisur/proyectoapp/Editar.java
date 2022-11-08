package cl.isisur.proyectoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Editar extends AppCompatActivity {

    private EditText ed_nombre,ed_apellido,ed_fecha,ed_correo,ed_telefono,ed_id;
    private Button b_editar,b_eliminar,b_volver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        ed_nombre = findViewById(R.id.et_nombre);
        ed_apellido = findViewById(R.id.et_apellido);
        ed_fecha = findViewById(R.id.et_fechanac);
        ed_correo = findViewById(R.id.et_correo);
        ed_telefono = findViewById(R.id.et_telefono);
        ed_id = findViewById(R.id.id);

        b_editar = findViewById(R.id.btn_editar);
        b_eliminar = findViewById(R.id.btn_eliminar);
        b_volver = findViewById(R.id.btn_volver);

        Intent i = getIntent();

        String et_id = i.getStringExtra("id").toString();
        String et_nombre = i.getStringExtra("nombre").toString();
        String et_apellido = i.getStringExtra("apellido").toString();
        String et_fechanac = i.getStringExtra("fecha de nacimiento").toString();
        String et_correo = i.getStringExtra("correo").toString();
        String et_telefono = i.getStringExtra("telefono").toString();

        ed_id.setText(et_id);
        ed_nombre.setText(et_nombre);
        ed_apellido.setText(et_apellido);
        ed_fecha.setText(et_fechanac);
        ed_correo.setText(et_correo);
        ed_telefono.setText(et_telefono);

        b_editar.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                editar();
            }
        });

        b_eliminar.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                eliminar();
            }
        });

        b_volver.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                Intent i = new Intent(getApplicationContext(), Leer.class);
                startActivity(i);
            }
        });
    }

    public void eliminar()
    {
        try
        {
            String id = ed_id.getText().toString();

            SQLiteDatabase db = openOrCreateDatabase("BD_EJEMPLO", Context.MODE_PRIVATE,null);


            String sql = "delete from persona where id = ?";
            SQLiteStatement statement = db.compileStatement(sql);

            statement.bindString(1,id);
            statement.execute();
            Toast.makeText(this,"Datos eliminados de la base de datos.",Toast.LENGTH_LONG).show();

            ed_nombre.setText("");
            ed_apellido.setText("");
            ed_fecha.setText("");
            ed_correo.setText("");
            ed_telefono.setText("");
            ed_nombre.requestFocus();

        }
        catch (Exception ex)
        {
            Toast.makeText(this,"Error no se pudieron guardar los datos.",Toast.LENGTH_LONG).show();
        }
    }
    public void editar()
    {
        try
        {
            String nombre = ed_nombre.getText().toString();
            String apellido = ed_apellido.getText().toString();
            String fecha = ed_fecha.getText().toString();
            String correo = ed_correo.getText().toString();
            String telefono = ed_telefono.getText().toString();
            String id = ed_id.getText().toString();

            SQLiteDatabase db = openOrCreateDatabase("BD_EJEMPLO",Context.MODE_PRIVATE,null);

            String sql = "update persona set nombre = ?,apellido=?,fecha=?,correo=?,telefono=? where id= ?";
            SQLiteStatement statement = db.compileStatement(sql);
            statement.bindString(1,nombre);
            statement.bindString(2,apellido);
            statement.bindString(3,fecha);
            statement.bindString(4,correo);
            statement.bindString(5,telefono);
            statement.bindString(6,id);
            statement.execute();
            Toast.makeText(this,"Datos actualizados satisfactoriamente en la base de datos.",Toast.LENGTH_LONG).show();

            ed_nombre.setText("");
            ed_apellido.setText("");
            ed_fecha.setText("");
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