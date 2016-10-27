package com.example.daniel.quicknotes;



import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class NotesDBHelper  {




    public static final String DATABASE_NAME = "Quicknotes.db";
    public static final String TABLE_NAME = "notas";
    public static final String COL_ID = "ID";
    public static final String COL_TITULO = "TITULO";
    public static final String COL_DESCRIPCION = "DESCRIPCION";
    public static final String COL_TIPO = "TIPO";
    public static final String COL_FECHA = "FECHA";

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + TABLE_NAME + "(" + COL_ID+ " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COL_TITULO + "TEXT,"
                    + COL_DESCRIPCION+ "TEXT,"
                    + COL_TIPO + "INTEGER NOT NULL,"
                    + COL_FECHA +" TEXT" + ")";

   private String[] columnas = {COL_ID , COL_TITULO, COL_DESCRIPCION, COL_TIPO, COL_FECHA};

    private static final String SQL_UPGRADE =
            "DROP TABLE IF EXISTS" + TABLE_NAME;

    private SQLiteDatabase sqlDB;
    private Context context;

    private notasDB notasDB;

    public NotesDBHelper(Context ctx){
        context = ctx;
    }

    public NotesDBHelper open() throws android.database.SQLException{
        notasDB = new notasDB(context);
        sqlDB = notasDB.getWritableDatabase();
        return this;
    }

    public void close(){
        notasDB.close();
    }

    private static class notasDB extends SQLiteOpenHelper {
        public notasDB(Context context) {
            super(context, DATABASE_NAME, null, 1);
            SQLiteDatabase db = this.getWritableDatabase();
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(SQL_CREATE_ENTRIES);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL(SQL_UPGRADE);
            onCreate(db);
        }

        public boolean insert(String titulo, String descripcion, int tipo, String fecha) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(COL_TITULO, titulo);
            contentValues.put(COL_DESCRIPCION, descripcion);
            contentValues.put(COL_TIPO, tipo);
            contentValues.put(COL_FECHA, fecha);
            long result = db.insert(TABLE_NAME, null, contentValues);
            if (result == -1)
                return false;
            else
                return true;

        }
    }
}

