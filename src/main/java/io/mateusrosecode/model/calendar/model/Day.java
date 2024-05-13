package io.mateusrosecode.model.calendar.model;

import jakarta.persistence.*;

@Entity
@Table(name = "day")
public class Day {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int weekday;
    private int monthDay;
    @ManyToOne
    private Month month;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeekday() {
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
}
