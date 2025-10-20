package baseNoStates.firstmilestone;

import java.time.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Timer;
import java.util.TimerTask;

/*
 * Classe que implementa un rellotge que notifica als observadors cada cert temps.
 * Observable y Observer son viables pero estan deprecated en les versions recents de Java.
 * Per a versions futures es recomana utilitzar les classes de java.util.concurrent.Flow
 * per implementar el patró Observer.
 */
public class Clock extends Observable {
    long delay;

    public Clock() {
        this.delay = 10000; //10 segons
    }

    public Clock(long delay, Object observer) {
        this.delay = delay;
        addObserver((DoorUnlockedSh) observer);
        startTimer();
    }

    private void startTimer() {
        //System.out.println("/--------------/ \n Timer Start \n /--------------/");
        Timer timer = new Timer();
        timer.schedule(notify_time(this), delay);
    }

    private TimerTask notify_time(Clock clock) {
        return new TimerTask() {
            @Override
            public void run() {
                //System.out.println("/--------------/ \n Timer Done \n /--------------/");
                setChanged();
                notifyObservers();
            }
        };
    }     
}