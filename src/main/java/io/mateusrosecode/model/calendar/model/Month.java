package io.mateusrosecode.model.calendar.model;

import jakarta.persistence.*;

import java.util.LinkedList;
import java.util.List;

/**
 * The Month class represents a month in the calendar system.
 * It is annotated with @Entity, indicating that it is a JPA entity.
 * The @Table annotation specifies the name of the database table to be used for mapping.
 */
@Entity
@Table(name = "month")
public class Month {
    /**
     * The ID of the month. This field is automatically generated.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * The name of the month.
     */
    private String name;

    /**
     * The number of the month.
     */
    private int monthNumber;

    /**
     * The year that this month belongs to. This field is a many-to-one relationship with the Year entity.
     */
    @ManyToOne
    private Year year;

    /**
     * The days of the month. This field is a one-to-many relationship with the Day entity.
     */
    @OneToMany(mappedBy = "month", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Day> days = new LinkedList<>();

    /**
     * The setName method sets the name and number of the month based on a given index.
     * It uses a switch statement to assign the correct name and number to the month.
     *
     * @param i The index used to set the name and number of the month.
     */
    public void setName(int i) {
        switch ((i % 12)) {
            case 1:
                name = "january";
                monthNumber = 1;
                break;
            case 2:
                name = "february";
                monthNumber = 2;
                break;
            case 3:
                name = "march";
                monthNumber = 3;
                break;
            case 4:
                name = "april";
                monthNumber = 4;
                break;
            case 5:
                name = "may";
                monthNumber = 5;
                break;
            case 6:
                name = "june";
                monthNumber = 6;
                break;
            case 7:
                name = "july";
                monthNumber = 7;
                break;
            case 8:
                name = "august";
                monthNumber = 8;
                break;
            case 9:
                name = "september";
                monthNumber = 9;
                break;
            case 10:
                name = "october";
                monthNumber = 10;
                break;
            case 11:
                name = "november";
                monthNumber = 11;
                break;
            case 0:
                name = "december";
                monthNumber = 12;
                break;
        }
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    public List<Day> getDays() {
        return days;
    }

    public int getMonthNumber() {
        return monthNumber;
    }
}
