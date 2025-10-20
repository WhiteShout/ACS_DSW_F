package baseNoStates.firstmilestone;

public class DoorLocked extends DoorState {

    public DoorLocked(Door door) { 
        super(door); //Crida al constructor de la classe base doorState per establir com a locked la porta
    }

    // Si la porta esta bloquejada no es posible obrirla ni tancarla.
    public void open() {
        System.out.println("Door " + door.getId() + " is locked"); 
    }

    public void close() {
        System.out.println("Door " + door.getId() + " is locked");
    }

    // canvia l'estat de la porta a desbloquejada o desbloquejada temporalment
    @Override
    public void unlock() {
        door.setState(new DoorUnlocked(door));
        System.out.println("Door " + door.getId() + " is now unlocked");
    }

    @Override
    public void unlockShortly() {
        door.setState(new DoorUnlockedSh(door, 10000));
        System.out.println("Door " + door.getId() + " is now unlocked shortly");
    }

    //si la porta ja hi esta bloquejada no es pot bloquejar de nou 
    @Override
    public void lock() {
        System.out.println("Door " + door.getId() + " is already locked");
    }

    // a proped nomes s'arriba desde unlockshortly
    @Override
    public void prop() {
        System.out.println("Door " + door.getId() + " is locked");
    }

    @Override
    public String toString() {
        return DoorState.LOCKED;
    }
}
