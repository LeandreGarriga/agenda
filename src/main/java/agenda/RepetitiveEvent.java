package agenda;

import java.util.*;
import java.time.*;
import java.time.temporal.ChronoUnit;

/**
 * Description : A repetitive Event
 */
public class RepetitiveEvent extends Event {
    
    ChronoUnit frequency;
    LocalDateTime repetition;
    LocalDateTime finT;
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
        // TODO : implémenter cette méthode
        this.myTitle = title;
        this.myStart = start;
        this.myDuration = duration;
        this.frequency=frequency;
        this.repetition=start.plus(1, frequency);
        //throw new UnsupportedOperationException("Pas encore implémenté");
    }

    /**
     * Adds an exception to the occurrence of this repetitive event
     *
     * @param date the event will not occur at this date
     */
    public void addException(LocalDate date) {
        // TODO : implémenter cette méthode
        finT=myStart.plus(myDuration);
        long j = ChronoUnit.DAYS.between(date, finT);
        LocalDateTime finIntermediare;
        //finT.minus(date);
        //throw new UnsupportedOperationException("Pas encore implémenté");
    }

    /**
     *
     * @return the type of repetition
     */
    public ChronoUnit getFrequency() {
        // Renvoie la valeur de la frequence
        return frequency;   
    }

}
