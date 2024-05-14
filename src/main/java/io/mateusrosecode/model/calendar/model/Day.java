package io.mateusrosecode.model.calendar.model;

import jakarta.persistence.*;

import java.util.LinkedList;
import java.util.List;

/**
 * The Day class represents a day in the calendar system.
 * It is annotated with @Entity, indicating that it is a JPA entity.
 * The @Table annotation specifies the name of the database table to be used for mapping.
 */
@Entity
@Table(name = "day")
public class Day {

    /**
     * The ID of the day. This field is automatically generated.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * The name of the day.
     */
    private String name;

    /**
     * The weekday number.
     */
    private int weekday;

    /**
     * The day of the month.
     */
    private int monthDay;

    /**
     * A boolean indicating if work is possible on the day.
     */
    private boolean canWork = true;

    /**
     * The month of the day. This field is a many-to-one relationship with the Month entity.
     */
    @ManyToOne
    private Month month;

    /**
     * The halves of the day. This field is a one-to-many relationship with the Half entity.
     */
    @OneToMany(mappedBy = "day", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Half> halves = new LinkedList<>();

    /**
     * The setup method initializes the day with a given index.
     * It sets the monthDay and weekday based on the index, and assigns a name to the day based on the weekday.
     *
     * @param i The index used to initialize the day.
     */
    public void setup(int i) {
        monthDay = i;
        weekday = i % 7 == 0 ? 7 : i % 7;
        name = switch (weekday) {
            case 7 -> "sunday";
            case 1 -> "monday";
            case 2 -> "tuesday";
            case 3 -> "wednesday";
            case 4 -> "thursday";
            case 5 -> "friday";
            case 6 -> "saturday";
            default -> "error";
        };
    }


    public boolean isCanWork() {
        return canWork;
    }

    public void setCanWork(boolean canWork) {
        this.canWork = canWork;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getWeekday() {
        return weekday;
    }

    public void setHalves(List<Half> halves) {
        this.halves = halves;
    }

    public int getWeekDay() {
        return weekday;
    }

    public void setWeekday(int weekday) {
        this.weekday = weekday;
    }

    public int getMonthDay() {
        return monthDay;
    }

    public void setMonthDay(int monthDay) {
        this.monthDay = monthDay;
    }

    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }

    public List<Half> getHalves() {
        return halves;
    }
}
