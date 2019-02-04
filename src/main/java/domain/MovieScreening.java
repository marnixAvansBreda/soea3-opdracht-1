package domain;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class MovieScreening
{
    private Movie movie;

    private LocalDateTime dateAndTime;
    private double pricePerSeat;

    public MovieScreening(Movie movie, LocalDateTime dateAndTime, double pricePerSeat)
    {
        this.movie = movie;
        movie.addScreening(this);

        this.dateAndTime = dateAndTime;
        this.pricePerSeat = pricePerSeat;
    }

    public double getPricePerSeat()
    {
        return pricePerSeat;
    }

    public boolean isWeekDay() {
        return dateAndTime.getDayOfWeek() == DayOfWeek.MONDAY ||
                dateAndTime.getDayOfWeek() == DayOfWeek.TUESDAY ||
                dateAndTime.getDayOfWeek() == DayOfWeek.WEDNESDAY ||
                dateAndTime.getDayOfWeek() == DayOfWeek.THURSDAY;
    }

    @Override
    public String toString() {
        return movie.getTitle() + " - " + dateAndTime;
    }
}
