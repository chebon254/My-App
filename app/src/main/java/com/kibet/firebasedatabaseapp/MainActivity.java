package com.kibet.firebasedatabaseapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText name,email,number;
    Button save,view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.editname);
        email = findViewById(R.id.editemail);
        number =findViewById(R.id.editphone);
        save =findViewById(R.id.btnsave);
        view =findViewById(R.id.btnview);

    }
}
