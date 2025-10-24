package baseNoStates.firstmilestone;

import java.util.Arrays;

/**
 * Representa una particio (agrupacio logica) que pot contenir particions filles
 * i espais. Implementa de Area. Aquesta classe expon metodes per afegir fills i per
 * obtenir recursivament les portes asociades.
 */
public class Partition implements Area {
    private String name;
    private String description;
    private Area[] children;

    /** Constructor de Partition. Si es proporciona una particio pare, es registra en ella. */
    public Partition(String name, String description, Partition father) {
        this.name = name;
        this.description = description; 
        if (father != null) {
            father.addChild(this);
        }
    }

    /** Afegeix una particio o espai fill a aquesta particio. */
    public void addChild(Area child) {
        if (this.children == null) {
            this.children = new Area[]{child};
        } else {
            Area[] newArray = new Area[this.children.length + 1];
            System.arraycopy(this.children, 0, newArray, 0, this.children.length);
            newArray[newArray.length - 1] = child;
            this.children = newArray;
        }
    }

    /** Afegeix dos arrays de portes y retorna el resultat. */
    public static Door[] add(Door[] array1, Door[] array2) {
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
    public String getName() {
        return name;
    }

    @Override
    public Door[] getDoors() {
        Door[] doors = new Door[]{};
        
        System.out.println("Getting doors for partition " + this.getName());
        
        if(children != null){
            for(int i = 0; i < children.length; i++){
                doors = add(doors, children[i].getDoors());
                System.out.println("Added doors from child partition " + children[i].getName());
            }
        }
        
        System.out.println("Total doors found: " + doors.length);
        return doors;
    }

    @Override
    public Area[] getChildren() {
        return children;
    }
}