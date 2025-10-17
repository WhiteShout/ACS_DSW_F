package baseNoStates.firstmilestone;

import java.time.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Timer;
import java.util.TimerTask;

public class Clock extends Observable {
    long delay;

    public Clock() {
        this.delay = 1000; //10 seconds
    }

    public Clock(long delay, Object observer) {
        this.delay = delay;
        addObserver((DoorUnlockedSh) observer);
        startTimer();
    }

    private void startTimer() {
        Timer timer = new Timer();
        timer.schedule(notify_time(this), delay);
    }

    private TimerTask notify_time(Clock clock) {
        return new TimerTask() {
            @Override
            public void run() {
                notifyObservers();
            }
        };
    }     
}