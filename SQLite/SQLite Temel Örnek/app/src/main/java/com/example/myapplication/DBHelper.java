package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        //Veritabanı adı = sozluk
        super(context, "sozluk", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // tabloları oluşturalım. tablo adı = kelimeler
        db.execSQL("CREATE TABLE IF NOT EXISTS kelimeler(id INTEGER PRIMARY KEY AUTOINCREMENT, tr TEXT, eng TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS kelimeler");
        onCreate(db);
    }

    public void kelimeEkle(String turkcekelime, String ingilizceKelime) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues degerler = new ContentValues();
        degerler.put("tr",turkcekelime);
        degerler.put("eng",ingilizceKelime);
        db.insert("kelimeler",null,degerler);
        db.close();
    }

    public void kelimeDuzenle(int kelimeid, String turkcekelime, String ingilizceKelime) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues degerler = new ContentValues();
        degerler.put("tr", turkcekelime);
        degerler.put("eng", ingilizceKelime);
        db.update("kelimeler",degerler,"id=?", new String[] {String.valueOf(kelimeid)});
        db.close();
    }

    public void kelimeSil(int kelimeid) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("kelimeler","id=?",new String[]{String.valueOf(kelimeid)});
        db.close();
    }
/*
    public ArrayList<Kelime> tumKelimeler() {
        ArrayList<Kelime> kelimeListesi = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String sorgu = "SELECT * FROM kelimeler";
        Cursor c = db.rawQuery(sorgu,null);

        while(c.moveToNext()) {
            Kelime k = new Kelime(c.getInt(c.getColumnIndex("id")),
                    c.getString(c.getColumnIndex("tr")),
                    c.getString(c.getColumnIndex("en")));
            kelimeListesi.add(k);
        }
        db.close();
        return kelimeListesi;
    }
*/

}
