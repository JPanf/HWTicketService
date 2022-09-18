package ru.netology.TicketService.service;

import java.util.Arrays;

public class TicketManager {
    protected TicketRepository repo;

    public TicketManager(TicketRepository repo) {
        this.repo = repo;
    }

    public void addNewTicket(Ticket ticket) {
        repo.addTicket(ticket);
    }

    public boolean matches(Ticket ticket, String from, String to) {
        if (ticket.getOrigin().contains(from) && ticket.getDestination().contains(to)) {
            return true;
        } else {
            return false;
        }
    }

    public Ticket[] findAll(String from, String to) {
        Ticket[] condTickets = new Ticket[0];
        for (Ticket ticket : repo.getTickets()) {
            if (matches(ticket, from, to)) {
                Ticket[] cond = new Ticket[condTickets.length + 1];
                for (int i = 0; i < condTickets.length; i++) {
                    cond[i] = condTickets[i];
                }
                cond[cond.length - 1] = ticket;
                condTickets = cond;
            }
        }
        Arrays.sort(condTickets);
        return condTickets;
    }
}
