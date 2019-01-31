package domain;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Order {
    private int orderNr;
    private boolean isStudentOrder;

    private ArrayList<MovieTicket> tickets;

    public Order(int orderNr, boolean isStudentOrder) {
        this.orderNr = orderNr;
        this.isStudentOrder = isStudentOrder;

        tickets = new ArrayList<MovieTicket>();
    }

    public int getOrderNr() {
        return orderNr;
    }

    public void addSeatReservation(MovieTicket ticket) {
        tickets.add(ticket);
    }

    public double calculatePrice() {
        double price = 0;

        for (int i = 0; i < tickets.size(); i++) {
            price += tickets.get(i).getPrice();
            if(tickets.get(i).isPremiumTicket())
                if (isStudentOrder)
                    price += 2;
                else
                    price += 3;
            if ((isStudentOrder || tickets.get(i).isWeekDay()) && i % 2 == 0)
                i++;
        }

        if (!isStudentOrder && tickets.size() >= 6) {
            price *= 0.9;
        }

        return price;
    }

    public void export(TicketExportFormat exportFormat) {
        // Bases on the string respresentations of the tickets (toString), write
        // the ticket to a file with naming convention Order_<orderNr>.txt of
        // Order_<orderNr>.json
    }
}
