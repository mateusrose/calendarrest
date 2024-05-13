package io.mateusrosecode.model.calendar.model;

import jakarta.persistence.*;

import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "day")
public class Day {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int weekday;
    private int monthDay;
    private boolean canWork = true;
    @ManyToOne
    private Month month;

    @OneToMany(mappedBy = "day", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Half> halves = new LinkedList<>();

    public void setup(int i){
      monthDay = i;
      weekday = i%7 == 0 ? 7 : i%7;
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
