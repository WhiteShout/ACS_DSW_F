package baseNoStates.firstmilestone;

/**
 * Un espai (Space) es una Area concreta que pertany a una Particio pare i
 * conte portes. Implementa el patró Composite com a fulla (leaf).
 */
public class Space implements Area {
    private String name;
    private String description;
    private Door[] doors;

    public Space(String name, String description, Partition parent, String[] doorIds) {
        this.name = name;
        this.description = description;
        this.doors = new Door[0];
        
        if (parent != null) {
            ((Partition)parent).addChild(this);
        }
        
        for (String id : doorIds) {
            Door door = DirectoryDoors.findDoorById(id);
            if(door != null) {
                addDoor(door);
            }
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Door[] getDoors() {
        return doors;
    }

    @Override
    public Area[] getChildren() {
        return new Area[0]; // Leaf node has no children
    }

    /** Afegeix una porta al espai. */
    private void addDoor(Door door) {
        Door[] newArray = new Door[this.doors.length + 1];
        System.arraycopy(this.doors, 0, newArray, 0, this.doors.length);
        newArray[newArray.length - 1] = door;
        this.doors = newArray;
    }
}
