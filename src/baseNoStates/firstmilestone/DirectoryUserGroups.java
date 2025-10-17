package baseNoStates.firstmilestone;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.time.LocalDate;

public class DirectoryUserGroups {
    private static UserGroup[] UserGroups;
    

    public static void makeUserGroups() {
        // admin
        String[] actionsAdmin = new String[]{Actions.CLOSE,Actions.OPEN, Actions.LOCK, Actions.UNLOCK, Actions.UNLOCK_SHORTLY};
        DayOfWeek[] daysAdmin = DayOfWeek.values();
        LocalTime[] hoursAdmin = new LocalTime[]{LocalTime.of(0, 0), LocalTime.of(23, 59)};
        LocalDate[] datesAdmin = new LocalDate[]{LocalDate.of(2000, 1, 1), LocalDate.of(2100, 12, 31)};
        Schedule scheduleAdmin = new Schedule(daysAdmin, hoursAdmin, datesAdmin);
        String[] doorsAdmin = new String[]{"D1", "D2", "D3", "D4", "D5", "D6", "D7", "D8", "D9"};
        UserGroup admin = new UserGroup("admin", scheduleAdmin, actionsAdmin, doorsAdmin);
        
        // employee
        String[] actionsEmployee = new String[]{Actions.CLOSE, Actions.OPEN, Actions.UNLOCK_SHORTLY};
        DayOfWeek[] daysEmployee = new DayOfWeek[]{DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY, DayOfWeek.THURSDAY, DayOfWeek.FRIDAY};
        LocalTime[] hoursEmployee = new LocalTime[]{LocalTime.of(9, 0), LocalTime.of(17, 0)};
        LocalDate[] datesEmployee = new LocalDate[]{LocalDate.of(2025, 7, 1), LocalDate.of(2026, 3, 1)};
        Schedule scheduleEmployee = new Schedule(daysEmployee, hoursEmployee, datesEmployee);
        String[] doorsEmployee = new String[]{"D3", "D4", "D5", "D6", "D7", "D8", "D9"};
        UserGroup employee = new UserGroup("employee", scheduleEmployee, actionsEmployee, doorsEmployee);

        // manager
        String[] actionsManager = new String[]{Actions.CLOSE, Actions.OPEN, Actions.LOCK, Actions.UNLOCK, Actions.UNLOCK_SHORTLY};
        DayOfWeek[] daysManager = new DayOfWeek[]{DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY, DayOfWeek.THURSDAY, DayOfWeek.FRIDAY, DayOfWeek.SATURDAY};
        LocalTime[] hoursManager = new LocalTime[]{LocalTime.of(8, 0), LocalTime.of(20, 0)};
        LocalDate[] datesManager = new LocalDate[]{LocalDate.of(2025, 7, 1), LocalDate.of(2026, 3, 1)};
        Schedule scheduleManager = new Schedule(daysManager, hoursManager, datesManager);
        String[] doorsManager = new String[]{"D1", "D2", "D3", "D4", "D5", "D6", "D7", "D8", "D9"};
        UserGroup manager = new UserGroup("manager", scheduleManager, actionsManager, doorsManager);

        // guest
        Schedule scheduleGuest = null;
        UserGroup guest = new UserGroup("guest", scheduleGuest, null, null);
        UserGroups = new UserGroup[]{admin, employee, guest, manager};
    }
    
    public static UserGroup findUserGroupByName(String name) {
        for (UserGroup userGroup : UserGroups) {
            if (userGroup.getUserGroupName().equals(name)){
                return userGroup;
            }
        }
        System.out.println("user group with name " + name + " not found");
        return null;
    }
}
