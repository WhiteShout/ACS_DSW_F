package baseNoStates.firstmilestone;

public class Space extends Area {
    private Partition Partition_father;
    private Door[] Doors_children;
    
    public Space(String name, String description, Partition father) {
        super(name, description);
        this.Partition_father = father;
        father.addSpaceChild(this);
    }

    @Override
    public Door[] getDoors() {
        return Doors_children;
    }

    public void addDoorChild(Door[] child){
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
