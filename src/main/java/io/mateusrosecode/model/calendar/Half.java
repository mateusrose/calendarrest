package io.mateusrosecode.model.calendar;

import io.mateusrosecode.model.calendar.Day;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Half extends PanacheEntity {
    private String name;
    public boolean occupied;
    @ManyToOne
    public Day day;
}
