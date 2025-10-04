package baseNoStates.firstmilestone;

import java.util.Arrays;

public class Partition extends Area {
    private Partition[] Partition_children;
    private Space[] Space_children;

    public Partition(String name, String description, Partition father) {
        super(name, description);
        if(father != null){
            father.addPartitionChild(this);
        }
    }
    
    private void addPartitionChild(Partition child){
        if(this.Partition_children == null){
            this.Partition_children = new Partition[]{child};
        } else {
            Partition[] newArray = new Partition[this.Partition_children.length + 1];
            System.arraycopy(this.Partition_children, 0, newArray, 0, this.Partition_children.length);
            newArray[newArray.length - 1] = child;
            this.Partition_children = newArray;
        }
    }

    public void addSpaceChild(Space child){
        if(this.Space_children == null){
            this.Space_children = new Space[]{child};
        } else {
            Space[] newArray = new Space[this.Space_children.length + 1];
            System.arraycopy(this.Space_children, 0, newArray, 0, this.Space_children.length);
            newArray[newArray.length - 1] = child;
            this.Space_children = newArray;
        }
    }

    public static Door[] add(Door[] array1, Door[] array2)
    {
        if (array1 == null || array1.length == 0) {
            return array2 != null ? array2 : new Door[0];
        }
        if (array2 == null || array2.length == 0) {
            return array1;
        }

        Door[] newArray = Arrays.copyOf(array1, array1.length + array2.length);

        System.arraycopy(array2, 0, newArray, array1.length, array2.length);

        return newArray;
    }

    @Override
    public Door[] getDoors(){
        Door[] doors = new Door[]{};
        
        System.out.println("Getting doors for partition " + this.getName());
        
        if(Partition_children != null){
            for(int i = 0; i < Partition_children.length; i++){
                doors = add(doors, Partition_children[i].getDoors());
                System.out.println("Added doors from child partition " + Partition_children[i].getName());
            }
        }
        

        if(Space_children != null){
            for(int i = 0; i < Space_children.length; i++){
                doors = add(doors, Space_children[i].getDoors());
                System.out.println("Added doors from child space " + Space_children[i].getName());
            }
        }
        
        System.out.println("Total doors found: " + doors.length);
        return doors;
    }

    @Override
    public Partition[] getPartitions() {
        return Partition_children;
    }
}