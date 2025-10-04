package baseNoStates.firstmilestone;

public class DoorPropped extends DoorState {

    public DoorPropped(Door door, String id) {
        super(door, DoorState.PROPPED);
    }

    public void open() {
        System.out.println("Door " + getDoor().getId() + " is already open"); 
    }

    public void close() {
        getDoor().setClosed(true);   
        System.out.println("Door " + getDoor().getId() + " is now closed, magically unpropped");
        getDoor().setState(new DoorLocked(getDoor(), getId()));
        System.out.println("Door " + getDoor().getId() + " is now locked");
    }

    @Override
    public void unlock() {
        System.out.println("Door " + getDoor().getId() + " is propped");
    }

    @Override
    public void unlockShortly() {
        System.out.println("Door " + getDoor().getId() + " is propped");
    }

    @Override
    public void lock() {
        if (getDoor().isClosed()) {
            getDoor().setState(new DoorLocked(getDoor(), getId()));
            System.out.println("Door " + getDoor().getId() + " is now locked");
        } else {
            System.out.println("Can't lock door " + getDoor().getId() + " because it's open, remember it's propped u genius");
        }
    }

    @Override
    public void prop() {
        System.out.println("Door " + getDoor().getId() + " is already propped");
    }

    @Override
    public String toString() {
        return DoorState.PROPPED;
    }

}
