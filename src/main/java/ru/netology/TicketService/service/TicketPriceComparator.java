package ru.netology.TicketService.service;
import java.util.Comparator;

public class TicketPriceComparator implements Comparator<Ticket> {
    @Override
    public int compare(Ticket o1, Ticket o2) {
        if (o1.ticketPrice< o2.ticketPrice) {
            return -1;
        } else if (o1.ticketPrice < o2.ticketPrice) {
            return 1;
        } else {
            return 0;
        }
    }
}
