package com.example.daniel.quicknotes;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.app.ListFragment;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class listaNotasFragment extends ListFragment {

    private ArrayList<Nota> notas;
    private AdaptadorNota notaAdaptador;
    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        notas = new ArrayList<Nota>();
        notas.add(new Nota("Titulo nota", "La nota" , 1));
        notas.add(new Nota("Titulo nota 2", "La nota 2 " , 1));
        notas.add(new Nota("Titulo nota 3", "La nota 2" , 1));
        notaAdaptador = new AdaptadorNota(getActivity(), notas);
        setListAdapter(notaAdaptador);

        registerForContextMenu(getListView());

    }

    @Override
    public void onListItemClick(ListView l, View v , int position, long id){
        super.onListItemClick(l, v, position ,id);
        abrirDetalleNota(position);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu , View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getActivity().getMenuInflater();

        menuInflater.inflate(R.menu.menu_pantalla,menu);

    }


    @Override
    public boolean onContextItemSelected(MenuItem item){
        switch(item.getItemId()) {
            case R.id.edit:
                //se selecciono la opcion editar
                return true;
        }
        return super.onContextItemSelected(item);
    }


    private void abrirDetalleNota(int posicion) {
        Nota nota = (Nota) getListAdapter().getItem(posicion);
        Intent intent = new Intent(getActivity(), notaDetalleActivity.class);
        intent.putExtra(pantallaPrincipal.NOTA_TITLE_EXTRA, nota.getTitulo());
        intent.putExtra(pantallaPrincipal.NOTA_DESCRIPCION_EXTRA, nota.getDescripcion());
        intent.putExtra(pantallaPrincipal.NOTA_TIPO_EXTRA, nota.getTipo());
        intent.putExtra(pantallaPrincipal.NOTA_ID_EXTRA, nota.getIdNota());
        startActivity(intent);

    }

}

