package com.example.diazr.hunter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;

/**
 * Created by regnierk on 23/03/17.
 */

public class Poster_Offre extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poster_offre);
    }

    public void redirigeDisponibilite(View v) {
        if(dataVerification()){
            Intent intent = new Intent (Poster_Offre.this, Dispo_Offre.class);
            startActivity(intent);
        }else{
            new AlertDialog.Builder(this)
                    .setTitle("Erreur")
                    .setMessage("Il manque des données, vérifiez les champs et essayez à nouveau.")
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        }
    }

    /**
     * Verifie les champs de données de la page activity_poster_offre.
     * @return true     Si tous les champs sont remplis.
     * @return false    Si au moins un des champs est vide.
     * */
    public boolean dataVerification(){
        final EditText nom_poste = (EditText)findViewById(R.id.nom_poste);
        final EditText description = (EditText)findViewById(R.id.description);
        final EditText nb_heure = (EditText)findViewById(R.id.nb_heure);
        return (nom_poste.getText().toString() != null && !nom_poste.getText().toString().equals("")
        && description.getText().toString() != null && !description.getText().toString().equals("")
        && nb_heure.getText().toString() != null && !nb_heure.getText().toString().equals(""));
    }

}