package com.example.daniel.quicknotes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AdaptadorNota extends ArrayAdapter<Nota>{
    public AdaptadorNota(Context context, ArrayList<Nota> notas){
        super (context, 0 , notas);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Nota nota = getItem(position);
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.nota_lista, parent, false);
        }
        TextView tituloNota = (TextView) convertView.findViewById(R.id.listaTituloNota);
        tituloNota.setText(nota.getTitulo());

        return convertView;
    }

}