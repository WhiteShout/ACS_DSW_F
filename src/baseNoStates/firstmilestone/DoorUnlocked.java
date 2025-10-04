package baseNoStates.firstmilestone;

public class DoorUnlocked extends DoorState {

    public DoorUnlocked(Door door, String id) {
        super(door, DoorState.UNLOCKED);
    }

    public void open() {
        getDoor().setClosed(false);   
        System.out.println("Door " + getDoor().getId() + " is now open"); 
    }

    public void close() {
        getDoor().setClosed(true);   
        System.out.println("Door " + getDoor().getId() + " is now closed");
    }

    @Override
    public void unlock() {
        System.out.println("Door " + getDoor().getId() + " is already unlocked");
    }

    @Override
    public void unlockShortly() {
        System.out.println("Door " + getDoor().getId() + " is already unlocked");
    }

    @Override
    public void lock() {
        if (getDoor().isClosed()) {
            getDoor().setState(new DoorLocked(getDoor(), getId()));
            System.out.println("Door " + getDoor().getId() + " is now locked");
        } else {
            System.out.println("Can't lock door " + getDoor().getId() + " because it's open");
        }
    }

    @Override
    public void prop() {
        System.out.println("Door " + getDoor().getId() + " is unlocked");
    }

    @Override
    public String toString() {
        return DoorState.UNLOCKED;
    }
}
