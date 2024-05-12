package io.mateusrosecode.model.calendar;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Year extends PanacheEntity {
    private int year;

    @OneToMany(mappedBy = "year")
    private List<Month> months;
}