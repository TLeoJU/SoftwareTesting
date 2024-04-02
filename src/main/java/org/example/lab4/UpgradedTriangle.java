package org.example.lab4;

public class UpgradedTriangle {
    public String classifyTriangle(int sideA, int sideB, int sideC) {
        if (sideA + sideB <= sideC || sideA + sideC <= sideB || sideB + sideC <= sideA)
            return "INVALID";
        else if (sideA == sideB && sideA == sideC)
            return "EQUILATERAL";
        else if (sideA == sideB || sideA == sideC || sideB == sideC)
            return "ISOSCELES";
        else return "SCALENE";
    }


    public double calArea(int sideA, int sideB, int sideC) {
        if (classifyTriangle(sideA, sideB, sideC).equals("INVALID"))
            return 0;
        else {
            double p = (sideA + sideB + sideC) / 2.0;
            return Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
        }
    }
}
