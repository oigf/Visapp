package cl.isisur.proyectoapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PerfilUs extends AppCompatActivity {

    TextView nombres;
    TextView apellidos;
    TextView fechanac;
    TextView telefono;
    TextView correo;
    ImageView iv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_us);

        nombres = findViewById(R.id.recibenombre);
        apellidos = findViewById(R.id.recibeapellido);
        fechanac = findViewById(R.id.recibefechanac);
        telefono = findViewById(R.id.recibetelefono);
        correo = findViewById(R.id.recibecorreo);
        iv1 = findViewById(R.id.iv1);

        Bundle recibeDatos = getIntent().getExtras();
        String info = recibeDatos.getString("keyDatos");
        String info1 = recibeDatos.getString("keyDatos1");
        String info2 = recibeDatos.getString("keyDatos2");
        String info3 = recibeDatos.getString("keyDatos3");
        String info4 = recibeDatos.getString("keyDatos4");


        nombres.setText(info);
        apellidos.setText(info1);
        fechanac.setText(info2);
        telefono.setText(info3);
        correo.setText(info4);
    }
    final int CAPTURA_IMAGEN=1;

    public void tomarfoto(View view)
    {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,CAPTURA_IMAGEN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==CAPTURA_IMAGEN && resultCode==RESULT_OK)
        {
            Bundle extras=data.getExtras();
            Bitmap bitmap1=(Bitmap)extras.get("data");
            iv1.setImageBitmap(bitmap1);
            try
            {
                FileOutputStream fos=openFileOutput(crearNombreArchivoJPG(), Context.MODE_PRIVATE);
                bitmap1.compress(Bitmap.CompressFormat.JPEG,100,fos);
                fos.close();
            }
            catch (Exception e)
            {

            }
        }
    }

    private String crearNombreArchivoJPG() {
        String fecha=new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        return fecha+".jpg";
    }
}