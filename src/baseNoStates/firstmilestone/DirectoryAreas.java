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
    Space parking = new Space("parking", "parking_descript", basement, new String[]{"D1", "D2"});
    Space hall = new Space("hall", "hall_descript", groundFloor, new String[]{"D3", "D4", "D5", "D6"});
    //stairs
    Space stairs = new Space("stairs", "stairs_descript", basement, new String[]{"D2", "D4", "D7"}) ;
    //exterior
    Space exterior = new Space("exterior", "exterior_descript", basement, new String[]{"D1", "D3"});
    //rooms
    Space room1 = new Space("room1", "room1_descript",groundFloor, new String[]{"D5"});
    Space room2 = new Space("room2", "room2_descript", groundFloor, new String[]{"D6"});
    Space room3 = new Space("room3", "room3_descript", floor1, new String[]{"D8"});
    Space corridor = new Space("corridor", "corridor_descript", floor1, new String[]{"D7", "D8", "D9"});
    Space IT = new Space("IT", "IT_descript", floor1, new String[]{"D9"});
    


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
