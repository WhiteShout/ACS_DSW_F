package baseNoStates.firstmilestone;
import java.time.*;
import java.time.format.DateTimeFormatter;
public class Schedule{
    DayOfWeek[] days;
    LocalTime[] hours;
    LocalDate[] dates;

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