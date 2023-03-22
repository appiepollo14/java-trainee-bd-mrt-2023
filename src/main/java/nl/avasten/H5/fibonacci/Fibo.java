package nl.avasten.H5.fibonacci;

public class Fibo {

    public long run(int start, int n) {

        if (n <= 0) {
            throw new IllegalArgumentException("Mag niet gelijk of kleiner aan 0 zijn!");
        }

        int lastLastGetal = 0;
        int lastGetal = 1;

        if (n == 1) {
            return lastLastGetal;
        } else if (n == 2) {
            return lastGetal;
        } else {
            for (int y = 2; y < n; y++) {
                int currentSum = lastGetal + lastLastGetal;
                lastLastGetal = lastGetal;
                lastGetal = currentSum;
            }
            return lastGetal;
        }
    }

    public long run(int i) {
        return this.run(0, i);
    }
}
