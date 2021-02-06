package ua.kpi.comsys.io8312.playground;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TimeVI {
    private int hours;
    private int minutes;
    private int seconds;

    public TimeVI() {
        hours = 0;
        minutes = 0;
        seconds = 0;
    }

    public TimeVI(TimeVI time){
        this.hours = time.hours;
        this. minutes = time.minutes;
        this.seconds = time.seconds;
    }

    public TimeVI(int h, int m, int s) {
        if(h >= 0 && h < 24 && m >= 0 && m <= 60 && s >= 0 && s < 60) {
            this.hours = h;
            this.minutes = m;
            this.seconds = s;
        }
    }

    public TimeVI(Date date){
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        hours = calendar.get(Calendar.HOUR_OF_DAY);
        minutes = calendar.get(Calendar.MINUTE);
        seconds = calendar.get(Calendar.SECOND);
    }

    @Override
    public String toString() {
        return ((hours >= 12)?(hours - 12 + ""):(hours)) + ":"
                + minutes + ":"
                + seconds +
                (hours >= 12?" RM":" AM");
    }

    public TimeVI subTime(TimeVI time1, TimeVI time2){
        int h = time1.hours - time2.hours;
        int m = time1.minutes - time2.minutes;
        int s = time1.seconds - time2.seconds;

        while(s < 0){
            m -= 1;
            s += 60;
        }
        while(m < 0){
            h -= 1;
            m += 60;
        }
        while(h < 0){
            h += 24;
        }
        return new TimeVI(h, m, s);
    }

    public TimeVI addTime(TimeVI time1, TimeVI time2){
        int h = time1.hours + time2.hours;
        int m = time1.minutes + time2.minutes;
        int s = time1.seconds + time2.seconds;

        while(s > 59){
            m += 1;
            s -= 60;
        }
        while(m > 59){
            h += 1;
            m -= 60;
        }
        while(h > 23){
            h -= 24;
        }
        return new TimeVI(h, m, s);
    }

    public TimeVI subTime(TimeVI time){
        return subTime(this, time);
    }

    public TimeVI addTime(TimeVI time){
        return addTime(this, time);
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        if(hours >= 0 && hours < 24)
        this.hours = hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        if(minutes >= 0 && minutes < 60) {
            this.minutes = minutes;
        }
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        if(seconds >= 0 && seconds < 60)
        this.seconds = seconds;
    }
}
