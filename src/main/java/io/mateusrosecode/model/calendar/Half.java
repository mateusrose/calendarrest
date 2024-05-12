package io.mateusrosecode.model.calendar;

import io.mateusrosecode.model.calendar.Day;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Half extends PanacheEntity {
    private String name;
    private boolean occupied;
    private int number;
    @ManyToOne
    private Day day;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }
}
