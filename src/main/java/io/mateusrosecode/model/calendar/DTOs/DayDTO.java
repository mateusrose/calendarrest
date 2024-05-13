package io.mateusrosecode.model.calendar.DTOs;

public class DayDTO {
    private String name;
    private int weekDay;
    private int monthDay;
    private int reservations;
    private int freeSpot;
    private int month;
    private String monthName;
    private int year;


    public DayDTO() {
    }

    public DayDTO(String name, int weekDay, int monthDay, int reservations, int freeSpot, int month, String monthName, int year) {
        this.name = name;
        this.weekDay = weekDay;
        this.monthDay = monthDay;
        this.reservations = reservations;
        this.freeSpot = freeSpot;
        this.month = month;
        this.monthName = monthName;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(int weekDay) {
        this.weekDay = weekDay;
    }

    public int getMonthDay() {
        return monthDay;
    }

    public void setMonthDay(int monthDay) {
        this.monthDay = monthDay;
    }

    public int getReservations() {
        return reservations;
    }

    public void setReservations(int reservations) {
        this.reservations = reservations;
    }

    public int getFreeSpot() {
        return freeSpot;
    }

    public void setFreeSpot(int freeSpot) {
        this.freeSpot = freeSpot;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public String getMonthName() {
        return monthName;
    }

    public void setMonthName(String monthName) {
        this.monthName = monthName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
