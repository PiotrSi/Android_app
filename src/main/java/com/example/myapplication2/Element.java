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

    @NonNull
    @ColumnInfo(name = "version")
    private String version;

    @NonNull
    @ColumnInfo(name = "web")
    private String web;

    public Element(@NonNull String manufacturer,@NonNull String model,@NonNull String version,@NonNull String web) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.version = version;
        this.web = web;
    }
//
//    public Element(@NonNull long Kolumna,@NonNull String manufacturer,@NonNull String model,@NonNull String version,@NonNull String web) {
//        this.Kolumna = Kolumna;
//        this.manufacturer = manufacturer;
//        this.model = model;
//        this.version = version;
//        this.web = web;
//    }

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
    @NonNull
    public String getVersion() {
        return version;
    }
    @NonNull
    public String getWeb() {
        return web;
    }


    public void setModel(@NonNull String model) {
        this.model = model;
    }
    public void setManufacturer(@NonNull String manufacturer) {
        this.manufacturer = manufacturer;
    }
    public void setVersion(@NonNull String version) {
        this.version = version;
    }
    public void setWeb(@NonNull String web) {
        this.web = web;
    }

}
