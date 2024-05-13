package io.mateusrosecode.model.calendar.model;

import jakarta.persistence.*;

@Entity
@Table(name = "half")
public class Half {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double hour;
    private int halfNumber;
    @ManyToOne
    private Day day;
    private boolean occupied;
    private String barber = "none";
    private String client = "none";

    public void setup(int i){
        this.halfNumber = i;
        this.hour = 10 + (i * 0.5) - 0.5;
    }

    public double getHour() {
        return hour;
    }

    public void setHour(double hour) {
        this.hour = hour;
    }

    public int getHalfNumber() {
        return halfNumber;
    }

    public void setHalfNumber(int halfNumber) {
        this.halfNumber = halfNumber;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBarber() {
        return barber;
    }

    public void setBarber(String barber) {
        this.barber = barber;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }
}
