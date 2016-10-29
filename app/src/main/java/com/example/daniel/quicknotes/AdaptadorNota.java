package com.example.daniel.quicknotes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AdaptadorNota extends ArrayAdapter<Nota>{

    public static class ViewHolder{
        TextView titulo;
        TextView descripcion;
    }
    public AdaptadorNota(Context context, ArrayList<Nota> notas){
        super (context, 0 , notas);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Nota nota = getItem(position);

        ViewHolder viewHolder;

        if(convertView == null){
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.nota_lista, parent, false);

            viewHolder.titulo = (TextView) convertView.findViewById(R.id.listaTituloNota);
            convertView.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder ) convertView.getTag();
        }
        viewHolder.titulo.setText(nota.getTitulo());
        return convertView;
    }

}
