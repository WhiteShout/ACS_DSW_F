package baseNoStates.firstmilestone;
import java.util.Timer;
import java.util.Observer;
import java.util.TimerTask;

public class DoorUnlockedSh extends DoorState implements Observer {

    public DoorUnlockedSh(Door door, long ms) {
        super(door, DoorState.UNLOCKED_SHORTLY);
        Clock clock = new Clock((long) ms, this); 

    }

    @Override
    public void update(java.util.Observable observable, Object arg) {
        //System.out.println("/--------------/ \n Update form observable \n /--------------/");
        if (door.isClosed()) {
            door.setState(new DoorLocked(door, getId()));
            System.out.println("Door " + door.getId() + " is now locked");
        } else {
            door.setState(new DoorPropped(door, getId()));
            System.out.println("Can't lock door " + door.getId() + " because it's opened or blocked");
        }
    }

    public void open() {
        door.setClosed(false);   
        System.out.println("Door " + door.getId() + " is now open"); 
    }

    public void close() {
        door.setClosed(true);   
        System.out.println("Door " + door.getId() + " is now closed");
    }

    @Override
    public void unlock() {
        System.out.println("Door " + door.getId() + " is already unlocked shortly");
    }

    @Override
    public void unlockShortly() {
        System.out.println("Door " + door.getId() + " is already unlocked shortly");
    }

    @Override
    public void lock() {
        if (door.isClosed()) {
            door.setState(new DoorLocked(door, getId()));
            System.out.println("Door " + door.getId() + " is now locked");
        } else {
            System.out.println("Can't lock door " + door.getId() + " because it's opened");
        }
    }

    @Override
    public void prop() {
        System.out.println("Door " + door.getId() + " is unlocked");
    }

    @Override
    public String toString() {
        return DoorState.UNLOCKED_SHORTLY;
    }

}
