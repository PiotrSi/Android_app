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
    @ColumnInfo(name = "manufacturer")
    private String manufacturer;

    @NonNull
    @ColumnInfo(name = "model")
    private String model;


    public Element(@NonNull String manufacturer,@NonNull String model) {
        this.manufacturer = manufacturer;
        this.model = model;
    }



    public long getKolumna() {
        return Kolumna;
    }

    public void setKolumna(long kolumna) {
        Kolumna = kolumna;
    }

    @NonNull
    public String getManufacturer() {
        return manufacturer;
    }
    @NonNull
    public String getModel() {
        return model;
    }


    public void setModel(@NonNull String model) {
        this.model = model;
    }
    public void setManufacturer(@NonNull String manufacturer) {
        this.manufacturer = manufacturer;
    }

}
