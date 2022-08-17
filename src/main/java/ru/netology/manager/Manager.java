package ru.netology.manager;

import ru.netology.repository.Repository;
import ru.netology.ticket.Ticket;

import java.util.Arrays;

public class Manager {

    Repository repo = new Repository();

    public Manager(Repository repo) {
        this.repo = repo;
    }

    public void addTicket(Ticket ticket) {
        repo.saveTicket(ticket);
    }

    public Ticket[] getAllTickets() {
        return repo.getTickets();
    }

    public Ticket[] findAll(String from, String to) {//принял from и to из ticket
        Ticket[] result = new Ticket[0];//пустой массив для хранения результата
        for (Ticket ticket : repo.getTickets()) {
            if (matches(ticket, from, to)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = ticket;
                result = tmp;

            }
            Arrays.sort(result);

        }
        return result;
    }

//    public boolean matches(Ticket ticket, String from, String to) {
//        if (ticket.getDeparture().contains(from)) {
//            return true;
//        }
//        if (ticket.getArrival().contains(to)) {
//            return true;
//        } else {
//            return false;
//        }
//    }

    public boolean matches(Ticket ticket, String from, String to) {

        if (ticket.getDeparture().contains(from)) {
            if (ticket.getArrival().contains(to)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

}


