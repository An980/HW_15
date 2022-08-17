package ru.netology.manager.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.manager.Manager;
import ru.netology.repository.Repository;
import ru.netology.ticket.Ticket;

import java.util.Arrays;

public class ManagerTest {

    Repository repo = new Repository();
    Manager man = new Manager(repo);

    Ticket t1 = new Ticket(101, 13999, "AAN", "MSK", 11);
    Ticket t2 = new Ticket(102, 12999, "QSM", "POL", 14);
    Ticket t3 = new Ticket(203, 11999, "QSM", "POL", 8);
    Ticket t4 = new Ticket(204, 10999, "LAM", "HBH", 7);
    Ticket t5 = new Ticket(305, 18999, "QSM", "POL", 5);
    Ticket t6 = new Ticket(306, 17999, "RCN", "OBX", 4);
    Ticket t7 = new Ticket(407, 16999, "LON", "MSK", 9);
    Ticket t8 = new Ticket(408, 15999, "AAN", "LCA", 11);

//    @BeforeEach
//    public void setTicket() {
//        man.addTicket(t1);
//        man.addTicket(t2);
//        man.addTicket(t3);
//        man.addTicket(t4);
//        man.addTicket(t5);
//        man.addTicket(t6);
//        man.addTicket(t7);
//        man.addTicket(t8);
//    }

    @Test
    public void getAllTickets() {
        man.addTicket(t1);
        man.addTicket(t2);
        man.addTicket(t3);
        man.addTicket(t4);
        man.addTicket(t5);
        man.addTicket(t6);
        man.addTicket(t7);
        man.addTicket(t8);

        Ticket[] expected = {t1, t2, t3, t4, t5, t6, t7, t8};
        Ticket[] actual = man.getAllTickets();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void getAllNoParams() {

        Ticket[] expected = {};
        Ticket[] actual = man.findAll("", "");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void getAllNoParamsM() {

        Ticket[] expected = {};
        Ticket[] actual = man.getAllTickets();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void getAllTicketsAndNew() {
        man.addTicket(t1);
        man.addTicket(t2);
        man.addTicket(t3);
        man.addTicket(t4);
        man.addTicket(t5);
        man.addTicket(t6);
        man.addTicket(t7);
        man.addTicket(t8);
        Ticket t9 = new Ticket(501, 5999, "ARM", "NRL", 2);
        man.addTicket(t9);

        Ticket[] expected = {t1, t2, t3, t4, t5, t6, t7, t8, t9};
        Ticket[] actual = man.getAllTickets();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchNewTicket() {
        man.addTicket(t1);
        man.addTicket(t2);
        man.addTicket(t3);
        man.addTicket(t4);
        man.addTicket(t5);
        man.addTicket(t6);
        man.addTicket(t7);
        man.addTicket(t8);
        Ticket t9 = new Ticket(501, 5999, "ARM", "NRL", 2);
        man.addTicket(t9);

        Ticket[] expected = {t9};
        Ticket[] actual = man.findAll("ARM", "NRL");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByOneTicket() {
        man.addTicket(t1);
        man.addTicket(t2);
        man.addTicket(t3);
        man.addTicket(t4);
        man.addTicket(t5);
        man.addTicket(t6);
        man.addTicket(t7);
        man.addTicket(t8);

        Ticket[] expected = {t7};
        Ticket[] actual = man.findAll("LON", "MSK");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByDeparture() {
        man.addTicket(t1);
        man.addTicket(t2);
        man.addTicket(t3);
        man.addTicket(t4);
        man.addTicket(t5);
        man.addTicket(t6);
        man.addTicket(t7);
        man.addTicket(t8);

        Ticket[] expected = {};
        Ticket[] actual = man.findAll("LON", "BAZ");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByArrival() {
        man.addTicket(t1);
        man.addTicket(t2);
        man.addTicket(t3);
        man.addTicket(t4);
        man.addTicket(t5);
        man.addTicket(t6);
        man.addTicket(t7);
        man.addTicket(t8);

        Ticket[] expected = {};
        Ticket[] actual = man.findAll("BAZ", "MSK");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByNegative() {
        man.addTicket(t1);
        man.addTicket(t2);
        man.addTicket(t3);
        man.addTicket(t4);
        man.addTicket(t5);
        man.addTicket(t6);
        man.addTicket(t7);
        man.addTicket(t8);

        Ticket[] expected = {};
        Ticket[] actual = man.findAll("BAZ", "BAZ");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByNegativeEmpty() {

        Ticket[] expected = {};
        Ticket[] actual = man.findAll("BAZ", "BAZ");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchByEmpty() {

        Ticket[] expected = {};
        Ticket[] actual = man.findAll("", "");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void sortByPriceLowToHigh() {
        man.addTicket(t1);
        man.addTicket(t2);
        man.addTicket(t3);
        man.addTicket(t4);
        man.addTicket(t5);
        man.addTicket(t6);
        man.addTicket(t7);
        man.addTicket(t8);

        Ticket[] expected = new Ticket[]{t4, t3, t2, t1, t8, t7, t6, t5};
        Ticket[] actual = repo.getTickets();
        Arrays.sort(actual);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void sortByPriceAddNew() {
        man.addTicket(t1);
        man.addTicket(t2);
        man.addTicket(t3);
        man.addTicket(t4);
        man.addTicket(t5);
        man.addTicket(t6);
        man.addTicket(t7);
        man.addTicket(t8);
        Ticket t9 = new Ticket(501, 5999, "ARM", "NRL", 2);
        man.addTicket(t9);

        Ticket[] expected = new Ticket[]{t9, t4, t3, t2, t1, t8, t7, t6, t5};
        Ticket[] actual = repo.getTickets();
        Arrays.sort(actual);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void sortByEqualPrice() {
        man.addTicket(t1);
        man.addTicket(t2);
        man.addTicket(t3);
        man.addTicket(t4);
        man.addTicket(t5);
        man.addTicket(t6);
        man.addTicket(t7);
        man.addTicket(t8);

        Ticket t9 = new Ticket(501, 0, "ARM", "NRL", 2);
        man.addTicket(t9);
        Ticket t10 = new Ticket(501, 0, "ARM", "NRL", 2);
        man.addTicket(t10);

        Ticket[] expected = new Ticket[]{t9, t10, t4, t3, t2, t1, t8, t7, t6, t5};
        Ticket[] actual = repo.getTickets();
        Arrays.sort(actual);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void findEqualTicketSortByPrice() {
        man.addTicket(t1);
        man.addTicket(t2);
        man.addTicket(t3);
        man.addTicket(t4);
        man.addTicket(t5);
        man.addTicket(t6);

        Ticket[] expected = {t3, t2, t5};
        Ticket[] actual = man.findAll("QSM", "POL");
        Assertions.assertArrayEquals(expected, actual);
    }


    //============================


}
