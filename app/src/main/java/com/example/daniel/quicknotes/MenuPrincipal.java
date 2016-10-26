package com.example.daniel.quicknotes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MenuPrincipal extends AppCompatActivity {
    NotesDBHelper myDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
    }
}
