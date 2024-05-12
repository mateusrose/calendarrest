package io.mateusrosecode.model.calendar;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Day extends PanacheEntity {
    private int numberDay;
    private String weekDay;
    @ManyToOne
    public Month month;

    @OneToMany(mappedBy = "day")
    private List<Half> halfs;
}
