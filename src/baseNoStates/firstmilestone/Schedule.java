package baseNoStates.firstmilestone;

import java.time.*;

/**
 * Representa l'interval de temps en que un UserGroup te permisos. 
* - days: dies de la setmana permesos 
* - hours: parell [horaInici, horaFi] 
* - dates: parell [dataInici, dataFi]
 */
public class Schedule{
    private DayOfWeek[] days;
    private LocalTime[] hours;
    private LocalDate[] dates;

    Schedule(DayOfWeek[] days, LocalTime[] hours, LocalDate[] dates){
        this.days = days;
        this.hours = hours;
        this.dates = dates;
    }

    public DayOfWeek[] getDays(){
        return days;
    }

    public LocalDate[] getDates(){
        return dates;
    }
    
    public LocalTime[] getHours(){
        return hours;
    }

}