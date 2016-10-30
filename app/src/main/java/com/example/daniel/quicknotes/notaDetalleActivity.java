package com.example.daniel.quicknotes;



import android.support.v4.app.FragmentManager;
//import android.support.v4.app;
import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class notaDetalleActivity extends AppCompatActivity {

    public static final String NEW_NOTE_EXTRA = "Nueva nota";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nota_detalle);
        createAndAddFragment();
    }

    private void createAndAddFragment(){
        Intent intent = getIntent();
        pantallaPrincipal.fragmento fragmento = (pantallaPrincipal.fragmento) intent.getSerializableExtra(pantallaPrincipal.NOTE_FRAGMENTO_ACTIVO);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        switch(fragmento){
            case EDITAR:
                EditarNotaFragment editarNotaFragment = new EditarNotaFragment();
                setTitle("Editar");
                fragmentTransaction.add(R.id.contenedor_nota, editarNotaFragment, "EDITAR_NOTA_FRAGMENT");
                break;

            case DETALLE:
                vistaNotaFragment vistaNotaFragment = new vistaNotaFragment();
                setTitle("Detalle");
                fragmentTransaction.add(R.id.contenedor_nota, vistaNotaFragment, "VISTA_NOTA_FRAGMENT");
                break;

            case CREAR:
                EditarNotaFragment crearNotaFragment = new EditarNotaFragment();
                setTitle("Nueva nota");
                Bundle bundle = new Bundle();
                bundle.putBoolean(NEW_NOTE_EXTRA, true);
                crearNotaFragment.setArguments(bundle);
                fragmentTransaction.add(R.id.contenedor_nota, crearNotaFragment, "AGREGAR_NOTA_FRAGMENT");
                break;

        }


        vistaNotaFragment vistaNotaFragmento = new vistaNotaFragment();


        fragmentTransaction.commit();
    }

}

