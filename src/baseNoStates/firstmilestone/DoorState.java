package baseNoStates.firstmilestone;

public abstract class DoorState {
  protected final Door door;

  public DoorState(Door door) {
    this.door = door;
  }

  public static final String LOCKED = "locked"; 
  public static final String UNLOCKED = "unlocked";
  public static final String OPEN = "open";
  public static final String CLOSED = "closed";
  public static final String UNLOCKED_SHORTLY = "unlocked_shortly";
  public static final String PROPPED = "propped";
  
  public abstract void open();
  public abstract void close();
  public abstract void lock();
  public abstract void unlock();
  public abstract void unlockShortly();
  public abstract void prop();
  


  public Door getDoor() {
    return door;
  }

}