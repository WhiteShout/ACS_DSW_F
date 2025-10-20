package baseNoStates.firstmilestone;

import java.util.ArrayList;
import java.util.Arrays;

public final class DirectoryAreas {
  private static ArrayList<Area> allAreas; //array on guardarem les arees (espais i particions)
   /*
   * Crea les diferents arees (espais i particions) amb les seves descripcions, les portes que les componen i la seva particio corresponent.
   */
  public static void makeAreas() {
    //inicialment guardem les particions generals 
    
    Partition building = new Partition("building", "building_descript", null);
    Partition basement = new Partition("basement", "basement_descript", building);
    Partition groundFloor =  new Partition("ground_floor", "ground_floor_descript", building);
    Partition floor1 =  new Partition("floor1", "floor1_descript", building);

    //despres guardem els espais amb la seva particio corresponent al la que pertany i les seves portes
    Space parking = new Space("parking", "parking_descript", basement, new String[]{"D1", "D2"});
    Space hall = new Space("hall", "hall_descript", groundFloor, new String[]{"D3", "D4", "D5", "D6"});
    Space stairs = new Space("stairs", "stairs_descript", basement, new String[]{"D2", "D4", "D7"}) ;
    Space exterior = new Space("exterior", "exterior_descript", basement, new String[]{"D1", "D3"});
    Space room1 = new Space("room1", "room1_descript",groundFloor, new String[]{"D5"});
    Space room2 = new Space("room2", "room2_descript", groundFloor, new String[]{"D6"});
    Space room3 = new Space("room3", "room3_descript", floor1, new String[]{"D8"});
    Space corridor = new Space("corridor", "corridor_descript", floor1, new String[]{"D7", "D8", "D9"});
    Space IT = new Space("IT", "IT_descript", floor1, new String[]{"D9"});
    

    //finalment guardem totes les arees en l'array creat abans per a poder accedir a elles posteriorment
    allAreas = new ArrayList<>(Arrays.asList(building, basement, groundFloor, floor1,
        parking, hall, stairs, exterior, room1, room2, room3, corridor, IT));
  }
    
    
  public static Area findAreaByName (String name) {
      if (allAreas == null) {
          return null;
      }
      for (Area area : allAreas) {
          if (area != null && area.getName().equals(name)){
              return area;
          }
      }
      // Retorna null si no es troba; la funcio que truca ha de comprobar-ho
      System.out.println("area with name " + name + " not found");
      return null;
  }

  public static ArrayList<Area> getAllAreas() {
      return allAreas;
  }

}
