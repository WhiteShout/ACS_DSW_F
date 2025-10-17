package baseNoStates.firstmilestone;

public class User {
  private final String name;
  private final String credential;
  private final UserGroup userGroup;

  public User(String name, String credential, String UserGroupName) {
    this.name = name;
    this.credential = credential;
    this.userGroup = DirectoryUserGroups.findUserGroupByName(UserGroupName);
    if (this.userGroup != null) {
      this.userGroup.addUser(this);
    }
  }

  public String getCredential() {
    return credential;
  }

  public String getName() {
    return name;
  }

  public UserGroup getUserGroup() {
    if (userGroup != null) {
      return userGroup;
    } else {
      return null;
    }
  }


  @Override
  public String toString() {
    return "User{name=" + name + ", credential=" + credential + "}";
  }
}
