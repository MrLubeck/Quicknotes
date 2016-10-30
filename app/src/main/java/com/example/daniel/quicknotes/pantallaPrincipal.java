package com.example.daniel.quicknotes;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class pantallaPrincipal extends AppCompatActivity {

    public static final String NOTA_ID_EXTRA = "com.example.daniel.quickNotes.Nota identificador";
    public static final String NOTA_TITLE_EXTRA = "com.example.daniel.quickNotes.Nota titulo";
    public static final String NOTA_DESCRIPCION_EXTRA = "com.example.daniel.quickNotes.Texto nota";
    public static final String NOTA_TIPO_EXTRA = "com.example.daniel.quickNotes.1";
    public static final String NOTE_FRAGMENTO_ACTIVO = "com.example.daniel.quickNotes. Fragmento que se lanzara";
    public enum fragmento{ DETALLE, EDITAR, CREAR}


    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if(id == R.id.agregarNota){
            Intent intent = new Intent(this, notaDetalleActivity.class);
            intent.putExtra(pantallaPrincipal.NOTE_FRAGMENTO_ACTIVO, fragmento.CREAR);
            startActivity(intent);
            return true;

        }

        return super.onOptionsItemSelected(item);

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_principal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       /* FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

}
