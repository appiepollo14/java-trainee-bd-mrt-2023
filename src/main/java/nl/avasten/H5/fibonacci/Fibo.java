package nl.avasten.H5.fibonacci;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class Fibo {

    public int run(int i) {
        return this.run(0, 1, i);
    }

    public int run(int start, int n) {
        return this.run(start, start, n);
    }

    public int run(int f1, int f2, int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Mag niet gelijk of kleiner aan 0 zijn!");
        }

        int lastLastGetal = f1;
        int lastGetal = f2;

        if (n == 1) {
            System.out.println(lastLastGetal);
            return lastLastGetal;
        } else if (n == 2) {
            System.out.println(lastGetal);
            return lastGetal;
        } else {
            for (int y = 2; y < n; y++) {
                int currentSum = lastGetal + lastLastGetal;
                lastLastGetal = lastGetal;
                lastGetal = currentSum;
                System.out.println(currentSum);
            }
            return lastGetal;
        }
    }

    public float goldenRatio(int i) {

        int fiboN = run(i);
        int fiboNMin1 = run(i-1);
        float golden = (float) fiboN/ (float) fiboNMin1;
        System.out.println("Goud: " + golden);
        return golden;
    }

    public BigInteger run2(int i) {
        return this.run2(0, 1, i);
    }

    public BigInteger run2(int start, int n) {
        return this.run2(start, start, n);
    }

    public BigInteger run2(int f1, int f2, int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Mag niet gelijk of kleiner aan 0 zijn!");
        }

        BigInteger lastLastGetal = new BigInteger(String.valueOf(f1));
        BigInteger lastGetal = new BigInteger(String.valueOf(f2));

        if (n == 1) {
//            System.out.println(lastLastGetal);
            return lastLastGetal;
        } else if (n == 2) {
//            System.out.println(lastGetal);
            return lastGetal;
        } else {
            for (int y = 2; y < n; y++) {
                BigInteger currentSum = lastGetal.add(lastLastGetal);
                lastLastGetal = lastGetal;
                lastGetal = currentSum;
//                System.out.println(currentSum);
            }
            return lastGetal;
        }
    }

    public BigDecimal goldenRatio2(int i) {

        BigInteger fiboN = run2(i);
        BigInteger fiboNMin1 = run2(i-1);
        BigDecimal golden = new BigDecimal(fiboN).divide(new BigDecimal(fiboNMin1), 2000, RoundingMode.DOWN);
        System.out.println(golden.toString());
        return golden;
    }



}
