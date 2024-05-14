package io.mateusrosecode.model.calendar.DTOs;

/**
 * The DayDTO class represents a Data Transfer Object for the Day entity.
 * It is used to transfer data between processes or components, in this case, related to a Day.
 */
public class DayDTO {

    // The name of the day
    private String name;
    // The weekday number
    private int weekDay;
    // The day of the month
    private int monthDay;
    // The number of reservations for the day
    private int reservations;
    // The number of free spots for the day
    private int freeSpot;
    // The month number
    private int month;
    // The name of the month
    private String monthName;
    // The year
    private int year;
    // A boolean indicating if work is possible on the day
    private boolean canWork;

    public DayDTO() {
    }


    public DayDTO(String name, int weekDay, int monthDay, int reservations, int freeSpot, int month, String monthName, int year, boolean canWork) {
        this.name = name;
        this.weekDay = weekDay;
        this.monthDay = monthDay;
        this.reservations = reservations;
        this.freeSpot = freeSpot;
        this.month = month;
        this.monthName = monthName;
        this.year = year;
        this.canWork = canWork;
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
