package connexion;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import inscription.Client_Inscription;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.diazr.hunter.Map_Client;
import com.example.diazr.hunter.R;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by regnierk on 22/03/17.
 */

public class Connexion_Client extends Activity {
    TextView champMail;
    RequestQueue queue;
    JsonObjectRequest json;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.connexion_client);

        champMail = (TextView) findViewById(R.id.mail);

        Map<String, String> jsonParams = new HashMap<String, String>();
        jsonParams.put("name", "pelleria");

        queue = Volley.newRequestQueue(this);
        String url = "http://10.0.2.2:8080/v1/user";
        json = new JsonObjectRequest(Request.Method.POST, url,new JSONObject(jsonParams),
                new Response.Listener<JSONObject>(){
                    @Override
                    public void onResponse(JSONObject response){
                        champMail.setText("Rep: " + response);
                    }
                }, new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error){
                        champMail.setText("That didn't work!");
                        Log.d("abd", "Error: " + error
                                + ">>" + error.networkResponse.statusCode
                                + ">>" + error.networkResponse.data
                                + ">>" + error.getCause()
                                + ">>" + error.getMessage());
                        
                        //Redirection vers la page de carte
                        Intent intent = new Intent (Connexion_Client.this, Map_Client.class);
                        startActivity(intent);
                    }
        });
    }

    public void redirigeInscrCli(View view) {
        Intent intent = new Intent(Connexion_Client.this, Client_Inscription.class);
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
            queue.add(json);
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
