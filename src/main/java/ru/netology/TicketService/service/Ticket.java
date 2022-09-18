package ru.netology.TicketService.service;

public class Ticket implements Comparable<Ticket> {
    protected int ticketId;
    protected int ticketPrice;
    protected String origin;
    protected String destination;
    protected int flightTime;

    public Ticket(int ticketId, int ticketPrice, String origin, String destination, int flightTime) {
        this.ticketId = ticketId;
        this.ticketPrice = ticketPrice;
        this.origin = origin;
        this.destination = destination;
        this.flightTime = flightTime;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(int flightTime) {
        this.flightTime = flightTime;
    }

    @Override
    public int compareTo(Ticket o) {
        if (this.ticketPrice < o.ticketPrice) {
            return -1;
        } else if (this.ticketPrice > o.ticketPrice) {
            return 1;
        } else {
            return 0;
        }
    }
}
