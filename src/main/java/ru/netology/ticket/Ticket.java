package ru.netology.ticket;

public class Ticket implements Comparable<Ticket> {

    protected int id;
    protected int price;
    protected String departure;
    protected String arrival;
    protected int flyTime;

    public Ticket(int id, int price, String departure, String arrival, int flyTime) {
        this.id = id;
        this.price = price;
        this.departure = departure;
        this.arrival = arrival;
        this.flyTime = flyTime;
    }

    public int getId() {
        return id;
    }

//    public void setId(int id) {
//        this.id = id;
//    }

    public int getPrice() {
        return price;
    }

//    public void setPrice(int price) {
//        this.price = price;
//    }

    public String getDeparture() {
        return departure;
    }

//    public void setDeparture(String departure) {
//        this.departure = departure;
//    }

    public String getArrival() {
        return arrival;
    }

//    public void setArrival(String arrival) {
//        this.arrival = arrival;
//    }
//
//    public int getFlyTime() {
//        return flyTime;
//    }
//
//    public void setFlyTime(int flyTime) {
//        this.flyTime = flyTime;
//    }

    @Override
    public int compareTo(Ticket o) {
        if (this.price < o.getPrice()) {
            return -1;
        }
        if (this.price > o.getPrice()) {
            return 1;
        } else {
            return 0;
        }
    }
}
