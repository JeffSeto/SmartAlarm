package com.example.jeffrey2.angelhackproject;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.melnykov.fab.FloatingActionButton;

import java.util.ArrayList;
import java.util.Calendar;


public class MainActivity extends Activity {
    Intent createAlarmIntent;
    Context context = this;
    AlarmManager alarmManager;
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    public static RVAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Create intent for AddAlarmActivity
        createAlarmIntent = new Intent(this, AddAlarmActivity.class);
        //Get AlarmManager
        alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        recyclerView = (RecyclerView) findViewById(R.id.alarmRecycleView);

        layoutManager = new LinearLayoutManager(context);

        recyclerView.setLayoutManager(layoutManager);

        boolean[] temp = {true,true,true,true,true,true,false};
        Alarm testAlarm = new Alarm(16,20,temp, 1,4,20);
        ArrayList<Alarm> alarmList = new ArrayList();
        alarmList.add(testAlarm);


        adapter = new RVAdapter(alarmList);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.attachToRecyclerView(recyclerView);
        recyclerView.setAdapter(adapter);
        updateAlarms();

    }

    @Override
    public void onResume(){
        super.onResume();
        updateAlarms();
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void addAlarmClicked(View v){
        startActivity(createAlarmIntent);
    }

    private void updateAlarms(){
        ArrayList<Alarm> alarms = adapter.getAlarmList();
        for(int i = 0; i < alarms.size(); i++){
            System.out.println("i value:" + i);
            if(alarms.get(i).getPendingIntent() !=  null){
                alarmManager.cancel(alarms.get(i).getPendingIntent());
            }
            if(alarms.get(i).isActive()){
                long currentTime = Calendar.getInstance().getTimeInMillis();
                boolean[] days = alarms.get(i).getDays();
                int dayValue = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
                Calendar alarmTime = Calendar.getInstance();
                int year = alarmTime.get(Calendar.YEAR);
                int month = alarmTime.get(Calendar.MONTH);
                int day = alarmTime.get(Calendar.DAY_OF_MONTH);
                int hour = alarms.get(i).getDepartureHour();
                int minute = alarms.get(i).getDepartureMinute();
                long difference = 0;
                for(int j = 0; j < 7; j++){
                    alarmTime.set(year, month, day, hour, minute,0);
                    if(days[(dayValue-1+j)%7]){
                        if((difference = alarmTime.getTimeInMillis() - currentTime) > 0){
                            System.out.println("j value: " + j);
                            System.out.println("Current time: " + currentTime);
                            System.out.println(alarmTime.getTimeInMillis());
                            j = 7;
                        }
                    }
                    day++;
                }
                System.out.println("Difference: " + difference);
                Intent tempIntent = new Intent(this, AlarmReceiver.class);
                alarms.get(i).setPendingIntent(PendingIntent.getBroadcast(this,0,tempIntent,PendingIntent.FLAG_ONE_SHOT));
                alarmManager.set(AlarmManager.RTC_WAKEUP, currentTime + difference, alarms.get(i).getPendingIntent());
            }
        }
    }
}
