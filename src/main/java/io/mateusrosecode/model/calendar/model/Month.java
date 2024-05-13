package io.mateusrosecode.model.calendar.model;

import jakarta.persistence.*;

import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "month")
public class Month {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int monthNumber;
    @ManyToOne
    private Year year;

    @OneToMany(mappedBy = "month", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Day> days = new LinkedList<>();

    public void setName(int i) {
        switch ((i%12)) {
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
