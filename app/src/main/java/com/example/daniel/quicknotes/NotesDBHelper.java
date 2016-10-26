package com.example.daniel.quicknotes;



import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class NotesDBHelper extends SQLiteOpenHelper {


    public static final String DATABASE_NAME = "Quicknotes.db";
    public static final String TABLE_NAME = "notas";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "TITULO";
    public static final String COL_3 = "DESCRIPCION";
    public static final String COL_4 = "TIPO";
    public static final String COL_5 = "FECHA";

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + TABLE_NAME + "(" + COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COL_2 + "TEXT,"
                    + COL_3 + "TEXT,"
                    + COL_4 + "INTEGER NOT NULL,"
                    + COL_5 +" TEXT" + ")";

    private static final String SQL_UPGRADE =
            "DROP TABLE IF EXISTS" + TABLE_NAME;


    public NotesDBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL(SQL_UPGRADE);
        onCreate(db);
    }

    public boolean insert(String titulo, String descripcion , int tipo, String fecha){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, titulo);
        contentValues.put(COL_3, descripcion);
        contentValues.put(COL_4, tipo );
        contentValues.put(COL_5, fecha);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if(result == -1)
            return false;
        else
            return true;

    }

}

