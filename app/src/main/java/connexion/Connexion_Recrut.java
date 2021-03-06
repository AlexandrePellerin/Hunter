package connexion;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.diazr.hunter.R;
import inscription.Recrut_Inscription;

/**
 * Created by regnierk on 23/03/17.
 */

public class Connexion_Recrut extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.connexion_recrut);
    }

    public void redirigeInscrRecru(View view) {

        Intent intent = new Intent(Connexion_Recrut.this, Recrut_Inscription.class);
        startActivity(intent);
    }

    /*
    *  Verifie que les champs de données soient bien remplis et correct
    *  avant de passer à l'activité de connexion.
    * */
    public void dataVerification(View view){
        final EditText mail = (EditText)findViewById(R.id.mail);
        final EditText passwd = (EditText)findViewById(R.id.passwd);
        String valeurMail = mail.getText().toString();
        String valeurPassword = passwd.getText().toString();
        if(valeurMail != null && !valeurMail.equals("")
                && valeurPassword != null && !valeurPassword.equals("")){
            Log.d("Verification","Valeur de mail/password à verifier avant connexion");
            //on verifie que le mail et le password sont correct avec de se connecter
        }else{
            Log.d("Verification","Un ou plusieurs champs sont vides");
            //on affiche une pop-up pour avertir l'utilisateur qu'il lui manque un ou plusieurs champs
            new AlertDialog.Builder(this)
                    .setTitle("Erreur")
                    .setMessage("Il manque des données, vérifiez les champs et essayez à nouveau.")
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            //on reset les champs.
                            mail.setText("");
                            passwd.setText("");
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        }
    }

}
