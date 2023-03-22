package nl.avasten.H5.calculations;

import java.util.ArrayList;

public class Calculations {

    public int greatest(int a, int b) {
        return Math.max(a, b);
    }

    public int greatest(String a, String b) {
        return greatest(Integer.valueOf(a), Integer.valueOf(b));
    }

    public int greatest(ArrayList<Integer> listOfInts) {
        int base = listOfInts.get(0);
        for (int i = 0; i < listOfInts.size(); i++) {
            base = greatest(base, listOfInts.get(i));
        }
        return base;
    }

    public int factorial(int n) {
        if ( n >= 1 ) {
            return n * factorial(n - 1);
        } else {
            return 1;
        }
    }

}
