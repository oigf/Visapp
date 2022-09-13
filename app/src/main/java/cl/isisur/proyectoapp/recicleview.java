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
        nombre.add(new PerfilModelo("Osvaldo Garrido","El mejor,nose en que",R.drawable.perfil));
        nombre.add(new PerfilModelo("Javier Armani","El pulentoso",R.drawable.perfil));
        nombre.add(new PerfilModelo("Pedro Marmol","El mejor,nose en que",R.drawable.perfil));
        nombre.add(new PerfilModelo("Oficial Carrillo","El mejor,ennada ",R.drawable.perfil));
        nombre.add(new PerfilModelo("Manuel  Duranga","El reguleque,nose en que",R.drawable.perfil));

        return nombre;
    }
}