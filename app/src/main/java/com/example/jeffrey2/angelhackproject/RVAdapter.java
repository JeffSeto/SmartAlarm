package com.example.jeffrey2.angelhackproject;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Jeffrey 2 on 13/06/2015.
 */
public class RVAdapter extends RecyclerView.Adapter{

    ArrayList<Alarm> alarms;


    public RVAdapter(ArrayList<Alarm> alarms){
        this.alarms = (ArrayList<Alarm>) alarms.clone();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.alarm_card_view, viewGroup, false);
        AlarmCard card = new AlarmCard(v);

        return card;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        AlarmCard card = (AlarmCard) viewHolder;
        card.setAlarm(alarms.get(i));

    }

    @Override
    public int getItemCount() {
        return alarms.size();
    }

    public void addAlarm(Alarm alarm){
        alarms.add(alarm);
        notifyDataSetChanged();
    }

    public void removeAlarm(int position){
        alarms.remove(position);
        notifyDataSetChanged();
    }

    public void forceUpdate(){
        notifyDataSetChanged();
    }

    public ArrayList<Alarm> getAlarmList(){
        return alarms;
    }
}
