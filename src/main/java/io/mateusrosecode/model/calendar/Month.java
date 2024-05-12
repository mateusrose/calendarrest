package io.mateusrosecode.model.calendar;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Month extends PanacheEntity {
    private String name;
    private int number;

    @ManyToOne
    public Year year;
    @OneToMany(mappedBy = "month")
    private List<Day> days;
}
