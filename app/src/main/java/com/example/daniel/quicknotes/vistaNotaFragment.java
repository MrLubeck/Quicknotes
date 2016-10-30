package com.example.daniel.quicknotes;




        import android.content.Intent;
        import android.os.Bundle;
        import android.support.v4.app.Fragment;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class vistaNotaFragment extends Fragment {


    public vistaNotaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View fragmentLayout = inflater.inflate(R.layout.fragment_vista_nota,container,false);
        TextView titulo = (TextView) fragmentLayout.findViewById(R.id.verTituloNota);
        TextView descripcion = (TextView) fragmentLayout.findViewById(R.id.verDescripcionNota);

        Intent intent = getActivity().getIntent();

        titulo.setText(intent.getExtras().getString(pantallaPrincipal.NOTA_TITLE_EXTRA));
        descripcion.setText(intent.getExtras().getString(pantallaPrincipal.NOTA_DESCRIPCION_EXTRA));
        return fragmentLayout; }

}
