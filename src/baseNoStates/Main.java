package baseNoStates;

import baseNoStates.firstmilestone.DirectoryDoors;
import baseNoStates.firstmilestone.DirectoryUsers;
import baseNoStates.firstmilestone.DirectoryAreas;

// Before executing enable assertions :
// https://se-education.org/guides/tutorials/intellijUsefulSettings.html

public class Main {
  public static void main(String[] args) {
    DirectoryDoors.makeDoors();
    DirectoryAreas.makeAreas();
    DirectoryUsers.makeUsers();
    new WebServer();
  }
}
