package io.mateusrosecode.model.calendar;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.LinkedList;
import java.util.List;

@Entity
public class Year extends PanacheEntity {
    private int year;
//  PLS INSTANTIATE EVERY LIST
    @OneToMany(mappedBy = "year")
    private List<Month> months;
    public Year() {
        this.months = new LinkedList<>();
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<Month> getMonths() {
        return months;
    }

    public void setMonths(List<Month> months) {
        this.months = months;
    }
}