package com.example.daniel.quicknotes;


import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class EditarNotaFragment extends Fragment{

    private EditText titulo;
    private EditText descripcion;
    private int tipo = 1;
    private AlertDialog popupGuardar;


    private long idNota = 0;
    private boolean newNote = false;

    public EditarNotaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Bundle bundle = this.getArguments();
        if(bundle != null){
            newNote = bundle.getBoolean(notaDetalleActivity.NEW_NOTE_EXTRA, false);
        }

        View fragmentLayout = inflater.inflate(R.layout.fragment_editar_nota, container, false);
        titulo = (EditText) fragmentLayout.findViewById(R.id.editarTituloNota);
        descripcion = (EditText) fragmentLayout.findViewById(R.id.editarDescripcionNota);
        Button botonGuardar = (Button)fragmentLayout.findViewById(R.id.guardarCambio) ;


        popupConfirm();
        botonGuardar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                popupGuardar.show();
            }

        });


        Intent intent = getActivity().getIntent();
        idNota = intent.getExtras().getLong(pantallaPrincipal.NOTA_ID_EXTRA);
        titulo.setText(intent.getExtras().getString(pantallaPrincipal.NOTA_TITLE_EXTRA, ""));
        descripcion.setText(intent.getExtras().getString(pantallaPrincipal.NOTA_DESCRIPCION_EXTRA,""));
        return fragmentLayout;
    }

    private void popupConfirm(){
        AlertDialog.Builder confirm = new AlertDialog.Builder(getActivity());
        confirm.setTitle("Confirmacion");
        confirm.setMessage("¿Desea guardar esta nota?");

        confirm.setPositiveButton("Guardar", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogo , int opcion){

                NotesDbAdapter dbAdapter = new NotesDbAdapter(getActivity().getBaseContext());
                dbAdapter.open();
                if(newNote){
                    dbAdapter.crearNota(titulo.getText() + "", descripcion.getText()+ "", tipo );
                }
                else
                {
                    dbAdapter.editarNota(idNota,titulo.getText() + "" , descripcion.getText() + "" );
                }
                Intent intent = new Intent(getActivity(), pantallaPrincipal.class);
                startActivity(intent);

            }
        });
        confirm.setNegativeButton("Cancelar", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogo, int opcion){

            }
        });

        popupGuardar = confirm.create();


    }

}
