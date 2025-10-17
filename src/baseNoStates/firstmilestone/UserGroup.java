package baseNoStates.firstmilestone;

import java.time.*;

public class UserGroup{
    User[] Users;
    private String UserGroupName;
    private Schedule schedule; 
    private String[] actions;
    private String[] doors;

    public UserGroup(String UserGroupName, Schedule schedule, String[] actions, String[] doors) {
        this.UserGroupName = UserGroupName;
        this.schedule = schedule;
        this.actions = actions;
        this.doors = doors;
    }

    public String getUserGroupName() {
        return UserGroupName;
    }

    public DayOfWeek[] getDays() {
        return schedule.getDays();
    }

    public LocalDate[] getDates() {
        return schedule.getDates();
    }

    public LocalTime[] getHours() {
        return schedule.getHours();
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
        DayOfWeek currentDay = now.getDayOfWeek(); 
        for (DayOfWeek day : schedule.getDays()) {
            if (day.equals(currentDay)) {
                dayAllowed = true;
                break;
            }
        }

        // Check if the date is allowed, in shcedule dates are in format YYYYMMDD
        LocalDateTime startDate = schedule.getDates()[0].atStartOfDay();
        LocalDateTime endDate = schedule.getDates()[1].atTime(23, 59, 59);
        if (now.isEqual(startDate) || now.isEqual(endDate) || (now.isAfter(startDate) && now.isBefore(endDate))) {
            dateAllowed = true;
        }

        // Check if the hour is allowed
        LocalTime nowTime = now.toLocalTime();
        for (LocalTime time : schedule.getHours()) {
            if (((nowTime.equals(schedule.getHours()[0]) ||  nowTime.isAfter(schedule.getHours()[0])) && (nowTime.isBefore(schedule.getHours()[1]) || nowTime.equals(schedule.getHours()[1])))) {
                hourAllowed = true;
                break;
            }
        }

        return actionAllowed && doorAllowed && dayAllowed && dateAllowed && hourAllowed;
    }
}