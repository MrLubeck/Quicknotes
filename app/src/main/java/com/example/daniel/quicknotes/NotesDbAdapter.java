package com.example.daniel.quicknotes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by Daniel on 11/18/2016.
 */
public class NotesDbAdapter {

    public static final String DATABASE_NAME = "quicknotes.db";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "notas";
    public static final String COL_ID = "_id";
    public static final String COL_TITULO = "titulo";
    public static final String COL_DESCRIPCION = "descripcion";
    public static final String COL_TIPO = "tipo";
    public static final String COL_FECHA = "fecha";

    private static final String CREATE_TABLE_NOTES =
            "CREATE TABLE " + TABLE_NAME + " ( "   + COL_ID+ " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + COL_TITULO + " TEXT, "
                    + COL_DESCRIPCION+ " TEXT, "
                    + COL_TIPO + " INTEGER NOT NULL, "
                    + COL_FECHA +");";

    private String[] columnas = {COL_ID , COL_TITULO, COL_DESCRIPCION, COL_TIPO, COL_FECHA};

    private static final String SQL_UPGRADE =
            "DROP TABLE IF EXISTS " + TABLE_NAME;

    private SQLiteDatabase sqlDB;
    private Context context;



    private NotebookDBHelper notebookDBHelper;


    public NotesDbAdapter(Context ctx){
        context = ctx;
    }

    public NotesDbAdapter open() throws android.database.SQLException{
        notebookDBHelper = new NotebookDBHelper(context);
        sqlDB =  notebookDBHelper.getWritableDatabase();
        return this;

    }

    public void close(){
        notebookDBHelper.close();
    }

    public Nota crearNota(String titulo, String descripcion , int tipo){
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_TITULO, titulo);
        contentValues.put(COL_DESCRIPCION, descripcion);
        contentValues.put(COL_TIPO, tipo);
        contentValues.put(COL_FECHA, Calendar.getInstance().getTimeInMillis() + "");
        long insertId = sqlDB.insert(TABLE_NAME, null, contentValues);
        Cursor cursor = sqlDB.query(TABLE_NAME,  columnas, COL_ID + " = " + insertId, null, null, null, null);
        cursor.moveToFirst();
        Nota nuevaNota = cursorNota(cursor);
        cursor.close();
        return nuevaNota;
    }

    public long editarNota(long idNota, String titulo, String contenido){
        ContentValues values = new ContentValues();
        values.put(COL_TITULO, titulo);
        values.put(COL_DESCRIPCION, contenido);

        values.put(COL_FECHA, Calendar.getInstance().getTimeInMillis() + "");
        return sqlDB.update(TABLE_NAME, values, COL_ID +" = "+ idNota ,null);

    }

    public long borrarNota(long idNota){
        return sqlDB.delete(TABLE_NAME, COL_ID + " =  " +idNota, null);
    }



    public ArrayList<Nota> getNotes(){
        ArrayList<Nota> notas = new ArrayList<Nota>();

        Cursor cursor = sqlDB.query(TABLE_NAME, columnas, null, null,null, null, null );
        for(cursor.moveToLast(); !cursor.isBeforeFirst(); cursor.moveToPrevious()){
            Nota nota = cursorNota(cursor);
            notas.add(nota);
        }
        cursor.close();
        return notas;
    }

    public Nota cursorNota(Cursor cursor){
        Nota nuevaNota = new Nota(cursor.getString(1),cursor.getString(2), cursor.getInt(3), cursor.getLong(0), cursor.getLong(4));
        return nuevaNota;
    }



    private static class NotebookDBHelper extends SQLiteOpenHelper{
        NotebookDBHelper(Context ctx){
            super(ctx , DATABASE_NAME , null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db){
            db.execSQL(CREATE_TABLE_NOTES);

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
            db.execSQL("DROP TABLE IF EXISTS " +TABLE_NAME);
            onCreate(db);
        }
    }

}

