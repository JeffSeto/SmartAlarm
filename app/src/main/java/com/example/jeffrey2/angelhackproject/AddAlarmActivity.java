package com.example.jeffrey2.angelhackproject;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;


public class AddAlarmActivity extends Activity {

    boolean[] days = new boolean[7];
    TimePicker timePicker;
    Button[] dayButtons = new Button[7];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_alarm);
        timePicker = (TimePicker) findViewById(R.id.timePicker);

        dayButtons[0] = (Button) findViewById(R.id.sundayButton);
        dayButtons[1] = (Button) findViewById(R.id.mondayButton);
        dayButtons[2] = (Button) findViewById(R.id.tuesdayButton);
        dayButtons[3] = (Button) findViewById(R.id.wednesdayButton);
        dayButtons[4] = (Button) findViewById(R.id.thursdayButton);
        dayButtons[5] = (Button) findViewById(R.id.fridayButton);
        dayButtons[6] = (Button) findViewById(R.id.saturdayButton);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_alarm, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void sundayClicked(View v){
        days[0] = !days[0];
        if(days[0]){
            dayButtons[0].setTextColor(Color.parseColor("#84beff"));
        } else {
            dayButtons[0].setTextColor(Color.BLACK);
        }
    }
    public void mondayClicked(View v){
        days[1] = !days[1];
        if(days[1]){
            dayButtons[1].setTextColor(Color.parseColor("#84beff"));
        } else {
            dayButtons[1].setTextColor(Color.BLACK);
        }
    }
    public void tuesdayClicked(View v){
        days[2] = !days[2];
        if(days[2]){
            dayButtons[2].setTextColor(Color.parseColor("#84beff"));
        } else {
            dayButtons[2].setTextColor(Color.BLACK);
        }
    }
    public void wednesdayClicked(View v){
        days[3] = !days[3];
        if(days[3]){
            dayButtons[3].setTextColor(Color.parseColor("#84beff"));
        } else {
            dayButtons[3].setTextColor(Color.BLACK);
        }
    }
    public void thursdayClicked(View v){
        days[4] = !days[4];
        if(days[4]){
            dayButtons[4].setTextColor(Color.parseColor("#84beff"));
        } else {
            dayButtons[4].setTextColor(Color.BLACK);
        }
    }
    public void fridayClicked(View v){
        days[5] = !days[5];
        if(days[5]){
            dayButtons[5].setTextColor(Color.parseColor("#84beff"));
        } else {
            dayButtons[5].setTextColor(Color.BLACK);
        }
    }
    public void saturdayClicked(View v){
        days[6] = !days[6];
        if(days[6]){
            dayButtons[6].setTextColor(Color.parseColor("#84beff"));
            //daysView[i].setPaintFlags(daysView[i].getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        } else {
            dayButtons[6].setTextColor(Color.BLACK);
        }
    }

    public void createAlarmClicked(View v){
        Alarm alarm = new Alarm(timePicker.getCurrentHour(), timePicker.getCurrentMinute(), days, 0);
        MainActivity.adapter.addAlarm(alarm);
        onBackPressed();
    }
}
