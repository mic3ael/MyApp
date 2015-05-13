package com.example.michael.myapplication;


import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by michael on 5/10/15.
 */
public class Settings_Event extends ActionBarActivity
{

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_event);

        final TextView start_date = (TextView) findViewById(R.id.Tdate_start);
        final Button start_button = (Button) findViewById(R.id.EventstartB);
        final TextView start_time = (TextView) findViewById(R.id.Ttime_start);

        start_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear,
                                          int dayOfMonth) {
                        Calendar cal = Calendar.getInstance();
                        cal.set(year, monthOfYear, dayOfMonth);
                        start_date.setText(formatDate(cal.getTime()));
                    }
                };
                Calendar c = Calendar.getInstance();
                DatePickerDialog dateD =   new DatePickerDialog(Settings_Event.this, onDateSetListener, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));
                dateD.show();

              final TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {

                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay,
                                              int minute) {
                            start_time.setText(String.format("%1s:%2s", hourOfDay, minute));

                        }
                    };
                    c = Calendar.getInstance();
                    new TimePickerDialog(Settings_Event.this, onTimeSetListener, c.get(Calendar.HOUR), c.get(Calendar.MINUTE), true).show();
                }


        });

        final TextView end_date = (TextView) findViewById(R.id.Tdate_end);
        final Button end_button = (Button) findViewById(R.id.EventendB);
        final TextView end_time = (TextView) findViewById(R.id.Ttime_end);
        end_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                final DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear,
                                          int dayOfMonth) {
                        Calendar cal = Calendar.getInstance();
                        cal.set(year, monthOfYear, dayOfMonth);
                        end_date.setText(formatDate(cal.getTime()));
                    }
                };
                Calendar c = Calendar.getInstance();
                DatePickerDialog dateD =   new DatePickerDialog(Settings_Event.this, onDateSetListener, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));
                dateD.show();



                final TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay,
                                          int minute) {
                        end_time.setText(String.format("%1s:%2s", hourOfDay, minute));

                    }
                };
                c = Calendar.getInstance();
                new TimePickerDialog(Settings_Event.this, onTimeSetListener, c.get(Calendar.HOUR), c.get(Calendar.MINUTE), true).show();
            }
        });

    }

    private String formatDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
