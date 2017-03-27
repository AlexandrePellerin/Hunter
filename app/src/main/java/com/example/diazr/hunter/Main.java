package com.example.diazr.hunter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import connexion.Connexion_Client;
import connexion.Connexion_Recrut;

public class Main extends AppCompatActivity {

        Button chercher;
        Button recruter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // On récupère les boutons "chercher" et "recruter"
        chercher = (Button) findViewById(R.id.chercher);
        recruter = (Button) findViewById(R.id.recruter);
    }


    //Redirection vers l'inscription client
    public void redirigeCli(View view) {
        Intent intent = new Intent(Main.this, Connexion_Client.class);
        startActivity(intent);
    }

    //Redirige vers l'inscription recruteur
    public void redirigeRecru(View view) {
        Intent intent = new Intent(Main.this, Connexion_Recrut.class);
        startActivity(intent);
    }
}
