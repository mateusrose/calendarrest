package io.mateusrosecode.model.calendar.model;

import jakarta.persistence.*;

/**
 * The Half class represents a half-day period in the calendar system.
 * It is annotated with @Entity, indicating that it is a JPA entity.
 * The @Table annotation specifies the name of the database table to be used for mapping.
 */
@Entity
@Table(name = "half")
public class Half {

    /**
     * The ID of the half-day period. This field is automatically generated.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * The hour of the day that this half-day period starts.
     */
    private double hour;

    /**
     * The number of the half-day period within the day.
     */
    private int halfNumber;

    /**
     * The day that this half-day period belongs to. This field is a many-to-one relationship with the Day entity.
     */
    @ManyToOne
    private Day day;

    /**
     * A boolean indicating if the half-day period is occupied.
     */
    private boolean occupied;

    /**
     * The barber assigned to this half-day period. Defaults to "none".
     */
    private String barber = "none";

    /**
     * The client assigned to this half-day period. Defaults to "none".
     */
    private String client = "none";

    /**
     * Starting from 10AM, create half hour blocks.
     * It sets the halfNumber and hour based on the index.
     *
     * @param i The index used to initialize the half-day period.
     */
    public void setup(int i) {
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
