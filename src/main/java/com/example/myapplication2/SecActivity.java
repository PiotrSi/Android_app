package com.example.myapplication2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
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
    Long id;
    boolean czyEdit=false;
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

        Intent zamiar = getIntent();
        if(zamiar.hasExtra("manufacturer")){
            setTitle("Edit");
            czyEdit = true;
            Bundle pakunek= getIntent().getExtras();
            id =pakunek.getLong("id");
            manufacturer.setText(zamiar.getStringExtra("manufacturer"));
            model.setText(zamiar.getStringExtra("model"));
            version.setText(zamiar.getStringExtra("version"));
            web.setText(zamiar.getStringExtra("web"));
            save.setText("UPDDATE");
        }else{
            setTitle("Save");
        }

        save.setOnClickListener(new View.OnClickListener()
                                  {
                                      @Override
                                      public void onClick(View v)
                                      {
                                          if(waliduj()) {
                                              Intent zamiar = new Intent();
                                              //pobrane warości
                                              zamiar.putExtra("manufacturer", manufacturer.getText().toString());
                                              zamiar.putExtra("model", model.getText().toString());
                                              zamiar.putExtra("version", version.getText().toString());
                                              zamiar.putExtra("web", web.getText().toString());
                                              if (czyEdit) {
                                                  Bundle pakunek = new Bundle();
                                                  pakunek.putLong("id", id);
                                                  zamiar.putExtras(pakunek);
                                                  setResult(RESULT_OK, zamiar);
                                              } else {
                                                  setResult(RESULT_OK, zamiar);
                                              }
                                              finish();
                                          }else{

                                          }
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
                                          String adres = web.getText().toString();
                                          if(!adres.isEmpty()){
                                              if(!adres.startsWith("http://")){
                                                  adres="http://"+adres;
                                              }
                                              Intent przegladarka = new Intent("android.intent.action.VIEW", Uri.parse(adres));
                                              startActivity(przegladarka);
                                          }
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

    private boolean waliduj(){
        String manufa =  manufacturer.getText().toString();
        String mode = model.getText().toString();
        String vers = version.getText().toString();
        String webb = web.getText().toString();
        if(!(manufa.length() > 0))
        manufacturer.setError(getString(R.string.manufacturerErr));
        if(!(model.length() > 0))
            model.setError(getString(R.string.modelErr));
        if(!(version.length() > 0))
            version.setError(getString(R.string.versionErr));
        if(!(web.length() > 0))
            web.setError(getString(R.string.webErr));
        return (manufa.length() > 0 && mode.length() > 0 && vers.length() > 0 && webb.length() > 0);
    }

}
