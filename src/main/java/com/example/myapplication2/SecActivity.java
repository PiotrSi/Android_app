package com.example.myapplication2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class SecActivity extends AppCompatActivity {
    EditText manufacturer;
    EditText model;
    EditText version;
    EditText web;
    TextView save;
    TextView cancel;
    TextView webSite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.table);
        manufacturer =findViewById(R.id.manufacturerInput);
        model =findViewById(R.id.modelInput);
        version =findViewById(R.id.versionInput);
        web =findViewById(R.id.webInput);
        save = findViewById(R.id.save);
        cancel = findViewById(R.id.cancel);
        webSite = findViewById(R.id.webSite);

        save.setOnClickListener(new View.OnClickListener()
                                  {
                                      @Override
                                      public void onClick(View v)
                                      {
                                          Intent zamiar = new Intent();
                                          Bundle pakunek = new Bundle();

                                          //pobrane warości
                                          pakunek.putString("manufacturer",manufacturer.getText().toString());
                                          pakunek.putString("model",model.getText().toString());
                                          pakunek.putString("version",version.getText().toString());
                                          //pakunek.putString("web",web.getText().toString());

                                          //odanie do intent'u
                                          zamiar.putExtras(pakunek);

                                          setResult(RESULT_OK,zamiar);
                                          finish();
                                      }
                                  }
        );
        cancel.setOnClickListener(new View.OnClickListener()
                                {
                                    @Override
                                    public void onClick(View v)
                                    {
                                        finish();
                                    }
                                }
        );

        webSite.setOnClickListener(new View.OnClickListener()
                                  {
                                      @Override
                                      public void onClick(View v)
                                      {
                                          // dalsza cześć lab
                                      }
                                  }
        );

    }



    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {


        super.onSaveInstanceState(outState);
    }



}
