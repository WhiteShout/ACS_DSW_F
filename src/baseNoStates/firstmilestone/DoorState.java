package baseNoStates;

public abstract class DoorState {
  private final Door door;
  private String state;

  

  public static void update(){
    
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }
}