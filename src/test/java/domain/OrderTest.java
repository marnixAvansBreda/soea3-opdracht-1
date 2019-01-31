package domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class OrderTest {

    private Movie movie = new Movie("The Godfather");
    private LocalDateTime saturday = LocalDateTime.of(LocalDate.of(2019, 1, 26), LocalTime.of(0, 0));
    private LocalDateTime thursday = LocalDateTime.of(LocalDate.of(2019, 1, 31), LocalTime.of(0, 0));
    private MovieScreening msWeekday = new MovieScreening(movie, thursday, 9.0);
    private MovieScreening msWeekend = new MovieScreening(movie, saturday, 13);

    @Test
    public void calculatePriceTwoForOneOnWeekday()
    {
        Order orderForTwo = new Order(1, false);

        orderForTwo.addSeatReservation(new MovieTicket(msWeekday, false, 1, 1));
        orderForTwo.addSeatReservation(new MovieTicket(msWeekday, false, 1, 2));

        double price = orderForTwo.calculatePrice();

        assertEquals( 9.0, price, 0 );
    }

    @Test
    public void calculatePriceThreeForTwoOnWeekday()
    {
        Order orderForTwo = new Order(1, false);

        orderForTwo.addSeatReservation(new MovieTicket(msWeekday, false, 1, 1));
        orderForTwo.addSeatReservation(new MovieTicket(msWeekday, false, 1, 2));
        orderForTwo.addSeatReservation(new MovieTicket(msWeekday, false, 1, 3));

        double price = orderForTwo.calculatePrice();

        assertEquals( 18.0, price, 0 );
    }

    @Test
    public void calculatePriceStudentTwoForOne()
    {

        Order orderForTwo = new Order(1, true);

        orderForTwo.addSeatReservation(new MovieTicket(msWeekday, false, 1, 1));
        orderForTwo.addSeatReservation(new MovieTicket(msWeekday, false, 1, 2));

        double price = orderForTwo.calculatePrice();

        assertEquals( 9.0, price, 0 );
    }

    @Test
    public void calculatePriceStudentThreeForTwo()
    {
        Order orderForTwo = new Order(1, true);

        orderForTwo.addSeatReservation(new MovieTicket(msWeekday, false, 1, 1));
        orderForTwo.addSeatReservation(new MovieTicket(msWeekday, false, 1, 2));
        orderForTwo.addSeatReservation(new MovieTicket(msWeekday, false, 1, 3));

        double price = orderForTwo.calculatePrice();

        assertEquals( 18.0, price, 0 );
    }

    @Test
    public void calculatePriceForFiveOnWeekend()
    {
        Order orderForFive = new Order(1, false);

        orderForFive.addSeatReservation(new MovieTicket(msWeekend, false, 1, 1));
        orderForFive.addSeatReservation(new MovieTicket(msWeekend, false, 1, 2));
        orderForFive.addSeatReservation(new MovieTicket(msWeekend, false, 1, 3));
        orderForFive.addSeatReservation(new MovieTicket(msWeekend, false, 1, 4));
        orderForFive.addSeatReservation(new MovieTicket(msWeekend, false, 1, 5));

        double price = orderForFive.calculatePrice();

        assertEquals( 65, price, 0 );
    }

    @Test
    public void calculatePriceForSixOnWeekend()
    {
        Order orderForFive = new Order(1, false);

        orderForFive.addSeatReservation(new MovieTicket(msWeekend, false, 1, 1));
        orderForFive.addSeatReservation(new MovieTicket(msWeekend, false, 1, 2));
        orderForFive.addSeatReservation(new MovieTicket(msWeekend, false, 1, 3));
        orderForFive.addSeatReservation(new MovieTicket(msWeekend, false, 1, 4));
        orderForFive.addSeatReservation(new MovieTicket(msWeekend, false, 1, 5));
        orderForFive.addSeatReservation(new MovieTicket(msWeekend, false, 1, 6));

        double price = orderForFive.calculatePrice();

        assertEquals( 70.2, price, 0 );
    }

    @Test
    public void calculatePriceForSevenOnWeekend()
    {
        Order orderForFive = new Order(1, false);

        orderForFive.addSeatReservation(new MovieTicket(msWeekend, false, 1, 1));
        orderForFive.addSeatReservation(new MovieTicket(msWeekend, false, 1, 2));
        orderForFive.addSeatReservation(new MovieTicket(msWeekend, false, 1, 3));
        orderForFive.addSeatReservation(new MovieTicket(msWeekend, false, 1, 4));
        orderForFive.addSeatReservation(new MovieTicket(msWeekend, false, 1, 5));
        orderForFive.addSeatReservation(new MovieTicket(msWeekend, false, 1, 6));
        orderForFive.addSeatReservation(new MovieTicket(msWeekend, false, 1, 7));

        double price = orderForFive.calculatePrice();

        assertEquals( 81.9, price, 0 );
    }
    @Test
    public void calculatePriceTwoForOneOnWeekdayPremium()
    {
        Order orderForTwo = new Order(1, false);

        orderForTwo.addSeatReservation(new MovieTicket(msWeekday, true, 1, 1));
        orderForTwo.addSeatReservation(new MovieTicket(msWeekday, true, 1, 2));

        double price = orderForTwo.calculatePrice();

        assertEquals( 12, price, 0 );
    }

    @Test
    public void calculatePriceThreeForTwoOnWeekdayPremium()
    {
        Order orderForTwo = new Order(1, false);

        orderForTwo.addSeatReservation(new MovieTicket(msWeekday, true, 1, 1));
        orderForTwo.addSeatReservation(new MovieTicket(msWeekday, true, 1, 2));
        orderForTwo.addSeatReservation(new MovieTicket(msWeekday, true, 1, 3));

        double price = orderForTwo.calculatePrice();

        assertEquals( 24, price, 0 );
    }

    @Test
    public void calculatePriceStudentTwoForOnePremium()
    {

        Order orderForTwo = new Order(1, true);

        orderForTwo.addSeatReservation(new MovieTicket(msWeekday, true, 1, 1));
        orderForTwo.addSeatReservation(new MovieTicket(msWeekday, true, 1, 2));

        double price = orderForTwo.calculatePrice();

        assertEquals( 11, price, 0 );
    }

    @Test
    public void calculatePriceStudentThreeForTwoPremium()
    {
        Order orderForTwo = new Order(1, true);

        orderForTwo.addSeatReservation(new MovieTicket(msWeekday, true, 1, 1));
        orderForTwo.addSeatReservation(new MovieTicket(msWeekday, true, 1, 2));
        orderForTwo.addSeatReservation(new MovieTicket(msWeekday, true, 1, 3));

        double price = orderForTwo.calculatePrice();

        assertEquals( 22, price, 0 );
    }

    @Test
    public void calculatePriceForFiveOnWeekendPremium()
    {
        Order orderForFive = new Order(1, false);

        orderForFive.addSeatReservation(new MovieTicket(msWeekend, true, 1, 1));
        orderForFive.addSeatReservation(new MovieTicket(msWeekend, true, 1, 2));
        orderForFive.addSeatReservation(new MovieTicket(msWeekend, true, 1, 3));
        orderForFive.addSeatReservation(new MovieTicket(msWeekend, true, 1, 4));
        orderForFive.addSeatReservation(new MovieTicket(msWeekend, true, 1, 5));

        double price = orderForFive.calculatePrice();

        assertEquals( 80, price, 0 );
    }

    @Test
    public void calculatePriceForSixOnWeekendPremium()
    {
        Order orderForFive = new Order(1, false);

        orderForFive.addSeatReservation(new MovieTicket(msWeekend, true, 1, 1));
        orderForFive.addSeatReservation(new MovieTicket(msWeekend, true, 1, 2));
        orderForFive.addSeatReservation(new MovieTicket(msWeekend, true, 1, 3));
        orderForFive.addSeatReservation(new MovieTicket(msWeekend, true, 1, 4));
        orderForFive.addSeatReservation(new MovieTicket(msWeekend, true, 1, 5));
        orderForFive.addSeatReservation(new MovieTicket(msWeekend, true, 1, 6));

        double price = orderForFive.calculatePrice();

        assertEquals( 86.4, price, 0 );
    }

    @Test
    public void calculatePriceForSevenOnWeekendPremium()
    {
        Order orderForFive = new Order(1, false);

        orderForFive.addSeatReservation(new MovieTicket(msWeekend, true, 1, 1));
        orderForFive.addSeatReservation(new MovieTicket(msWeekend, true, 1, 2));
        orderForFive.addSeatReservation(new MovieTicket(msWeekend, true, 1, 3));
        orderForFive.addSeatReservation(new MovieTicket(msWeekend, true, 1, 4));
        orderForFive.addSeatReservation(new MovieTicket(msWeekend, true, 1, 5));
        orderForFive.addSeatReservation(new MovieTicket(msWeekend, true, 1, 6));
        orderForFive.addSeatReservation(new MovieTicket(msWeekend, true, 1, 7));

        double price = orderForFive.calculatePrice();

        assertEquals( 100.8, price, 0 );
    }

    @Test
    public void calculatePricePremiumMix()
    {
        Order orderForFive = new Order(1, false);

        orderForFive.addSeatReservation(new MovieTicket(msWeekend, false, 1, 1));
        orderForFive.addSeatReservation(new MovieTicket(msWeekend, false, 1, 2));
        orderForFive.addSeatReservation(new MovieTicket(msWeekend, true, 1, 3));
        orderForFive.addSeatReservation(new MovieTicket(msWeekend, true, 1, 4));

        double price = orderForFive.calculatePrice();

        assertEquals( 58, price, 0 );
    }
}
