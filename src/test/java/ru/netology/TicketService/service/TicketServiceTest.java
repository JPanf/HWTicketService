package ru.netology.TicketService.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TicketServiceTest {
    TicketRepository repo = new TicketRepository();

    TicketManager manager = new TicketManager(repo);

    Ticket ticket1 = new Ticket(1, 5000, "LED", "SVO", 45);
    Ticket ticket2 = new Ticket(2, 4500, "LED", "SVO", 55);
    Ticket ticket3 = new Ticket(3, 80000, "SVO", "HEL", 45);
    Ticket ticket4 = new Ticket(4, 15000, "LED", "DXB", 300);
    Ticket ticket5 = new Ticket(5, 500, "LED", "SVO", 45);

    @BeforeEach
    public void setup() {
        manager.addNewTicket(ticket1);
        manager.addNewTicket(ticket2);
        manager.addNewTicket(ticket3);
        manager.addNewTicket(ticket4);
        manager.addNewTicket(ticket5);
    }

    @Test
    public void shouldSortAllAddedTickets() {
        Ticket[] actual = repo.getTickets();
        Ticket[] expected = {ticket5, ticket2, ticket1, ticket4, ticket3};

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldAddNewTicketAndSort() {
        Ticket ticket6 = new Ticket(6, 10000, "SVO", "LED", 60);
        manager.addNewTicket(ticket6);

        Ticket[] actual = repo.getTickets();
        Ticket[] expected = {ticket5, ticket2, ticket1, ticket6, ticket4, ticket3};

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldRemoveByIdAnSort() {
        repo.removeById(4);

        Ticket[] actual = repo.getTickets();
        Ticket[] expected = {ticket5, ticket2, ticket1, ticket3};
        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldFindOneTicket() {

        Ticket[] actual = manager.findAll("LED", "DXB");
        Ticket[] expected = {ticket4};
        Assertions.assertArrayEquals(actual, expected);

    }

    @Test
    public void shouldFindAndSortAllEqualTickets() {

        Ticket[] actual = manager.findAll("LED", "SVO");
        Ticket[] expected = {ticket5, ticket2, ticket1};
        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldNotFindOutOfConditionTicket() {

        Ticket[] actual = manager.findAll("LED", "MOW");
        Ticket[] expected = {};
        Assertions.assertArrayEquals(actual, expected);
    }
}

