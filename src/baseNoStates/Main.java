package baseNoStates;

import baseNoStates.firstmilestone.DirectoryDoors;
import baseNoStates.firstmilestone.DirectoryUsers;

// Before executing enable assertions :
// https://se-education.org/guides/tutorials/intellijUsefulSettings.html

public class Main {
  public static void main(String[] args) {
    DirectoryDoors.makeDoors();
    DirectoryUsers.makeUsers();
    new WebServer();
  }
}
