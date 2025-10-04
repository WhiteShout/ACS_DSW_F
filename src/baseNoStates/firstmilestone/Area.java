package baseNoStates.firstmilestone;

public abstract class Area {
    private String Name;
    private String description;
    private Area[] Areas;

    public Area(String name, String description) {
        Name = name;
        this.description = description;
    }

    public String getName() {
        return Name;
    }
    public String getDescription() {
        return description;
    }

    public Area[] getAreas() {
        return Areas;
    }

    public abstract Door[] getDoors();
    public abstract Partition[] getPartitions();

}
