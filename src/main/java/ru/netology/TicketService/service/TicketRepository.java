package ru.netology.TicketService.service;

import java.util.Arrays;
import java.util.Objects;

public class TicketRepository {
    protected Ticket[] tickets = new Ticket[0];

    public TicketRepository(Ticket[] tickets) {
        this.tickets = tickets;
    }

    public TicketRepository() {

    }

    public Ticket[] getTickets() {
        Arrays.sort(tickets);
        return tickets;
    }

    public void setTickets(Ticket[] tickets) {
        this.tickets = tickets;
    }

    public void addTicket(Ticket ticket) {
        Ticket[] tickets1 = new Ticket[tickets.length + 1];
        for (int i = 0; i < tickets.length; i++) {
            tickets1[i] = tickets[i];
        }
        tickets1[tickets1.length - 1] = ticket;
        tickets = tickets1;
    }

    public Ticket findById(int id) {
        for (Ticket ticket : tickets) {
            if (ticket.getTicketId() == id) {
                return ticket;
            }
        }
        return null;
    }

    public void removeById(int id) {
        Ticket[] tmp = new Ticket[tickets.length - 1];
        int index = 0;
        for (Ticket ticket1 : tickets) {
            if (ticket1.getTicketId() != id) {
                tmp[index] = ticket1;
                index++;
            }
        }
        tickets = tmp;
    }

}
