package baseNoStates.firstmilestone;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.time.LocalDate;

public final class DirectoryUserGroups {
    private static UserGroup[] userGroups;

    /*
     * Creem els diferents grups d'usuaris amb els seus horaris(dies de setmana, hores i dates), accions i portes assignades.
     */
    public static void makeUserGroups() {
        // admin
        String[] actionsAdmin = new String[]{Actions.CLOSE,Actions.OPEN, Actions.LOCK, Actions.UNLOCK, Actions.UNLOCK_SHORTLY}; //totes les accions
        DayOfWeek[] daysAdmin = DayOfWeek.values(); //tots el dies
        LocalTime[] hoursAdmin = new LocalTime[]{LocalTime.of(0, 0), LocalTime.of(23, 59)}; //tot el dia
        LocalDate[] datesAdmin = new LocalDate[]{LocalDate.of(2000, 1, 1), LocalDate.of(2100, 12, 31)};
        Schedule scheduleAdmin = new Schedule(daysAdmin, hoursAdmin, datesAdmin);  //creem l'horari a partir de les dades anteriors pasantles com a paramtre del constructor
        String[] doorsAdmin = new String[]{"D1", "D2", "D3", "D4", "D5", "D6", "D7", "D8", "D9"};
        UserGroup admin = new UserGroup("admin", scheduleAdmin, actionsAdmin, doorsAdmin);

        // employee
        String[] actionsEmployee = new String[]{Actions.CLOSE, Actions.OPEN, Actions.UNLOCK_SHORTLY};
        DayOfWeek[] daysEmployee = new DayOfWeek[]{DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY, DayOfWeek.THURSDAY, DayOfWeek.FRIDAY};
        LocalTime[] hoursEmployee = new LocalTime[]{LocalTime.of(9, 0), LocalTime.of(17, 0)};
        LocalDate[] datesEmployee = new LocalDate[]{LocalDate.of(2025, 7, 1), LocalDate.of(2026, 3, 1)};
        Schedule scheduleEmployee = new Schedule(daysEmployee, hoursEmployee, datesEmployee);
        String[] doorsEmployee = new String[]{"D3", "D4", "D5", "D6", "D7", "D8", "D9"}; //totes menys les de parking
        UserGroup employee = new UserGroup("employee", scheduleEmployee, actionsEmployee, doorsEmployee);

        // manager
        String[] actionsManager = new String[]{Actions.CLOSE, Actions.OPEN, Actions.LOCK, Actions.UNLOCK, Actions.UNLOCK_SHORTLY};
        DayOfWeek[] daysManager = new DayOfWeek[]{DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY, DayOfWeek.THURSDAY, DayOfWeek.FRIDAY, DayOfWeek.SATURDAY};
        LocalTime[] hoursManager = new LocalTime[]{LocalTime.of(8, 0), LocalTime.of(20, 0)};
        LocalDate[] datesManager = new LocalDate[]{LocalDate.of(2025, 7, 1), LocalDate.of(2026, 3, 1)};
        Schedule scheduleManager = new Schedule(daysManager, hoursManager, datesManager);
        String[] doorsManager = new String[]{"D1", "D2", "D3", "D4", "D5", "D6", "D7", "D8", "D9"};
        UserGroup manager = new UserGroup("manager", scheduleManager, actionsManager, doorsManager);

        // guest: no schedule, no actions, no doors (default restrictive)
        UserGroup guest = new UserGroup("guest", null, null, null);

        userGroups = new UserGroup[]{admin, employee, guest, manager};
    }


    /*
     * arg: name - el nom del grup d'usuaris a trobar
     * return: el UserGroup amb el nom demanat o null si no es troba
     */
    public static UserGroup findUserGroupByName(String name) {
        if (userGroups == null) {
            return null;
        }
        for (UserGroup userGroup : userGroups) {
            if (userGroup.getUserGroupName().equals(name)){
                return userGroup;
            }
        }
        // No encontrado; el comportamiento esperado es devolver null y que el llamador lo gestione.
        System.out.println("user group with name " + name + " not found");
        return null;
    }
}
