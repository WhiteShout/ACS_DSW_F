package baseNoStates;

public abstract class DoorState {
  private String state; //door state eg. unlocked, locked, etc. 

  public static void update(Action action, state){}

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }
}