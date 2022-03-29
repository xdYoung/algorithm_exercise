package com.young.algorithm_exercise;

import edu.princeton.cs.algs4.*;

public class Interval2DTest {
    public static void main(String[] args) {
        double xlo = 0.2;
        double xhi = 0.5;
        double ylo = 0.5;
        double yhi = 0.6;
        int T = 10000;
//        double xlo = Double.parseDouble(args[0]);
//        double xhi = Double.parseDouble(args[1]);
//        double ylo = Double.parseDouble(args[2]);
//        double yhi = Double.parseDouble(args[3]);
//        int T = Integer.parseInt(args[4]);


        Interval1D xinterval = new Interval1D(xlo, xhi);
        Interval1D yinterval = new Interval1D(ylo, yhi);
        Interval2D box = new Interval2D(xinterval, yinterval);
        box.draw();

        Counter c = new Counter("hits");
        for (int i = 0; i < T; i++) {
            double x = Math.random();
            double y = Math.random();
            Point2D p = new Point2D(x, y);
            if(box.contains(p)) c.increment();
            else {p.draw();StdOut.println(i);}
        }

        StdOut.println(c);
        StdOut.println(box.area());
    }
}
