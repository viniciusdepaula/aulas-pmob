package br.edu.unitri.timepicker;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private TimePicker timePicker;
    private TextView time;
    private Calendar calendar;
    private String format = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timePicker = findViewById(R.id.timePicker);

        calendar = Calendar.getInstance();

        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {

            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                showTime(hourOfDay, minute);
            }
        });

    }

    public void setTime(View view) {

        int hour = timePicker.getHour();
        int min = timePicker.getMinute();
        showTime(hour, min);
    }


    public void showTime(int hour, int min) {

        if (hour == 0) {

            hour += 12;
            format = "AM";

        } else if (hour == 12) {

            format = "PM";

        } else if (hour > 12) {

            hour -= 12;
            format = "PM";

        } else {

            format = "AM";
        }

        Toast.makeText(
                getApplicationContext(),
                new StringBuilder().append(hour).append(" : ").append(min)
                        .append(" ").append(format),
                Toast.LENGTH_SHORT).show();
    }
}