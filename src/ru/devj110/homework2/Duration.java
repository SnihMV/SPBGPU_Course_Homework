package ru.devj110.homework2;

public class Duration {
    private int hours;
    private int minutes;
    private int seconds;

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        if (hours<0) throw new IllegalArgumentException("Incorrect hours value");
        this.hours = hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        if (minutes<0 || minutes>59) throw new IllegalArgumentException("Incorrect minutes value");
        this.minutes = minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        if (seconds<0 || seconds>59) throw new IllegalArgumentException("Incorrect seconds value");
        this.seconds = seconds;
    }

    public Duration(int hours, int minutes, int seconds) {
        setHours(hours);
        setMinutes(minutes);
        setSeconds(seconds);
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d",hours, minutes, seconds);
    }
}
