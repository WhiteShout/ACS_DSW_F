package baseNoStates.firstmilestone;

/*
 * Abstract class Area representa una àrea dins del sistema de control d'accés.
 * Cada àrea té un nom, una descripció(Sin uso) i pot tenir diverses portes i particions associades.
 */
public abstract class Area {
    private final String name;
    private final String description;

    public Area(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }

    public abstract Door[] getDoors();
    public abstract Partition[] getPartitions();
}
