package com.young.algorithm_exercise;

public class EqualsExercise {
    public static class Date{
        private final int month;
        private final int day;
        private final int year;

        public Date(int m, int d, int y){
            this.month = m;
            this.day = d;
            this.year = y;
        }

        public int month(){
            return this.month;
        }

        public int day(){
            return this.day;
        }

        public int year(){
            return this.year;
        }

        @Override
        public boolean equals(Object obj) {
            if(this == obj) return true;
            if(obj == null) return false;
            if(this.getClass() != obj.getClass()) return false;
            Date that = (Date) obj;
            if(this.day != that.day) return false;
            if(this.month != that.month) return false;
            if(this.year != that.year) return false;
            return true;
        }

        public String toString(){
            return month() + "/" + day() + "/" + year();
        }
    }

    public static void main(String[] args) {
        Date date01 = new Date(3, 25, 2022);
        Date date02 = new Date(3, 24, 2022);
        System.out.println(date01 + "\t" + date02);
        boolean flag = date01.equals(date02);
        System.out.println("date01与date02是否相等： " + flag);
    }
}
