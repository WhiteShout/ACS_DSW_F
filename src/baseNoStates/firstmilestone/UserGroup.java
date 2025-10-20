package baseNoStates.firstmilestone;

import java.time.*;

public class UserGroup {
    private User[] users;
    private final String userGroupName;
    private final Schedule schedule;
    private final String[] actions;
    private final String[] doors;

    public UserGroup(String userGroupName, Schedule schedule, String[] actions, String[] doors) {
        this.userGroupName = userGroupName;
        this.schedule = schedule;
        this.actions = actions;
        this.doors = doors;
    }

    public String getUserGroupName() {
        return userGroupName;
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
        if (this.users == null) {
            this.users = new User[]{user};
        } else {
            User[] newArray = new User[this.users.length + 1];
            System.arraycopy(this.users, 0, newArray, 0, this.users.length);
            newArray[this.users.length] = user;
            this.users = newArray;
        }
    }

    public User[] getUsers() {
        return users;
    }

    public boolean isActionAllowed(String action, String doorId, LocalDateTime now) {
        if (action == null || doorId == null || now == null) {
            return false;
        }

        // action and door must be in allowed lists
        boolean actionAllowed = false;
        for (String a : getActions()) {
            if (a.equalsIgnoreCase(action)) {
                actionAllowed = true;
                break;
            }
        }

        boolean doorAllowed = false;
        for (String d : getDoors()) {
            if (d.equalsIgnoreCase(doorId)) {
                doorAllowed = true;
                break;
            }
        }

    // Si no hi ha schedule, considerem que no hi ha restriccio por data/hora.
        boolean dayAllowed = true;
        boolean hourAllowed = true;
        boolean dateAllowed = true;

        if (schedule != null) {
            // day
            dayAllowed = false;
            DayOfWeek currentDay = now.getDayOfWeek();
            for (DayOfWeek day : schedule.getDays()) {
                if (day.equals(currentDay)) {
                    dayAllowed = true;
                    break;
                }
            }

            // date
            LocalDate[] dates = schedule.getDates();
            if (dates != null && dates.length >= 2) {
                LocalDateTime startDate = dates[0].atStartOfDay();
                LocalDateTime endDate = dates[1].atTime(23, 59, 59);
                dateAllowed = now.isEqual(startDate) || now.isEqual(endDate) || (now.isAfter(startDate) && now.isBefore(endDate));
            }

            // hours
            LocalTime[] hours = schedule.getHours();
            if (hours != null && hours.length >= 2) {
                LocalTime nowTime = now.toLocalTime();
                LocalTime start = hours[0];
                LocalTime end = hours[1];
                hourAllowed = (nowTime.equals(start) || nowTime.isAfter(start)) && (nowTime.isBefore(end) || nowTime.equals(end));
            }
        }

        return actionAllowed && doorAllowed && dayAllowed && dateAllowed && hourAllowed;
    }
}