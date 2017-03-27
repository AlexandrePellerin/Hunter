package inscription;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.support.v4.app.DialogFragment;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.diazr.hunter.R;

import connexion.Connexion_Client;
import connexion.Connexion_Recrut;

public class Client_Inscription extends AppCompatActivity {

    private SeekBar seekBar_Rayon;
    private TextView textView_Rayon;
    private String horaires;
    int rayon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client__inscription);
        seekBar_Rayon = (SeekBar) findViewById(R.id.seekBar_Rayon);
        textView_Rayon = (TextView) findViewById(R.id.textView_Rayon);
        rayon = 1;
        textView_Rayon.setText("Mon rayon de demande : " + rayon + " KM");

        seekBar_Rayon.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {
                rayon = progresValue;
                textView_Rayon.setText("Mon rayon de demande : " + rayon + " KM");

            }
            public void onStartTrackingTouch(SeekBar seekBar) {}
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

    }
    public  void  do_DateNaiss(View view) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");

    }

    public void doChoosePhoto(View view){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Contact Image"), 1);
    }

    public  void  do_ChooseCV(View view) {
        Intent file_Chooser = new Intent("com.sec.android.app.myfiles.PICK_DATA");
        file_Chooser.putExtra("CONTENT_TYPE", "*/*");
        file_Chooser.addCategory(Intent.CATEGORY_DEFAULT);
    }

    public void disponibility(View view){
        Intent intent = new Intent(Client_Inscription.this, Disponibility.class);
        startActivityForResult(intent,2);
    }
    /**
     * Retour de l'activité Disponibility
     * */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        // si le resultat vient de Disponibility
        if(requestCode==2) {
            horaires = data.getStringExtra("HORAIRES");
        }
    }

    /**
     * Redirige vers le menu lorsque l'utilisateur appuye sur "Enregistrer"
     * Si il manque des donnees un message d'erreur demandant à l'utilisateur si il veut
     * éditer de nouveau ses données ou bien revenir au menu.
     * */
    public void redirectMainMenu(View v){
        if(dataVerification()){
            //Aucun champs vides, reste à verifier leur intégrité
            //par exemple si le champ mail contient bien une adresse mail...
            //une fois que les champs seront bien verifies on retourne au menu.
            Intent intent = new Intent(this, Connexion_Client.class);
            startActivity(intent);

        }else{
            //oubli des horaires
            if(horaires == null){
                new AlertDialog.Builder(this)
                        .setTitle("Erreur")
                        .setMessage("Aucun horaire n'est renseigné")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                //Ne rien faire.
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            }
            //Un ou plusieurs champs vide.
            new AlertDialog.Builder(this)
                    .setTitle("Erreur")
                    .setMessage("Un ou plusieurs champs vide")
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            //Continuer a éditer les champs
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        }
    }

    /**
     * Verifie que tous les champs de données sont bien remplis.
     * @return true Si tous les champs sont remplis.
     * @return false Si au moins un champ est vide.
     * */
    public boolean dataVerification(){
        final EditText nom = (EditText)findViewById(R.id.inscription_client_nom);
        final EditText prenom = (EditText)findViewById(R.id.inscription_client_prenom);
        final EditText mail = (EditText)findViewById(R.id.inscription_client_mail);
        final EditText password = (EditText)findViewById(R.id.inscription_client_password);
        final String vnom = nom.getText().toString();
        final String vprenom = prenom.getText().toString();
        final String vmail = mail.getText().toString();
        final String vpassword = password.getText().toString();
        return (vnom != null && !vnom.equals("")
        && vmail != null && !vmail.equals("")
        && vprenom != null && !vprenom.equals("") && vpassword != null && !vpassword.equals("") && horaires != null);
    }
}


