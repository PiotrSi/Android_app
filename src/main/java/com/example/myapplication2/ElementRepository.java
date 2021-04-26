package com.example.myapplication2;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class ElementRepository {
    private ElementDao mElementDao;
    private LiveData<List<Element>> mAllElements;


    ElementRepository(Application application){
        ElementRoomDatabase elementRoomDatabase = ElementRoomDatabase.getDatabase(application);

        //repozytorium korzysta z obiektu DAO do odwołań do bazy
        mElementDao = elementRoomDatabase.elementDao();
        mAllElements = mElementDao.getAlphabetizedElements();//odczytanie wszystkich elementów z dao;    ---------------------------
    }

    LiveData<List<Element>>getAllElements(){
        //zwraca wszystkie elementy
        return mAllElements;
    }

    void deleteAll(){
            ElementRoomDatabase.databaseWriteExecutor.execute(()->{
                //skasowanie wszystkich elementów za pomocą DAO
                mElementDao.deleteAll();
            });
    }

    void insert( Element element){
        ElementRoomDatabase.databaseWriteExecutor.execute(()->{
            //dodanie
            mElementDao.insert(element);
        });
    }

    void delete(Element element){
        ElementRoomDatabase.databaseWriteExecutor.execute(()->{
            //dodanie
            mElementDao.delete(element);
        });
    }
}
