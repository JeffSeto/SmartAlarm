package com.example.jeffrey2.angelhackproject;

import android.app.PendingIntent;

/**
 * Created by Jeffrey 2 on 13/06/2015.
 */
public class Alarm {
    int hour, minute;
    int departureHour, departureMinute;
    boolean[] days;
    long travelTime;
    boolean active;
    PendingIntent pendingIntent = null;
    public Alarm(int hour, int minute, boolean[] days, long travelTime, int departureHour, int departureMinute){
        this.hour = hour;
        this.minute = minute;
        this.days = days;
        this.travelTime = travelTime;
        active = true;
        this.departureHour = departureHour;
        this.departureMinute = departureMinute;
    }

    public int getHour(){
        return hour;
    }

    public int getMinute(){
        return minute;
    }

    public boolean[] getDays(){
        return days;
    }

    public int getDepartureHour() { return departureHour;}

    public int getDepartureMinute() { return departureMinute;}

    public void setMinute(int minute){
        this.minute = minute;
    }

    public void setHour(int hour){
        this.hour = hour;
    }

    public void setDays(boolean[] days){
        this.days = days;
    }
    public String getTime(){
        return hour + ":" + minute;
    }

    public long getTravelTime(){
        return travelTime;
    }

    public void setTravelTime(long travelTime){
        this.travelTime = travelTime;
    }

    public boolean isActive(){
        return active;
    }

    public void setActive(boolean active){
        this.active = active;
    }

    public PendingIntent getPendingIntent(){
        return pendingIntent;
    }

    public void setPendingIntent(PendingIntent pendingIntent){
        this.pendingIntent = pendingIntent;
    }
}
