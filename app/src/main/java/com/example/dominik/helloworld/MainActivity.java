package com.example.dominik.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button showButton;
    Button deleteButton;
    Button checkButton;
    CheckBox checkBox;
    TextView helloText;
    Spinner langSpinner;
    char language;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showButton= findViewById(R.id.showButton);
        deleteButton = findViewById(R.id.deleteButton);
        checkButton = findViewById(R.id.checkButton);
        checkBox = findViewById(R.id.checkBox);
        helloText = findViewById(R.id.helloText);
        langSpinner = findViewById(R.id.langSpinner);
        language = 'd';

        //Textfeld sichtbar machen und jeweils sprachspezifische Ausgabe
        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helloText.setVisibility(View.VISIBLE);
                if(language=='e'){
                    helloText.setText("Hello World!");
                }else if(language=='k') {
                    helloText.setText("Pozdrav svijete!");
                }else{
                    helloText.setText("Hallo Welt");
                }
            }
        });

        //Textfeld unsichtbar machen
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helloText.setVisibility(View.INVISIBLE);
            }
        });

        //Checkbox checken
        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked = checkBox.isChecked();
                Toast toast = Toast.makeText(getApplicationContext(), "Die Checkbox wurde "+ (checked==true?"angeklickt.":"nicht angeklickt."), Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        //Sprache auswählen in Spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.language,android.R.layout.simple_spinner_dropdown_item);
        langSpinner.setAdapter(adapter);
        langSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
              @Override
              public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                  switch(position){
                      case 1:
                          language='e';
                          break;
                      case 2:
                          language='k';
                          break;
                      default:
                          language='d';
                          break;
                  }
                  helloText.setVisibility(View.INVISIBLE);
              }

              @Override
              public void onNothingSelected(AdapterView<?> parent) {

              }
          }
        );

    }
}
