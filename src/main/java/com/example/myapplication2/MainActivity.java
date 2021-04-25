package com.example.myapplication2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    private ElementViewModel mElementViewModel;;
    private ElementListAdapter mAdapter;
    FloatingActionButton button;
    private static final int REQUEST_CODE = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button= findViewById(R.id.fabMain);

        //ustawienie adaptera na liście, ustawienie Layutu elementów listy
        RecyclerView recyclerView = findViewById(R.id.activity_main);
        mAdapter = new ElementListAdapter(this);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //odczytanie modelu widoku z dostawcy
        mElementViewModel = new ViewModelProvider(this).get(ElementViewModel.class);

        //gdy zmienią się dane w obiekcie live data w mdelu widoku zostanie
        //wywołana metodą ustwaiająca zmienioną listę elementów w adapterze
        mElementViewModel.getAllElements().observe(this,elements -> {
            mAdapter.setElementList(elements);
        });


        button.setOnClickListener(new View.OnClickListener()
                                  {
                                      @Override
                                      public void onClick(View v)
                                      {
                                          Intent zamiar = new Intent(MainActivity.this,SecActivity.class);

                                          //pobrane warości

                                          //odanie do intent'u
                                          //zamirt.putExtra(NAZWA,);

                                          startActivityForResult(zamiar,REQUEST_CODE);

                                          //Element pierwszy = new Element("wartosc");
                                          //mElementViewModel.insertValue(pierwszy);
                                      }
                                  }
        );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //tworzenie menu w aplikacji na podstawie XMLa
        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.pierwsza_opcja){
            //obsługa opcji

            //zwrócenie true = zakończenie obsługi opcji
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {

    }


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }


}
