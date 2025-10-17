package baseNoStates.firstmilestone;

public class DoorLocked extends DoorState {

    public DoorLocked(Door door, String id) {
        super(door, DoorState.LOCKED);
    }

    public void open() {
        System.out.println("Door " + door.getId() + " is locked"); 
    }

    public void close() {
        System.out.println("Door " + door.getId() + " is locked");
    }

    @Override
    public void unlock() {
        door.setState(new DoorUnlocked(door, getId()));
        System.out.println("Door " + door.getId() + " is now unlocked");
    }

    @Override
    public void unlockShortly() {
        door.setState(new DoorUnlockedSh(door, getId()));
        System.out.println("Door " + door.getId() + " is now unlocked shortly");
    }

    @Override
    public void lock() {
        System.out.println("Door " + door.getId() + " is already locked");
    }

    @Override
    public void prop() {
        System.out.println("Door " + door.getId() + " is locked");
    }

    @Override
    public String toString() {
        return DoorState.LOCKED;
    }
}
