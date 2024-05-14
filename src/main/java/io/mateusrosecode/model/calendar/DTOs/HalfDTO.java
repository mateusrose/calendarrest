package io.mateusrosecode.model.calendar.DTOs;

/**
 * The HalfDTO class represents a Data Transfer Object for the Half entity.
 * It is used to transfer data between processes or components, in this case, related to a Half.
 */
public class HalfDTO {

    // The hour of the half
    private double hour;
    // The half number
    private int halfNumber;
    // A boolean indicating if the half is occupied
    private boolean occupied;
    // The weekday name
    private String weekDay;
    // The day of the month
    private int monthDay;
    // The name of the month
    private String monthName;
    // The month number
    private int month;
    // The year
    private int year;
    // The barber's name
    private String barber;
    // The client's name
    private String client;

    public HalfDTO() {
    }

    public HalfDTO(double hour, int halfNumber, boolean occupied, String weekDay, String monthName, int monthDay, int month, int year, String barber, String client) {
        this.hour = hour;
        this.halfNumber = halfNumber;
        this.occupied = occupied;
        this.weekDay = weekDay;
        this.monthName=monthName;
        this.monthDay = monthDay;
        this.month = month;
        this.year = year;
        this.barber = barber;
        this.client = client;
    }

    public String getBarber() {
        return barber;
    }

    public void setBarber(String barber) {
        this.barber = barber;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public double getHour() {
        return hour;
    }

    public void setHour(double hour) {
        this.hour = hour;
    }

    public int getHalfNumber() {
        return halfNumber;
    }

    public void setHalfNumber(int halfNumber) {
        this.halfNumber = halfNumber;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public String getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(String weekDay) {
        this.weekDay = weekDay;
    }

    public int getMonthDay() {
        return monthDay;
    }

    public void setMonthDay(int monthDay) {
        this.monthDay = monthDay;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public String getMonthName() {
        return monthName;
    }

    public void setMonthName(String monthName) {
        this.monthName = monthName;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }
}
