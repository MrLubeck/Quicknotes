package com.example.daniel.quicknotes;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class listaNotasFragment extends ListFragment {


   @Override
    public void onActivityCreated(Bundle savedInstanceState){
       super.onActivityCreated(savedInstanceState);

   }

    @Override
    public void onListItemClick(ListView l, View v , int position, long id){
        super.onListItemClick(l, v, position ,id);
    }

}
