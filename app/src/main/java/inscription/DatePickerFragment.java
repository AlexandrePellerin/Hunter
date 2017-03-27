package inscription;

/**
 * Created by hourdeaa on 24/03/17.
 */

import android.app.Dialog;


import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;
import java.util.Calendar;

public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {
    int pYear;
    int pDay;
    int pMonth;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current date as the default date in the picker
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of DatePickerDialog and return it
        return new DatePickerDialog(getActivity()/*, AlertDialog.THEME_HOLO_DARK*/, this, year, month, day);

    }

    public void onDateSet(DatePicker view, int year, int month, int day) {
        pYear = year;
        pDay = day;
        pMonth = month;
    }
}
