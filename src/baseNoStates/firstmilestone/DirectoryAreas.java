package baseNoStates.firstmilestone;

import java.util.ArrayList;
import java.util.Arrays;

public final class DirectoryAreas {
  private static ArrayList<Area> allAreas;

  public static void makeAreas() {
    // building
    Partition building = new Partition("building", "building_descript", null);
    // basement
    Partition basement = new Partition("basement", "basement_descript", building);
    // ground floor
    Partition groundFloor =  new Partition("ground_floor", "ground_floor_descript", building);
    //floor 1
    Partition floor1 =  new Partition("floor1", "floor1_descript", building);

    // spaces
    Space parking = new Space("parking", "parking_descript,", basement);
    Space hall = new Space("hall", "hall_descript", groundFloor);
    Space stairs = new Space("stairs", "stairs_descript", building);
    Space exterior = new Space("exterior", "exterior_descript", groundFloor);
    Space room1 = new Space("room1", "room1_descript",groundFloor);
    Space room2 = new Space("room2", "room2_descript", groundFloor);
    Space room3 = new Space("room3", "room3_descript", floor1);
    Space corridor = new Space("corridor", "corridor_descript", floor1);
    Space IT = new Space("IT", "IT_descript", floor1);
    


    allAreas = new ArrayList<>(Arrays.asList(building, basement, groundFloor, floor1,
        parking, hall, stairs, exterior, room1, room2, room3, corridor, IT));
  }

  public static Area findAreaByName (String name) {
      for (Area area : allAreas) {
          if (area.getName().equals(name)){
              return area;
          }
      }
      System.out.println("area with name " + name + " not found");
      return null;
  }

  public static ArrayList<Area> getAllAreas() {
      return allAreas;
  }

}
