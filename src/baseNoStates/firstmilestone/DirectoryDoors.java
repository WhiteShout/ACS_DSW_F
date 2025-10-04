package baseNoStates.firstmilestone;

import java.util.ArrayList;
import java.util.Arrays;

public final class DirectoryDoors {
  private static ArrayList<Door> allDoors;

  public static void makeDoors() {
    // basement
    Space parking = (Space) DirectoryAreas.findAreaByName("parking"); //
    Space stairs = (Space) DirectoryAreas.findAreaByName("stairs");
    Space exterior = (Space) DirectoryAreas.findAreaByName("exterior");
    
    Door d1 = new Door("D1", exterior, parking); // exterior, parking
    Door d2 = new Door("D2", stairs, parking); // stairs, parking

    parking.addDoorChild(new Door[]{d1, d2});
    stairs.addDoorChild(new Door[]{d2});
    exterior.addDoorChild(new Door[]{d1});

    // ground floor
    Space hall = (Space) DirectoryAreas.findAreaByName("hall");
    Space room1 = (Space) DirectoryAreas.findAreaByName("room1");
    Space room2 = (Space) DirectoryAreas.findAreaByName("room2");

    Door d3 = new Door("D3", exterior, hall); // exterior, hall
    Door d4 = new Door("D4", stairs, hall); // stairs, hall
    Door d5 = new Door("D5", hall, room1); // hall, room1
    Door d6 = new Door("D6", hall, room2); // hall, room2

    hall.addDoorChild(new Door[]{d3, d4, d5, d6});
    stairs.addDoorChild(new Door[]{d4});
    exterior.addDoorChild(new Door[]{d3});
    room1.addDoorChild(new Door[]{d5});
    room2.addDoorChild(new Door[]{d6});

    // first floor
    Space corridor = (Space) DirectoryAreas.findAreaByName("corridor");
    Space room3 = (Space) DirectoryAreas.findAreaByName("room3");
    Space IT = (Space) DirectoryAreas.findAreaByName("IT");

    Door d7 = new Door("D7", stairs, corridor); // stairs, corridor
    Door d8 = new Door("D8", corridor, room3); // corridor, room3
    Door d9 = new Door("D9", corridor, IT); // corridor, IT

    corridor.addDoorChild(new Door[]{d7, d8, d9});
    stairs.addDoorChild(new Door[]{d7});
    room3.addDoorChild(new Door[]{d8});
    IT.addDoorChild(new Door[]{d9});

    allDoors = new ArrayList<>(Arrays.asList(d1, d2, d3, d4, d5, d6, d7, d8, d9));
  }

  public static Door findDoorById(String id) {
    for (Door door : allDoors) {
      if (door.getId().equals(id)) {
        return door;
      }
    }
    System.out.println("door with id " + id + " not found");
    return null; // otherwise we get a Java error
  }

  // this is needed by RequestRefresh
  public static ArrayList<Door> getAllDoors() {
    System.out.println(allDoors);
    return allDoors;
  }

}
