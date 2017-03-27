package inscription;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.support.v4.app.DialogFragment;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.diazr.hunter.R;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URISyntaxException;

import connexion.Connexion_Client;
import connexion.Connexion_Recrut;

public class Client_Inscription extends AppCompatActivity {

    private SeekBar seekBar_Rayon;
    private TextView textView_Rayon;
    private String horaires;
    ImageView imageView;
    int rayon;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client__inscription);
        seekBar_Rayon = (SeekBar) findViewById(R.id.seekBar_Rayon);
        textView_Rayon = (TextView) findViewById(R.id.textView_Rayon);
        rayon = seekBar_Rayon.getMax()/2;
        textView_Rayon.setText("Mon rayon de demande : " + rayon + " KM");

        seekBar_Rayon.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {
                rayon = progresValue;
                textView_Rayon.setText("Mon rayon de demande : " + rayon + " KM");

            }

            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void do_DateNaiss(View view) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");

    }


    public void doChoosePhoto(View view) {
        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
        photoPickerIntent.setType("image/*");
        startActivityForResult(photoPickerIntent, 3);
    }


    public void do_ChooseCV(View view) {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("*/*");
        intent.addCategory(Intent.CATEGORY_OPENABLE);

        try {
            startActivityForResult(
                    Intent.createChooser(intent, "Select a File to Upload"),
                    4);
        } catch (android.content.ActivityNotFoundException ex) {
            // Potentially direct the user to the Market with a Dialog
            Toast.makeText(this, "Please install a File Manager.",
                    Toast.LENGTH_SHORT).show();
        }
    }

    public void disponibility(View view) {
        Intent intent = new Intent(Client_Inscription.this, Disponibility.class);
        startActivityForResult(intent, 2);
    }

    /**
     * Retour de l'activité Disponibility
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // si le resultat vient de Disponibility
        if (requestCode == 2) {
            horaires = data.getStringExtra("HORAIRES");
        }
        if (requestCode == 3) {
            try {
                final Uri imageUri = data.getData();
                final InputStream imageStream = getContentResolver().openInputStream(imageUri);
                final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                imageView = (ImageView)findViewById(R.id.photo_Profil);
                imageView.setImageBitmap(selectedImage);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        if(requestCode == 4){
            if(resultCode == RESULT_OK && data != null){
                Uri uri = data.getData();
                Log.d("D", "File Uri: " + uri.toString());
                // Get the path
                String path = null;
                try {
                    path = FileUtils.getPath(this, uri);
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }
                Log.d("D", "File Path: " + path);
                // Get the file instance
                // File file = new File(path);
                // Initiate the upload
            }
        }

    }

    /**
     * Redirige vers le menu lorsque l'utilisateur appuye sur "Enregistrer"
     * Si il manque des donnees un message d'erreur demandant à l'utilisateur si il veut
     * éditer de nouveau ses données ou bien revenir au menu.
     */
    public void redirectMainMenu(View v) {
        if (dataVerification()) {
            //Aucun champs vides, reste à verifier leur intégrité
            //par exemple si le champ mail contient bien une adresse mail...
            //une fois que les champs seront bien verifies on retourne au menu.
            Intent intent = new Intent(this, Connexion_Client.class);
            startActivity(intent);

        } else {
            //oubli des horaires
            if (horaires == null) {
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
     *
     * @return false Si au moins un champ est vide.
     */
    public boolean dataVerification() {
        final EditText nom = (EditText) findViewById(R.id.inscription_client_nom);
        final EditText prenom = (EditText) findViewById(R.id.inscription_client_prenom);
        final EditText mail = (EditText) findViewById(R.id.inscription_client_mail);
        final EditText password = (EditText) findViewById(R.id.inscription_client_password);
        final String vnom = nom.getText().toString();
        final String vprenom = prenom.getText().toString();
        final String vmail = mail.getText().toString();
        final String vpassword = password.getText().toString();
        return (vnom != null && !vnom.equals("")
                && vmail != null && !vmail.equals("")
                && vprenom != null && !vprenom.equals("") && vpassword != null && !vpassword.equals("") && horaires != null);
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Client_Inscription Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}


