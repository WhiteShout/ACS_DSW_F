package baseNoStates;

public class DoorLocked extends DoorState {
  public DoorLocked() {
    setState("locked");
  }
  public void unlock(){
    this.setState("unlocked");
  }

  public void unlockShortly(){
    this.setState("unlockedShortly");
  }


}
