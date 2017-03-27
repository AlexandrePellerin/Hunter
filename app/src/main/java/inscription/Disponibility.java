package inscription;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.example.diazr.hunter.R;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import static com.example.diazr.hunter.R.id.checkBox_Lundi_00H_01H;

/**
 * Created by boreec on 23/03/17.
 */

public class Disponibility extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.disponibility);
        final Button buttonValider = (Button)findViewById(R.id.button_valider);
        buttonValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = getTimeTableString();
                Intent intent = new Intent();
                intent.putExtra("HORAIRES",message);
                setResult(2,intent);
                finish(); //finishing activity
            }
        });
    }

    /*
    * Retourne l'emploi du temps sous la forme textuelle.
    * @return null si aucune case n'est cochée.
    * */
    private String getTimeTableString() {
        final CheckBox[] checkBoxDimanche = new CheckBox[24];
        final CheckBox[] checkBoxLundi = new CheckBox[24];
        final CheckBox[] checkBoxMardi = new CheckBox[24];
        final CheckBox[] checkBoxMercredi = new CheckBox[24];
        final CheckBox[] checkBoxJeudi = new CheckBox[24];
        final CheckBox[] checkBoxVendredi = new CheckBox[24];
        final CheckBox[] checkBoxSamedi = new CheckBox[24];
        //Dimanche
        checkBoxDimanche[0] = (CheckBox)findViewById(R.id.checkBox_Dimanche_00H_01H);
        checkBoxDimanche[1] = (CheckBox)findViewById(R.id.checkBox_Dimanche_01H_02H);
        checkBoxDimanche[2] = (CheckBox)findViewById(R.id.checkBox_Dimanche_02H_03H);
        checkBoxDimanche[3] = (CheckBox)findViewById(R.id.checkBox_Dimanche_03H_04H);
        checkBoxDimanche[4] = (CheckBox)findViewById(R.id.checkBox_Dimanche_04H_05H);
        checkBoxDimanche[5] = (CheckBox)findViewById(R.id.checkBox_Dimanche_05H_06H);
        checkBoxDimanche[6] = (CheckBox)findViewById(R.id.checkBox_Dimanche_06H_07H);
        checkBoxDimanche[7] = (CheckBox)findViewById(R.id.checkBox_Dimanche_07H_08H);
        checkBoxDimanche[8] = (CheckBox)findViewById(R.id.checkBox_Dimanche_08H_09H);
        checkBoxDimanche[9] = (CheckBox)findViewById(R.id.checkBox_Dimanche_09H_10H);
        checkBoxDimanche[10] = (CheckBox)findViewById(R.id.checkBox_Dimanche_10H_11H);
        checkBoxDimanche[11] = (CheckBox)findViewById(R.id.checkBox_Dimanche_11H_12H);
        checkBoxDimanche[12] = (CheckBox)findViewById(R.id.checkBox_Dimanche_12H_13H);
        checkBoxDimanche[13] = (CheckBox)findViewById(R.id.checkBox_Dimanche_13H_14H);
        checkBoxDimanche[14] = (CheckBox)findViewById(R.id.checkBox_Dimanche_14H_15H);
        checkBoxDimanche[15] = (CheckBox)findViewById(R.id.checkBox_Dimanche_15H_16H);
        checkBoxDimanche[16] = (CheckBox)findViewById(R.id.checkBox_Dimanche_16H_17H);
        checkBoxDimanche[17] = (CheckBox)findViewById(R.id.checkBox_Dimanche_17H_18H);
        checkBoxDimanche[18] = (CheckBox)findViewById(R.id.checkBox_Dimanche_18H_19H);
        checkBoxDimanche[19] = (CheckBox)findViewById(R.id.checkBox_Dimanche_19H_20H);
        checkBoxDimanche[20] = (CheckBox)findViewById(R.id.checkBox_Dimanche_20H_21H);
        checkBoxDimanche[21] = (CheckBox)findViewById(R.id.checkBox_Dimanche_21H_22H);
        checkBoxDimanche[22] = (CheckBox)findViewById(R.id.checkBox_Dimanche_22H_23H);
        checkBoxDimanche[23] = (CheckBox)findViewById(R.id.checkBox_Dimanche_23H_00H);
        //Lundi
        checkBoxLundi[0] = (CheckBox)findViewById(R.id.checkBox_Lundi_00H_01H);
        checkBoxLundi[1] = (CheckBox)findViewById(R.id.checkBox_Lundi_01H_02H);
        checkBoxLundi[2] = (CheckBox)findViewById(R.id.checkBox_Lundi_02H_03H);
        checkBoxLundi[3] = (CheckBox)findViewById(R.id.checkBox_Lundi_03H_04H);
        checkBoxLundi[4] = (CheckBox)findViewById(R.id.checkBox_Lundi_04H_05H);
        checkBoxLundi[5] = (CheckBox)findViewById(R.id.checkBox_Lundi_05H_06H);
        checkBoxLundi[6] = (CheckBox)findViewById(R.id.checkBox_Lundi_06H_07H);
        checkBoxLundi[7] = (CheckBox)findViewById(R.id.checkBox_Lundi_07H_08H);
        checkBoxLundi[8] = (CheckBox)findViewById(R.id.checkBox_Lundi_08H_09H);
        checkBoxLundi[9] = (CheckBox)findViewById(R.id.checkBox_Lundi_09H_10H);
        checkBoxLundi[10] = (CheckBox)findViewById(R.id.checkBox_Lundi_10H_11H);
        checkBoxLundi[11] = (CheckBox)findViewById(R.id.checkBox_Lundi_11H_12H);
        checkBoxLundi[12] = (CheckBox)findViewById(R.id.checkBox_Lundi_12H_13H);
        checkBoxLundi[13] = (CheckBox)findViewById(R.id.checkBox_Lundi_13H_14H);
        checkBoxLundi[14] = (CheckBox)findViewById(R.id.checkBox_Lundi_14H_15H);
        checkBoxLundi[15] = (CheckBox)findViewById(R.id.checkBox_Lundi_15H_16H);
        checkBoxLundi[16] = (CheckBox)findViewById(R.id.checkBox_Lundi_16H_17H);
        checkBoxLundi[17] = (CheckBox)findViewById(R.id.checkBox_Lundi_17H_18H);
        checkBoxLundi[18] = (CheckBox)findViewById(R.id.checkBox_Lundi_18H_19H);
        checkBoxLundi[19] = (CheckBox)findViewById(R.id.checkBox_Lundi_19H_20H);
        checkBoxLundi[20] = (CheckBox)findViewById(R.id.checkBox_Lundi_20H_21H);
        checkBoxLundi[21] = (CheckBox)findViewById(R.id.checkBox_Lundi_21H_22H);
        checkBoxLundi[22] = (CheckBox)findViewById(R.id.checkBox_Lundi_22H_23H);
        checkBoxLundi[23] = (CheckBox)findViewById(R.id.checkBox_Lundi_23H_00H);
        //Mardi
        checkBoxMardi[0] = (CheckBox)findViewById(R.id.checkBox_Mardi_00H_01H);
        checkBoxMardi[1] = (CheckBox)findViewById(R.id.checkBox_Mardi_01H_02H);
        checkBoxMardi[2] = (CheckBox)findViewById(R.id.checkBox_Mardi_02H_03H);
        checkBoxMardi[3] = (CheckBox)findViewById(R.id.checkBox_Mardi_03H_04H);
        checkBoxMardi[4] = (CheckBox)findViewById(R.id.checkBox_Mardi_04H_05H);
        checkBoxMardi[5] = (CheckBox)findViewById(R.id.checkBox_Mardi_05H_06H);
        checkBoxMardi[6] = (CheckBox)findViewById(R.id.checkBox_Mardi_06H_07H);
        checkBoxMardi[7] = (CheckBox)findViewById(R.id.checkBox_Mardi_07H_08H);
        checkBoxMardi[8] = (CheckBox)findViewById(R.id.checkBox_Mardi_08H_09H);
        checkBoxMardi[9] = (CheckBox)findViewById(R.id.checkBox_Mardi_09H_10H);
        checkBoxMardi[10] = (CheckBox)findViewById(R.id.checkBox_Mardi_10H_11H);
        checkBoxMardi[11] = (CheckBox)findViewById(R.id.checkBox_Mardi_11H_12H);
        checkBoxMardi[12] = (CheckBox)findViewById(R.id.checkBox_Mardi_12H_13H);
        checkBoxMardi[13] = (CheckBox)findViewById(R.id.checkBox_Mardi_13H_14H);
        checkBoxMardi[14] = (CheckBox)findViewById(R.id.checkBox_Mardi_14H_15H);
        checkBoxMardi[15] = (CheckBox)findViewById(R.id.checkBox_Mardi_15H_16H);
        checkBoxMardi[16] = (CheckBox)findViewById(R.id.checkBox_Mardi_16H_17H);
        checkBoxMardi[17] = (CheckBox)findViewById(R.id.checkBox_Mardi_17H_18H);
        checkBoxMardi[18] = (CheckBox)findViewById(R.id.checkBox_Mardi_18H_19H);
        checkBoxMardi[19] = (CheckBox)findViewById(R.id.checkBox_Mardi_19H_20H);
        checkBoxMardi[20] = (CheckBox)findViewById(R.id.checkBox_Mardi_20H_21H);
        checkBoxMardi[21] = (CheckBox)findViewById(R.id.checkBox_Mardi_21H_22H);
        checkBoxMardi[22] = (CheckBox)findViewById(R.id.checkBox_Mardi_22H_23H);
        checkBoxMardi[23] = (CheckBox)findViewById(R.id.checkBox_Mardi_23H_00H);
        //Mercredi
        checkBoxMercredi[0] = (CheckBox)findViewById(R.id.checkBox_Mercredi_00H_01H);
        checkBoxMercredi[1] = (CheckBox)findViewById(R.id.checkBox_Mercredi_01H_02H);
        checkBoxMercredi[2] = (CheckBox)findViewById(R.id.checkBox_Mercredi_02H_03H);
        checkBoxMercredi[3] = (CheckBox)findViewById(R.id.checkBox_Mercredi_03H_04H);
        checkBoxMercredi[4] = (CheckBox)findViewById(R.id.checkBox_Mercredi_04H_05H);
        checkBoxMercredi[5] = (CheckBox)findViewById(R.id.checkBox_Mercredi_05H_06H);
        checkBoxMercredi[6] = (CheckBox)findViewById(R.id.checkBox_Mercredi_06H_07H);
        checkBoxMercredi[7] = (CheckBox)findViewById(R.id.checkBox_Mercredi_07H_08H);
        checkBoxMercredi[8] = (CheckBox)findViewById(R.id.checkBox_Mercredi_08H_09H);
        checkBoxMercredi[9] = (CheckBox)findViewById(R.id.checkBox_Mercredi_09H_10H);
        checkBoxMercredi[10] = (CheckBox)findViewById(R.id.checkBox_Mercredi_10H_11H);
        checkBoxMercredi[11] = (CheckBox)findViewById(R.id.checkBox_Mercredi_11H_12H);
        checkBoxMercredi[12] = (CheckBox)findViewById(R.id.checkBox_Mercredi_12H_13H);
        checkBoxMercredi[13] = (CheckBox)findViewById(R.id.checkBox_Mercredi_13H_14H);
        checkBoxMercredi[14] = (CheckBox)findViewById(R.id.checkBox_Mercredi_14H_15H);
        checkBoxMercredi[15] = (CheckBox)findViewById(R.id.checkBox_Mercredi_15H_16H);
        checkBoxMercredi[16] = (CheckBox)findViewById(R.id.checkBox_Mercredi_16H_17H);
        checkBoxMercredi[17] = (CheckBox)findViewById(R.id.checkBox_Mercredi_17H_18H);
        checkBoxMercredi[18] = (CheckBox)findViewById(R.id.checkBox_Mercredi_18H_19H);
        checkBoxMercredi[19] = (CheckBox)findViewById(R.id.checkBox_Mercredi_19H_20H);
        checkBoxMercredi[20] = (CheckBox)findViewById(R.id.checkBox_Mercredi_20H_21H);
        checkBoxMercredi[21] = (CheckBox)findViewById(R.id.checkBox_Mercredi_21H_22H);
        checkBoxMercredi[22] = (CheckBox)findViewById(R.id.checkBox_Mercredi_22H_23H);
        checkBoxMercredi[23] = (CheckBox)findViewById(R.id.checkBox_Mercredi_23H_00H);
        //Jeudi
        checkBoxJeudi[0] = (CheckBox)findViewById(R.id.checkBox_Jeudi_00H_01H);
        checkBoxJeudi[1] = (CheckBox)findViewById(R.id.checkBox_Jeudi_01H_02H);
        checkBoxJeudi[2] = (CheckBox)findViewById(R.id.checkBox_Jeudi_02H_03H);
        checkBoxJeudi[3] = (CheckBox)findViewById(R.id.checkBox_Jeudi_03H_04H);
        checkBoxJeudi[4] = (CheckBox)findViewById(R.id.checkBox_Jeudi_04H_05H);
        checkBoxJeudi[5] = (CheckBox)findViewById(R.id.checkBox_Jeudi_05H_06H);
        checkBoxJeudi[6] = (CheckBox)findViewById(R.id.checkBox_Jeudi_06H_07H);
        checkBoxJeudi[7] = (CheckBox)findViewById(R.id.checkBox_Jeudi_07H_08H);
        checkBoxJeudi[8] = (CheckBox)findViewById(R.id.checkBox_Jeudi_08H_09H);
        checkBoxJeudi[9] = (CheckBox)findViewById(R.id.checkBox_Jeudi_09H_10H);
        checkBoxJeudi[10] = (CheckBox)findViewById(R.id.checkBox_Jeudi_10H_11H);
        checkBoxJeudi[11] = (CheckBox)findViewById(R.id.checkBox_Jeudi_11H_12H);
        checkBoxJeudi[12] = (CheckBox)findViewById(R.id.checkBox_Jeudi_12H_13H);
        checkBoxJeudi[13] = (CheckBox)findViewById(R.id.checkBox_Jeudi_13H_14H);
        checkBoxJeudi[14] = (CheckBox)findViewById(R.id.checkBox_Jeudi_14H_15H);
        checkBoxJeudi[15] = (CheckBox)findViewById(R.id.checkBox_Jeudi_15H_16H);
        checkBoxJeudi[16] = (CheckBox)findViewById(R.id.checkBox_Jeudi_16H_17H);
        checkBoxJeudi[17] = (CheckBox)findViewById(R.id.checkBox_Jeudi_17H_18H);
        checkBoxJeudi[18] = (CheckBox)findViewById(R.id.checkBox_Jeudi_18H_19H);
        checkBoxJeudi[19] = (CheckBox)findViewById(R.id.checkBox_Jeudi_19H_20H);
        checkBoxJeudi[20] = (CheckBox)findViewById(R.id.checkBox_Jeudi_20H_21H);
        checkBoxJeudi[21] = (CheckBox)findViewById(R.id.checkBox_Jeudi_21H_22H);
        checkBoxJeudi[22] = (CheckBox)findViewById(R.id.checkBox_Jeudi_22H_23H);
        checkBoxJeudi[23] = (CheckBox)findViewById(R.id.checkBox_Jeudi_23H_00H);
        //Vendredi
        checkBoxVendredi[0] = (CheckBox)findViewById(R.id.checkBox_Vendredi_00H_01H);
        checkBoxVendredi[1] = (CheckBox)findViewById(R.id.checkBox_Vendredi_01H_02H);
        checkBoxVendredi[2] = (CheckBox)findViewById(R.id.checkBox_Vendredi_02H_03H);
        checkBoxVendredi[3] = (CheckBox)findViewById(R.id.checkBox_Vendredi_03H_04H);
        checkBoxVendredi[4] = (CheckBox)findViewById(R.id.checkBox_Vendredi_04H_05H);
        checkBoxVendredi[5] = (CheckBox)findViewById(R.id.checkBox_Vendredi_05H_06H);
        checkBoxVendredi[6] = (CheckBox)findViewById(R.id.checkBox_Vendredi_06H_07H);
        checkBoxVendredi[7] = (CheckBox)findViewById(R.id.checkBox_Vendredi_07H_08H);
        checkBoxVendredi[8] = (CheckBox)findViewById(R.id.checkBox_Vendredi_08H_09H);
        checkBoxVendredi[9] = (CheckBox)findViewById(R.id.checkBox_Vendredi_09H_10H);
        checkBoxVendredi[10] = (CheckBox)findViewById(R.id.checkBox_Vendredi_10H_11H);
        checkBoxVendredi[11] = (CheckBox)findViewById(R.id.checkBox_Vendredi_11H_12H);
        checkBoxVendredi[12] = (CheckBox)findViewById(R.id.checkBox_Vendredi_12H_13H);
        checkBoxVendredi[13] = (CheckBox)findViewById(R.id.checkBox_Vendredi_13H_14H);
        checkBoxVendredi[14] = (CheckBox)findViewById(R.id.checkBox_Vendredi_14H_15H);
        checkBoxVendredi[15] = (CheckBox)findViewById(R.id.checkBox_Vendredi_15H_16H);
        checkBoxVendredi[16] = (CheckBox)findViewById(R.id.checkBox_Vendredi_16H_17H);
        checkBoxVendredi[17] = (CheckBox)findViewById(R.id.checkBox_Vendredi_17H_18H);
        checkBoxVendredi[18] = (CheckBox)findViewById(R.id.checkBox_Vendredi_18H_19H);
        checkBoxVendredi[19] = (CheckBox)findViewById(R.id.checkBox_Vendredi_19H_20H);
        checkBoxVendredi[20] = (CheckBox)findViewById(R.id.checkBox_Vendredi_20H_21H);
        checkBoxVendredi[21] = (CheckBox)findViewById(R.id.checkBox_Vendredi_21H_22H);
        checkBoxVendredi[22] = (CheckBox)findViewById(R.id.checkBox_Vendredi_22H_23H);
        checkBoxVendredi[23] = (CheckBox)findViewById(R.id.checkBox_Vendredi_23H_00H);
        //Samedi
        checkBoxSamedi[0] = (CheckBox)findViewById(R.id.checkBox_Samedi_00H_01H);
        checkBoxSamedi[1] = (CheckBox)findViewById(R.id.checkBox_Samedi_01H_02H);
        checkBoxSamedi[2] = (CheckBox)findViewById(R.id.checkBox_Samedi_02H_03H);
        checkBoxSamedi[3] = (CheckBox)findViewById(R.id.checkBox_Samedi_03H_04H);
        checkBoxSamedi[4] = (CheckBox)findViewById(R.id.checkBox_Samedi_04H_05H);
        checkBoxSamedi[5] = (CheckBox)findViewById(R.id.checkBox_Samedi_05H_06H);
        checkBoxSamedi[6] = (CheckBox)findViewById(R.id.checkBox_Samedi_06H_07H);
        checkBoxSamedi[7] = (CheckBox)findViewById(R.id.checkBox_Samedi_07H_08H);
        checkBoxSamedi[8] = (CheckBox)findViewById(R.id.checkBox_Samedi_08H_09H);
        checkBoxSamedi[9] = (CheckBox)findViewById(R.id.checkBox_Samedi_09H_10H);
        checkBoxSamedi[10] = (CheckBox)findViewById(R.id.checkBox_Samedi_10H_11H);
        checkBoxSamedi[11] = (CheckBox)findViewById(R.id.checkBox_Samedi_11H_12H);
        checkBoxSamedi[12] = (CheckBox)findViewById(R.id.checkBox_Samedi_12H_13H);
        checkBoxSamedi[13] = (CheckBox)findViewById(R.id.checkBox_Samedi_13H_14H);
        checkBoxSamedi[14] = (CheckBox)findViewById(R.id.checkBox_Samedi_14H_15H);
        checkBoxSamedi[15] = (CheckBox)findViewById(R.id.checkBox_Samedi_15H_16H);
        checkBoxSamedi[16] = (CheckBox)findViewById(R.id.checkBox_Samedi_16H_17H);
        checkBoxSamedi[17] = (CheckBox)findViewById(R.id.checkBox_Samedi_17H_18H);
        checkBoxSamedi[18] = (CheckBox)findViewById(R.id.checkBox_Samedi_18H_19H);
        checkBoxSamedi[19] = (CheckBox)findViewById(R.id.checkBox_Samedi_19H_20H);
        checkBoxSamedi[20] = (CheckBox)findViewById(R.id.checkBox_Samedi_20H_21H);
        checkBoxSamedi[21] = (CheckBox)findViewById(R.id.checkBox_Samedi_21H_22H);
        checkBoxSamedi[22] = (CheckBox)findViewById(R.id.checkBox_Samedi_22H_23H);
        checkBoxSamedi[23] = (CheckBox)findViewById(R.id.checkBox_Samedi_23H_00H);

        String result = "";
        for(int i = 0;i < checkBoxDimanche.length;i++){
            if(checkBoxDimanche[i].isChecked()){
                result += "Dim" + i;
            }
        }
        result += "\n";
        for(int i = 0;i < checkBoxLundi.length;i++){
            if(checkBoxLundi[i].isChecked()){
                result += "Lun" + i;
            }
        }
        result += "\n";
        for(int i = 0;i < checkBoxMardi.length;i++){
            if(checkBoxMardi[i].isChecked()){
                result += "Mar" + i;
            }
        }
        result += "\n";
        for(int i = 0;i < checkBoxMercredi.length;i++){
            if(checkBoxMercredi[i].isChecked()){
                result += "Mer" + i;
            }
        }
        result += "\n";
        for(int i = 0;i < checkBoxJeudi.length;i++){
            if(checkBoxJeudi[i].isChecked()){
                result += "Jeu" + i;
            }
        }
        result += "\n";
        for(int i = 0;i < checkBoxVendredi.length;i++){
            if(checkBoxVendredi[i].isChecked()){
                result += "Ven" + i;
            }
        }
        result += "\n";
        for(int i = 0;i < checkBoxSamedi.length;i++){
            if(checkBoxSamedi[i].isChecked()){
                result += "Sam" + i;
            }
        }
        if(isEmpty(checkBoxDimanche) && isEmpty(checkBoxLundi) && isEmpty(checkBoxMardi)
        && isEmpty(checkBoxMercredi) && isEmpty(checkBoxJeudi) && isEmpty(checkBoxVendredi)
        && isEmpty(checkBoxSamedi)){
            return null;
        }
        return result;
    }

    /*
    * Regarde si toutes les checkboxs d'un jour sont vides et renvoit true si c'est le cas.
    * */
    private boolean isEmpty(CheckBox[] checkBoxJour) {
        int i = 0;
        while(!checkBoxJour[i].isChecked() && i < checkBoxJour.length -1){
            i++;
        }
        return (i >= checkBoxJour.length);
    }
}
