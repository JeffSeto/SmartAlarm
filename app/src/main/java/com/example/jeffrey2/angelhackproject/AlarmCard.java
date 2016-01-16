package com.example.jeffrey2.angelhackproject;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;


public class AlarmCard extends RecyclerView.ViewHolder{

    CardView cardView;
    Switch alarmToggle;
    TextView activationTimeView;
    Button alarmButton;
    TextView[] daysView = new TextView[7];
    RelativeLayout layout;
    Alarm alarm;

    public AlarmCard(final View itemView) {
        super(itemView);
        cardView = (CardView) itemView.findViewById(R.id.cardView);
        layout = (RelativeLayout) itemView.findViewById(R.id.cardViewLayout);
        alarmToggle = (Switch) itemView.findViewById(R.id.alarmToggle);
        activationTimeView = (TextView) itemView.findViewById(R.id.activationTimeView);
//        alarmButton = (Button) itemView.findViewById(R.id.alarmButton);
        daysView[0] = (TextView) itemView.findViewById(R.id.sundayView);
        daysView[1] = (TextView) itemView.findViewById(R.id.mondayView);
        daysView[2] = (TextView) itemView.findViewById(R.id.tuesdayView);
        daysView[3] = (TextView) itemView.findViewById(R.id.wednesdayView);
        daysView[4] = (TextView) itemView.findViewById(R.id.thursdayView);
        daysView[5] = (TextView) itemView.findViewById(R.id.fridayView);
        daysView[6] = (TextView) itemView.findViewById(R.id.saturdayView);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(itemView.getContext(),AddAlarmActivity.class);
                itemView.getContext().startActivity(intent);
            }
        });
    }
    public void setAlarm(Alarm alarm){
        this.alarm = alarm;

        setDaysView(alarm.getDays());
        for(int i = 0; i < alarm.getDays().length; i++) {
            final int finalI=i;
            daysView[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    changeDay(finalI);
                }
            });
        }
        setActivationTime(alarm.getTime());
    }
    public void setActivationTime(String time){
        activationTimeView.setText(time);
    }

    public void setDaysView(boolean[] days){
        for(int i = 0; i < days.length; i++){

            if(days[i]){
                daysView[i].setTextColor(Color.parseColor("#ffffff"));
                daysView[i].setBackground(itemView.getContext().getResources().getDrawable(R.drawable.ic_circle_blue));
            } else {
                daysView[i].setTextColor(Color.GRAY);
                daysView[i].setBackground(null);


            }
        }
    }
    public void changeDay(int day){
        alarm.getDays()[day]=!alarm.getDays()[day];
        setDaysView(alarm.getDays());

    }
}
