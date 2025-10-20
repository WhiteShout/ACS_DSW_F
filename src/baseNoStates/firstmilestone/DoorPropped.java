package baseNoStates.firstmilestone;

public class DoorPropped extends DoorState {

    public DoorPropped(Door door) {
        super(door); //Crida al constructor de la classe base doorState per establir com a propped la porta
    }

    public void open() {
        // Una porta 'propped' (bloquejada amb un objecte) es considera oberta.
        System.out.println("Door " + door.getId() + " is already open");
    }

    public void close() { //quan tanquem una porta propped, aquesta es tanca i es bloqueja
        door.setClosed(true);   
        System.out.println("Door " + door.getId() + " is now closed, magically unpropped");
        door.setState(new DoorLocked(door));
        System.out.println("Door " + door.getId() + " is now locked");
    }
    
    //no es podran fer canvis d'estat desde propped a menys que es tanqui la porta
    @Override
    public void unlock() {
        System.out.println("Door " + door.getId() + " is propped");
    }

    @Override
    public void unlockShortly() {
        System.out.println("Door " + door.getId() + " is propped");
    }

    @Override
    public void lock() {
        if (door.isClosed()) {
            door.setState(new DoorLocked(door));
            System.out.println("Door " + door.getId() + " is now locked");
        } else {
            System.out.println("Can't lock door " + door.getId() + " because it's open, remember it's propped u genius");
        }
    }

    @Override
    public void prop() {
        System.out.println("Door " + door.getId() + " is already propped");
    }

    @Override
    public String toString() {
        return DoorState.PROPPED;
    }

}
