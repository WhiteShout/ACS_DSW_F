package baseNoStates.firstmilestone;
import java.util.Timer;
import java.util.TimerTask;

public class DoorUnlockedSh extends DoorState {

    public DoorUnlockedSh(Door door, String id) {
        super(door, DoorState.UNLOCKED_SHORTLY);

        long delay   = 10000; // 10 seconds
        Timer timer = new Timer();
        timer.schedule(LockAfterDelay(), delay);

    }



    private TimerTask LockAfterDelay() {    
        return new TimerTask() {
            @Override
            public void run() {
                if (getDoor().isClosed()) {
                    getDoor().setState(new DoorLocked(getDoor(), getId()));
                    System.out.println("Door " + getDoor().getId() + " is now locked");
                } else {
                    getDoor().setState(new DoorPropped(getDoor(), getId()));
                    System.out.println("Can't lock door " + getDoor().getId() + " because it's opened or blocked");
                }
            }
        };
    }

    public void open() {
        getDoor().setClosed(false);   
        System.out.println("Door " + getDoor().getId() + " is now opened"); 
    }

    public void close() {
        getDoor().setClosed(true);   
        System.out.println("Door " + getDoor().getId() + " is now closed");
    }

    @Override
    public void unlock() {
        System.out.println("Door " + getDoor().getId() + " is already unlocked shortly");
    }

    @Override
    public void unlockShortly() {
        System.out.println("Door " + getDoor().getId() + " is already unlocked shortly");
    }

    @Override
    public void lock() {
        if (getDoor().isClosed()) {
            getDoor().setState(new DoorLocked(getDoor(), getId()));
            System.out.println("Door " + getDoor().getId() + " is now locked");
        } else {
            System.out.println("Can't lock door " + getDoor().getId() + " because it's opened");
        }
    }

    @Override
    public void prop() {
        System.out.println("Door " + getDoor().getId() + " is unlocked");
    }

    @Override
    public String toString() {
        return DoorState.UNLOCKED_SHORTLY;
    }

}
