package cl.isisur.proyectoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import java.util.ArrayList;
import java.util.List;

public class recicleview extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private RecyclerView recyclerViewPerfil;
    private RecyclerViewAdaptador adaptadorPerfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recicleview);

        recyclerViewPerfil = (RecyclerView) findViewById(R.id.recicler);
        recyclerViewPerfil.setLayoutManager(new LinearLayoutManager(this));

        adaptadorPerfil= new RecyclerViewAdaptador(ObtenerPerfiles());
        recyclerViewPerfil.setAdapter(adaptadorPerfil);


    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
    public List<PerfilModelo> ObtenerPerfiles(){
        List<PerfilModelo> nombre=new ArrayList<>();
        nombre.add(new PerfilModelo("Osvaldo Garrido","Trabajo de instalacion de camaras/ Fecha: 01-09-2022",R.drawable.gerente));
        nombre.add(new PerfilModelo("Javier Armani","Mantenimiento sistema CCTV/ Fecha: 10-09-2022",R.drawable.gerente));
        nombre.add(new PerfilModelo("Pedro Marmol","Instalacion de sistema CCTV a vehiculo/ Fecha: 15-09-2022",R.drawable.gerente));
        nombre.add(new PerfilModelo("Oficial Carrillo","Mantencion y remplazo de cableado/ Fecha: 10-08-2022",R.drawable.gerente));
        nombre.add(new PerfilModelo("Manuel  Duranga","Ajuste de camaras/ Fecha: 13-08-2022 ",R.drawable.gerente));

        return nombre;
    }
}