package com.example.daniel.quicknotes;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class pantallaPrincipal extends AppCompatActivity {

    public static final String NOTA_ID_EXTRA = "com.example.daniel.quickNotes.Nota identificador";
    public static final String NOTA_TITLE_EXTRA = "com.example.daniel.quickNotes.Nota titulo";
    public static final String NOTA_DESCRIPCION_EXTRA = "com.example.daniel.quickNotes.Texto nota";
    public static final String NOTA_TIPO_EXTRA = "com.example.daniel.quickNotes.1";

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
