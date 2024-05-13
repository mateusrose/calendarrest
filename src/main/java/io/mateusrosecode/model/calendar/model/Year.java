package io.mateusrosecode.model.calendar.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;

import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "year")
public class Year {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int year;
    @OneToMany(mappedBy = "year", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Month> months = new LinkedList<>();

    public Year() {
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
       this.year=year;
    }

    public long getId() {
        return id;
    }

    public List<Month> getMonths() {
        return months;
    }
}