package com.young.sort_algorithm;

public class Date_Sort_Exercise implements Comparable<Date_Sort_Exercise>{
    private final int day;
    private final int monty;
    private final int year;

    public Date_Sort_Exercise(int d, int m, int y){
        day = d; monty = m; year = y;
    }

    public int day(){return day;}
    public int monty(){return monty;}
    public int year(){return year;}

    @Override
    public int compareTo(Date_Sort_Exercise that) {
        if(this.year > that.year) return +1;
        if(this.year < that.year) return -1;
        if(this.monty > that.monty) return +1;
        if(this.monty < that.monty) return -1;
        if(this.day > that.day) return +1;
        if(this.day < that.day) return -1;
        return 0;
    }

    @Override
    public String toString() {
        return monty + "/" + day + "/" + year;
    }

    public static void main(String[] args) {
        Date_Sort_Exercise date1 = new Date_Sort_Exercise(18,5,2022);
        System.out.println("data1 = " + date1);
        Date_Sort_Exercise date2 = new Date_Sort_Exercise(18, 5, 2021);
        System.out.println("date2 = " + date2);
        if(date1.compareTo(date2) > 0) System.out.println("date1 大于 date2");
        else System.out.println("date1 小于 date2");
    }
}
