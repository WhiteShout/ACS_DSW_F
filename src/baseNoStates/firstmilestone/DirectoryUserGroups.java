package baseNoStates.firstmilestone;

public class DirectoryUserGroups {
    private static UserGroup[] UserGroups;
    

    public static void makeUserGroups() {
        // admin
        String[] actionsAdmin = new String[]{Actions.CLOSE,Actions.OPEN, Actions.LOCK, Actions.UNLOCK, Actions.UNLOCK_SHORTLY};
        String[] daysAdmin = new String[]{"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
        int[] hoursAdmin = new int[]{00,23};
        String[] datesAdmin = new String[]{"01,01,2000","31,12,2100"};
        String[] doorsAdmin = new String[]{"D1", "D2", "D3", "D4", "D5", "D6", "D7", "D8", "D9"};
        UserGroup admin = new UserGroup("admin",daysAdmin, datesAdmin, hoursAdmin, actionsAdmin, doorsAdmin);
        
        //employee
        String[] actionsEmployee = new String[]{Actions.CLOSE, Actions.OPEN, Actions.UNLOCK_SHORTLY};
        String[] daysEmployee = new String[]{"Mon", "Tue", "Wed", "Thu", "Fri"};
        int[] hoursEmployee = new int[]{9,17};
        String[] datesEmployee = new String[]{"01,07,2025","1,3,2026"};
        String[] doorsEmployee = new String[]{"D3", "D4", "D5", "D6", "D7", "D8", "D9"};
        UserGroup employee = new UserGroup("employee", daysEmployee, datesEmployee, hoursEmployee, actionsEmployee, doorsEmployee);

        //manager
        String[] actionsManager = new String[]{Actions.CLOSE, Actions.OPEN, Actions.LOCK, Actions.UNLOCK, Actions.UNLOCK_SHORTLY};
        String[] daysManager = new String[]{"Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        int[] hoursManager = new int[]{8,20};
        String[] datesManager = new String[]{"01,07,2025","1,3,2026"};
        String[] doorsManager = new String[]{"D1", "D2", "D3", "D4", "D5", "D6", "D7", "D8", "D9"};
        UserGroup manager = new UserGroup("manager", daysManager, datesManager, hoursManager, actionsManager, doorsManager);
        //guest
        UserGroup guest = new UserGroup("guest", null, null, null, null, null);
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
