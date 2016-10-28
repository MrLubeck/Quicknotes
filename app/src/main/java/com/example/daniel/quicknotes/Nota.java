package com.example.daniel.quicknotes;


import android.preference.PreferenceCategory;

public class Nota {

    private String titulo;
    private String descripcion;
    private long idNota;
    private long fecha;
    private int tipo;


    public Nota(String titulo, String descripcion, int tipo){
        this.titulo= titulo;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.idNota = 0;
        this.fecha = 0;

    }

    public Nota(String titulo, String descripcion, int tipo, long idNota, long fecha){
        this.titulo= titulo;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.idNota = idNota;
        this.fecha = fecha;

    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public long getIdNota() {
        return idNota;
    }

    public long getFecha() {
        return fecha;
    }

    public int getTipo() {
        return tipo;
    }

    public String toString(){
        String tipoNota = "";
        switch(getTipo()){
            case 1:
                tipoNota = "Estandar";
                break;

            case 2:
                tipoNota = "Checklist";
                break;

            case 3:
                tipoNota = "Audio";
                break;
        }

        return "ID: " + getIdNota() + "Titulo: " + getTitulo() + "Descripcion: " + getDescripcion() + "Tipo de nota: "  + tipoNota + "Fecha:" + getFecha();
    }

    public static int imagenTipoNota(int tipo){
        switch(tipo){
            case 1:
                //return R.drawable.imgNotaEstandar;
                break;

            case 2:
                //return R.drawable.imgChecklist;
                break;

            case 3:
                //return R.drawable.imgNotaAudio;
                break;


        }
        return 0;
    }

    public int getImagenNota(int tipo){
        return imagenTipoNota(tipo);
    }

}
