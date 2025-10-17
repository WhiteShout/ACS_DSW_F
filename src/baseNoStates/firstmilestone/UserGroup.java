package baseNoStates.firstmilestone;

import java.time.LocalDateTime;

public class UserGroup{
    User[] Users;
    private String UserGroupName;
    private String[] days;
    private int[] dates;
    private String[] hours;
    private String[] actions;
    private String[] doors;

    @schedule 
    public UserGroup(String UserGroupName, String[] days, int[] dates, String[] hours, String[] actions, String[] doors) {
        this.UserGroupName = UserGroupName;
        this.days = days;
        this.dates = dates;
        this.hours = hours;
        this.actions = actions;
        this.doors = doors;
    }

    public String getUserGroupName() {
        return UserGroupName;
    }

    public String[] getDays() {
        return days;
    }

    public int[] getDates() {
        return dates;
    }

    public String[] getHours() {
        return hours;
    }

    public String[] getActions() {
        return actions;
    }

    public String[] getDoors() {
        return doors;
    }

    public void addUser(User user) {
        if (this.Users == null) {
            this.Users = new User[]{user};
        } else {
            User[] newArray = new User[this.Users.length + 1];
            System.arraycopy(this.Users, 0, newArray, 0, this.Users.length);
            newArray[this.Users.length] = user;
            this.Users = newArray;
        }
    }

    public User[] getUsers() {
        return Users;
    }

    public boolean isActionAllowed(String action, String doorId, LocalDateTime now) {
        boolean actionAllowed = false;
        boolean doorAllowed = false;
        boolean dayAllowed = false;
        boolean dateAllowed = false;
        boolean hourAllowed = false;

        // Check if the action is allowed
        for (String a : actions) {
            if (a.equalsIgnoreCase(action)) {
                actionAllowed = true;
                break;
            }
        }

        // Check if the door is allowed
        for (String d : doors) {
            if (d.equalsIgnoreCase(doorId)) {
                doorAllowed = true;
                break;
            }
        }

        // Check if the day is allowed
        String currentDay = now.getDayOfWeek().toString().substring(0, 3); 
        for (String day : days) {
            if (day.equalsIgnoreCase(currentDay)) {
                dayAllowed = true;
                break;
            }
        }

        // Check if the date is allowed
        String currentDate = String.format("%02d", now.getDayOfMonth()) + "," + String.format("%02d", now.getMonth()) + "," + now.getYear();
        for (String date : dates) {
            if (date.equalsIgnoreCase(currentDate)) {
                dateAllowed = true;
                break;
            }
        }

        // Check if the hour is allowed
        String[] hourRange = hours[0].split(":");
        int startHour = Integer.parseInt(hourRange[0]);
        int startMinute = Integer.parseInt(hourRange[1]);
        hourRange = hours[1].split(":");
        int endHour = Integer.parseInt(hourRange[0]);
        int endMinute = Integer.parseInt(hourRange[1]);

        int currentHour = now.getHour();
        int currentMinute = now.getMinute();

        if ((currentHour > startHour || (currentHour == startHour && currentMinute >= startMinute)) &&
            (currentHour < endHour || (currentHour == endHour && currentMinute <= endMinute))) {
            hourAllowed = true;
        }

        return actionAllowed && doorAllowed && dayAllowed && dateAllowed && hourAllowed;
    }
}