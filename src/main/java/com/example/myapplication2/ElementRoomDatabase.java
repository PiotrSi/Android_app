package com.example.myapplication2;


import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Element.class}, version = 2,exportSchema = false)
public abstract class ElementRoomDatabase extends RoomDatabase {

    //zwraca DAO
    public abstract ElementDao elementDao();
    //implementacja singletona
    private static volatile ElementRoomDatabase INSTANCE;

    static ElementRoomDatabase getDatabase(final Context context) {
        //tworzenie nowego obiektu tylko gdy żaden nie isnieje
        if (INSTANCE == null) {
            synchronized (ElementRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            ElementRoomDatabase.class, "phones")
                            //ustawienie obiektu obsługiwającego zdarzenie związane z bazą (na dole)
                            .addCallback(sRoomDatabaseCallBack)
                            //najprostsza migracja - skasowaniei utworzenie bazy od nowa
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    //usługa wykonawcza do wykonania zadań w osobnym wątku
    private static final int NUMBER_OF_THREADS =4;
    static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);


    private static RoomDatabase.Callback sRoomDatabaseCallBack = new RoomDatabase.Callback(){
      //pierwsze uruchomienie aplikacji, gdy baza nie istnieje


        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
//            Element pierwszy = new Element("wartosc");
            //wykonanie operacji na osobnym wątku
            databaseWriteExecutor.execute(()->{
                    ElementDao dao = INSTANCE.elementDao();
                    //twoarzenie alementów (obiektów klazy Element)
                    //i dodanie ich do bazy danych
                    //tutaj możemy określić początkową zawartość bazy danych
                    //Element pierwszy = new Element("wartosc");
                    //ElementViewModel.insertValue(pierwszy);
//                    dao.insert(pierwszy);
                    }
                    );
        }
    };


}