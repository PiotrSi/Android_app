package com.example.myapplication2;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "phones")
public class Element {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "nazwa_kolumny1")
    private long Kolumna;

    @NonNull
    @ColumnInfo(name = "nazwa_kolumny2")
    private String Kolumna2;

    public Element(@NonNull String Kolumna2) {
        this.Kolumna2 = Kolumna2;
    }

    public long getKolumna() {
        return Kolumna;
    }

    public void setKolumna(long mKolumna) {
        this.Kolumna = mKolumna;
    }

    @NonNull
    public String getKolumna2() {
        return Kolumna2;
    }

    public void setKolumna2(@NonNull String mKolumna2) {
        this.Kolumna2 = mKolumna2;
    }
}
