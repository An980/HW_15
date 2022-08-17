package ru.netology.repository;
import ru.netology.ticket.Ticket;

public class Repository {

    Ticket[] tickets = new Ticket[0];//пустой массив билетов

    public void saveTicket(Ticket ticket) {//добавить билет
        Ticket[] tmp = new Ticket[tickets.length + 1];
        for (int i = 0; i < tickets.length; i++) {
            tmp[i] = tickets[i];
        }
        tmp[tmp.length - 1] = ticket;
        tickets = tmp;
    }

    public void removeTicket(int id) {//удалить билет
        Ticket[] tmp = new Ticket[tickets.length - 1];
        int copyToIndex = 0;
        for (Ticket item : tickets) {
            if (item.getId() != id) {
                tmp[copyToIndex] = item;
                copyToIndex++;
            }
        }
        tickets = tmp;
    }

    public Ticket[] getTickets() {//список билетов
        return tickets;

    }

//    public Ticket findById(int id) {
//        for (Ticket tickets : tickets) {
//            if (tickets.getId() == id) {
//                return tickets;
//            }
//        }
//        return null;
//    }

}
