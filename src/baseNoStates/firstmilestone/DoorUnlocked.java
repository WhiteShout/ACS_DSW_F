package baseNoStates.firstmilestone;

public class DoorUnlocked extends DoorState {

    public DoorUnlocked(Door door) {
        super(door); //Crida al constructor de la classe base doorState per establir com a unlocked la porta
    }

    //es canvia l'estat de la porta a oberta o tancada
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

    //només puc arribar a unlockshortly desde locked
    @Override
    public void unlockShortly() {
        System.out.println("Door " + door.getId() + " is already unlocked");
    }

    @Override
    public void lock() {
        if (door.isClosed()) {
            door.setState(new DoorLocked(door));
            System.out.println("Door " + door.getId() + " is now locked");
        } else {
            System.out.println("Can't lock door " + door.getId() + " because it's open"); //en cas que la porta estigui oberta no puc bloquejarla
        }
    }
    
    //només s'arriba desde unlock shortly
    @Override
    public void prop() {
        // En estat 'unlocked' la invocacio de prop() no aplica canvi.
        System.out.println("Door " + door.getId() + " is unlocked");
    }

    @Override
    public String toString() {
        return DoorState.UNLOCKED;
    }
}
