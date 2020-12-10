package agenda;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class Event {

    /**
     * The myTitle of this event
     */
    private String myTitle;
    
    /**
     * The starting time of the event
     */
    private LocalDateTime myStart;

    /**
     * The durarion of the event 
     */
    private Duration myDuration;


    /**
     * Constructs an event
     *
     * @param title the title of this event
     * @param start the start time of this event
     * @param duration the duration of this event
     */
    public Event(String title, LocalDateTime start, Duration duration) {
        this.myTitle = title;
        this.myStart = start;
        this.myDuration = duration;
    }

    /**
     * Tests if an event occurs on a given day
     *
     * @param aDay the day to test
     * @return true if the event occurs on that day, false otherwise
     */
    public boolean isInDay(LocalDate aDay) {
        
        // J'ajoute l'équivalent en jour de ma durée a ma date de début pour ainsi avoir la date de fin
        LocalDate fin = myStart.plus(myDuration).toLocalDate();
        LocalDate start = myStart.toLocalDate();
        
        // Je vérifie si aDay est comprise entre fin est myStart
        return aDay.isEqual(start) || (aDay.isAfter(start) && aDay.isBefore(fin) || aDay.isEqual(fin));
    }
   
    /**
     * @return the myTitle
     */
    public String getTitles() {
        return myTitle;
    }

    /**
     * @return the myStart
     */
    public LocalDateTime getStart() {
        return myStart;
    }


    /**
     * @return the myDuration
     */
    public Duration getDuration() {
        return myDuration;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString(){
        return myTitle;
    }
    
}
