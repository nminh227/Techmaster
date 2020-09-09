package vn.techmaster;

import java.util.Scanner;

public class Main {
    public static void main(String arg[])
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter Principal Amount : ");
        double p = scan.nextDouble();
        System.out.print("Enter Rate of Interest : ");
        double r = scan.nextDouble();
        r =( r/100)/12;
        System.out.print("Enter Time period in years : ");
        int n = scan.nextInt();
        n = n * 12;
        double m = p* ((r * Math.pow(1 + r, n)) / (Math.pow(1 + r, n) -1));
        //
        System.out.println("Payment: " + m);
    }
}


