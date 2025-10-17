package baseNoStates.firstmilestone;

public class DoorUnlocked extends DoorState {

    public DoorUnlocked(Door door, String id) {
        super(door, DoorState.UNLOCKED);
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
        System.out.println("Door " + door.getId() + " is already unlocked");
    }

    @Override
    public void unlockShortly() {
        System.out.println("Door " + door.getId() + " is already unlocked");
    }

    @Override
    public void lock() {
        if (door.isClosed()) {
            door.setState(new DoorLocked(door, getId()));
            System.out.println("Door " + door.getId() + " is now locked");
        } else {
            System.out.println("Can't lock door " + door.getId() + " because it's open");
        }
    }

    @Override
    public void prop() {
        System.out.println("Door " + door.getId() + " is unlocked");
    }

    @Override
    public String toString() {
        return DoorState.UNLOCKED;
    }
}
