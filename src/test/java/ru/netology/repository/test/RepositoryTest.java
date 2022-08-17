package ru.netology.repository.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.repository.Repository;
import ru.netology.ticket.Ticket;

public class RepositoryTest {

    Repository repo = new Repository();
    Ticket t1 = new Ticket(101, 15999, "AAN", "MSK", 11);
    Ticket t2 = new Ticket(102, 11999, "DME", "AAA", 14);
    Ticket t3 = new Ticket(203, 45999, "LED", "PAD", 8);
    Ticket t4 = new Ticket(204, 17999, "LAM", "HBH", 7);
    Ticket t5 = new Ticket(305, 11999, "HEZ", "ZAR", 5);
    Ticket t6 = new Ticket(306, 23999, "RCN", "OBX", 4);
    Ticket t7 = new Ticket(407, 10999, "LON", "MSK", 9);
    Ticket t8 = new Ticket(408, 14999, "ZGS", "LCA", 11);

    @BeforeEach
    public void setTicket() {
        repo.saveTicket(t1);
        repo.saveTicket(t2);
        repo.saveTicket(t3);
        repo.saveTicket(t4);
        repo.saveTicket(t5);
        repo.saveTicket(t6);
        repo.saveTicket(t7);
        repo.saveTicket(t8);

    }

    @Test
    public void saveMayTicket() {

        Ticket[] expected = {t1, t2, t3, t4, t5, t6, t7, t8};
        Ticket[] actual = repo.getTickets();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void addNewTicket() {

        Ticket t9 = new Ticket(999, 11999, "KAR", "TSH", 3);
        repo.saveTicket(t9);

        Ticket[] expected = {t1, t2, t3, t4, t5, t6, t7, t8, t9};
        Ticket[] actual = repo.getTickets();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void removeTicketById() {

        repo.removeTicket(t2.getId());
        repo.removeTicket(t5.getId());

        Ticket[] expected = {t1, t3, t4, t6, t7, t8};
        Ticket[] actual = repo.getTickets();

        Assertions.assertArrayEquals(expected, actual);

    }

}
