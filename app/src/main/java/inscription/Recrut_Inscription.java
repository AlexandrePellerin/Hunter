package inscription;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.diazr.hunter.Poster_Offre;
import com.example.diazr.hunter.R;

/**
 * Created by regnierk on 23/03/17.
 */

public class Recrut_Inscription extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recrut_inscription);
    }

    public void redirigeOffre(View v) {
        if(dataVerification()){
            //Aucune case vide
            //Reste à vérifier si les données entrées sont corrects.
            Intent intent = new Intent(Recrut_Inscription.this, Poster_Offre.class);
            startActivity(intent);
        }else{
            new AlertDialog.Builder(this)
                    .setTitle("Erreur")
                    .setMessage("Il manque des données, vérifiez les champs et essayez à nouveau.")
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            //On laisse l'utilisateur éditer les champs.
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        }
    }

    /**
     * Verifie que les champs de la page activity_recrut_inscription soient tous remplis.
     * @return true Si tous les champs contiennent au moins un caractere
     * @return false Si au moins un champs est vide.
     * */
    public boolean dataVerification(){
        final EditText nom_societe = (EditText)findViewById(R.id.nom_societe);
        final EditText nom_recru = (EditText)findViewById(R.id.nom_recru);
        final EditText mail_recru = (EditText)findViewById(R.id.mail_recru);
        final EditText passwd_recru = (EditText)findViewById(R.id.passwd_recru);
        final EditText num_siret = (EditText)findViewById(R.id.num_siret);
        final EditText adresse = (EditText)findViewById(R.id.adresse);
        String vnom_societe = nom_societe.getText().toString();
        String vnom_recru = nom_recru.getText().toString();
        String vmail_recru = mail_recru.getText().toString();
        String vpasswd = passwd_recru.getText().toString();
        String vnum_siret = num_siret.getText().toString();
        String vadresse = adresse.getText().toString();
        return (vnom_societe != null && !vnom_societe.equals("")
        && vnom_recru != null && !vnom_recru.equals("")
        && vmail_recru != null && !vmail_recru.equals("")
        && vpasswd != null && !vpasswd.equals("")
        && vnum_siret != null && !vnum_siret.equals("")
                && vadresse != null && !vadresse.equals(""));
    }
}
