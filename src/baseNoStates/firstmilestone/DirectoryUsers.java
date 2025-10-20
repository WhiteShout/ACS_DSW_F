package baseNoStates.firstmilestone;
import java.util.ArrayList;

public final class DirectoryUsers {
  private static final ArrayList<User> users = new ArrayList<>();

  public static void makeUsers() {
    // es creen ususaris d'exemple amb rpñs diferents
    // en una aplicacio real aquestes dades vindrien d'una base de dades o servei extern
    users.add(new User("Bernat", "12345","guest"));
    users.add(new User("Blai", "77532","guest"));

    // employees :
    // Sep. 1 this year to Mar. 1 next year
    // week days 9-17h
    // just shortly unlock
    // ground floor, floor1, exterior, stairs (this, for all), that is, everywhere but the parking
    users.add(new User("Ernest", "74984", "employee"));
    users.add(new User("Eulalia", "43295", "employee"));

    // managers :
    // Sep. 1 this year to Mar. 1 next year
    // week days + saturday, 8-20h
    // all actions
    // all spaces
    users.add(new User("Manel", "95783", "manager"));
    users.add(new User("Marta", "05827", "manager"));

    // admin :
    // always=Jan. 1 this year to 2100
    // all days of the week
    // all actions
    // all spaces
    users.add(new User("Ana", "11343", "admin"));
  }

  public static User findUserByCredential(String credential) {
    if (credential == null) {
      return null;
    }
    for (User user : users) {
      if (credential.equals(user.getCredential())) {
        return user;
      }
    }
    // No trobat: retornar null per que la funcio que truca pugui registrar o manegar l'error
    System.out.println("user with credential " + credential + " not found");
    return null; // otherwise we get a Java error
  }

}
