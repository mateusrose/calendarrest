package io.mateusrosecode.model.calendar;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.LinkedList;
import java.util.List;

@Entity
public class Day extends PanacheEntity {
    private int numberDay;
    private String weekDay;
    @ManyToOne
    private Month month;

    @OneToMany(mappedBy = "day")
    private List<Half> halfs;

    public Day() {
        this.halfs = new LinkedList<>();
    }

    public int getNumberDay() {
        return numberDay;
    }

    public void setNumberDay(int numberDay) {
        this.numberDay = numberDay;
    }

    public String getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(String weekDay) {
        this.weekDay = weekDay;
    }

    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }

    public List<Half> getHalfs() {
        return halfs;
    }

    public void setHalfs(List<Half> halfs) {
        this.halfs = halfs;
    }
}
