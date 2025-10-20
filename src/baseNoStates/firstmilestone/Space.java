package baseNoStates.firstmilestone;

/**
 * Un espai (Space) es una Area concreta que pertany a una Particio pare i
 * conte portes.
 */
public class Space extends Area {
    private Partition Partition_father;
    private Door[] Doors_children;

    public Space(String name, String description, Partition father, String[] door_IDS) {
        super(name, description);
        this.Partition_father = father;
        // Registrem aquest espaci en la seva particio pare
        father.addSpaceChild(this);
        for (String id : door_IDS) {
            Door door = DirectoryDoors.findDoorById(id);
            if(door != null){
                this.addDoorChild(new Door[]{door});
            }
        }
    }

    @Override
    public Door[] getDoors() {
        return Doors_children;
    }

    /** Afegeix portes al espaci. S'accepta un array per facilitar trucades desde el inicialitzdor. */
    public void addDoorChild(Door[] child) { 
        if(this.Doors_children == null){
            this.Doors_children =  child;
        } else {
            Door[] newArray = new Door[this.Doors_children.length + child.length];
            System.arraycopy(this.Doors_children, 0, newArray, 0, this.Doors_children.length);
            System.arraycopy(child, 0, newArray, this.Doors_children.length, child.length);
            this.Doors_children = newArray;
        }
    }

    @Override
    public Partition[] getPartitions() {
        return new Partition[]{this.Partition_father};
    }
}
