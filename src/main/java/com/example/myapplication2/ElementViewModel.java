package com.example.myapplication2;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ElementViewModel extends AndroidViewModel {
    private final ElementRepository mRepository;
    private final LiveData<List<Element>> mAllElements;

    public ElementViewModel(@NonNull Application application) {
        super(application);
        mRepository =new ElementRepository(application);
        mAllElements = mRepository.getAllElements();//pobranie wszystich metod z repozytorium;
    }

    LiveData<List<Element>> getAllElements(){
        //zwraaca wszystkie elementy
        return mAllElements;
    }

    public void deleteAll(){
        //skasowanie wszystkich elementów z repozytorium
        mRepository.deleteAll();
    }

    public void insertValue(Element element){
        mRepository.insert(element);
    }

    public void delete(Element element){
        mRepository.delete(element);
    }

}
