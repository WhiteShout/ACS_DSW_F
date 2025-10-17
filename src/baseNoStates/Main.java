package baseNoStates;

import baseNoStates.firstmilestone.DirectoryDoors;
import baseNoStates.firstmilestone.DirectoryUsers;
import baseNoStates.firstmilestone.DirectoryAreas;
import baseNoStates.firstmilestone.DirectoryUserGroups;


// Before executing enable assertions :
// https://se-education.org/guides/tutorials/intellijUsefulSettings.html

public class Main {
  public static void main(String[] args) {
    DirectoryDoors.makeDoors();
    DirectoryAreas.makeAreas();
    DirectoryUserGroups.makeUserGroups();
    DirectoryUsers.makeUsers();
    new WebServer();
  }
}
