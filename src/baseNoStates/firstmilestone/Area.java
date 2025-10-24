package baseNoStates.firstmilestone;

/*
 * Interface class Area representa una àrea dins del sistema de control d'accés.
 * Cada àrea té un nom, una descripció(Sin uso) i pot tenir diverses portes i particions associades.
 */
public interface Area {
    public abstract String getName();
    public abstract Area[] getChildren();
    public abstract Door[] getDoors();
}
