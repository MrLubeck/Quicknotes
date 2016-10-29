package com.example.daniel.quicknotes;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class EditarNotaFragment extends Fragment{


    public EditarNotaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragmentLayout = inflater.inflate(R.layout.fragment_editar_nota, container, false);
        EditText titulo = (EditText) fragmentLayout.findViewById(R.id.editarTituloNota);
        EditText descripcion = (EditText) fragmentLayout.findViewById(R.id.editarDescripcionNota);

        Intent intent = getActivity().getIntent();
        titulo.setText(intent.getExtras().getString(pantallaPrincipal.NOTA_TITLE_EXTRA));
        descripcion.setText(intent.getExtras().getString(pantallaPrincipal.NOTA_DESCRIPCION_EXTRA));
        return fragmentLayout;
    }

}
