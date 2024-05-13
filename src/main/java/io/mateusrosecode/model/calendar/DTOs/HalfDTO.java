package io.mateusrosecode.model.calendar.DTOs;

public class HalfDTO {
    private double hour;
    private int halfNumber;
    private boolean occupied;
    private String weekDay;
    private int monthDay;
    private String monthName;
    private int month;
    private int year;

    public HalfDTO() {
    }

    public HalfDTO(double hour, int halfNumber, boolean occupied, String weekDay, String monthName, int monthDay, int month, int year) {
        this.hour = hour;
        this.halfNumber = halfNumber;
        this.occupied = occupied;
        this.weekDay = weekDay;
        this.monthName=monthName;
        this.monthDay = monthDay;
        this.month = month;
        this.year = year;
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
