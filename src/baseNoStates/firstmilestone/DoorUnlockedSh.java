package baseNoStates;

public class DoorUnlockedSh extends DoorState {
    public DoorUnlockedShortly() {
        setState("unlocked_shortly");
    }

    public static DoorState update(Action action, Door door) {
        switch (action) {
            case Actions.LOCK:
                return new DoorLocked();
                break;
            case Actions.CLOSE:
                
                break;
            case Actions.OPEN:
                // remain in unlocked state
                break;
            case Actions.UNLOCK:
                // remain in unlocked state
                break;
            case Actions.UNLOCK_SHORTLY:
                // remain in unlocked state
                break;
            default:
                System.out.println("Action " + action + " is not valid for state unlocked");
        }
    }
}
