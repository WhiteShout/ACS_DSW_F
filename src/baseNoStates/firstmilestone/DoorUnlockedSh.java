package baseNoStates.firstmilestone;
import java.util.Timer;
import java.util.Observer;
import java.util.TimerTask;

public class DoorUnlockedSh extends DoorState implements Observer {//aquesta clase treballa com un observador per al clock que es l'observable

    public DoorUnlockedSh(Door door, long ms) {
        super(door);
        Clock clock = new Clock((long) ms, this);  //creo un nou clock per notificarme quan pasi el temps(10 segons)

    }
    @Override
    public void update(java.util.Observable observable, Object arg) {
        //System.out.println("/--------------/ \n Update form observable \n /--------------/");
        if (door.isClosed()) { //si la porta es tancada, quan pasa el temps es bloqueja, si no es queda propped
            door.setState(new DoorLocked(door));
            System.out.println("Door " + door.getId() + " is now locked");
        } else {
            door.setState(new DoorPropped(door));
            System.out.println("Can't lock door " + door.getId() + " because it's opened or blocked");
        }
    }

    //durant el temps de unlock shortly es pot obrir i tancar la porta
    public void open() {
        door.setClosed(false);   
        System.out.println("Door " + door.getId() + " is now open"); 
    }

    public void close() {
        door.setClosed(true);   
        System.out.println("Door " + door.getId() + " is now closed");
    }
    //no podem desbloquejarla donat que ja ho esta
    @Override
    public void unlock() {
        System.out.println("Door " + door.getId() + " is already unlocked shortly");
    }
    
    @Override
    public void unlockShortly() {
        System.out.println("Door " + door.getId() + " is already unlocked shortly");
    }

    //podem bloquejarla si esta tancada
    @Override
    public void lock() {
        if (door.isClosed()) {
            door.setState(new DoorLocked(door));
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
