package agenda;

import java.util.*;
import java.time.*;
import java.time.temporal.ChronoUnit;

/**
 * Description : A repetitive Event
 */
public class RepetitiveEvent extends Event {
    
    ChronoUnit myFrequency;
    LocalDateTime repetition;
    LocalDateTime finT;
    private final List<LocalDate> exception = new LinkedList<>();
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
     * Constructs a repetitive event
     *
     * @param title the title of this event
     * @param start the start of this event
     * @param duration myDuration in seconds
     * @param frequency one of :
     * <UL>
     * <LI>ChronoUnit.DAYS for daily repetitions</LI>
     * <LI>ChronoUnit.WEEKS for weekly repetitions</LI>
     * <LI>ChronoUnit.MONTHS for monthly repetitions</LI>
     * </UL>
     */
    public RepetitiveEvent(String title, LocalDateTime start, Duration duration, ChronoUnit frequency) {
        super(title, start, duration);
        
        this.myTitle = title;
        this.myStart = start;
        this.myDuration = duration;
        this.myFrequency=frequency;
        
       
        
    }

    /**
     * Adds an exception to the occurrence of this repetitive event
     *
     * @param date the event will not occur at this date
     */
    public void addException(LocalDate date) {
        // Ajoute la date exceptionnelle à notre collection d'exception
        exception.add(date);
    }

    /**
     *
     * @return the type of repetition
     */
    public ChronoUnit getFrequency() {
        // Renvoie la valeur de la frequence
        return myFrequency;   
    }

    @Override
    public boolean isInDay(LocalDate aDay){
        
        // J'ajoute l'équivalent en jour de ma durée a ma date de début pour ainsi avoir la date de fin
        LocalDate fin = myStart.plus(100,myFrequency).toLocalDate();
        LocalDate start = myStart.toLocalDate();
        if(exception.contains(aDay)){
            //Si la date est trouvée dans la collection "Exception" alors la methode renvoie False
            return false;
        }
        else{
            return aDay.isEqual(start) || aDay.isAfter(start) && aDay.isBefore(fin) || aDay.isEqual(fin);
        }
    }
    
}
