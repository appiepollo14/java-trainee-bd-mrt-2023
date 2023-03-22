package nl.avasten.H5.fibonacci;

public class Fibo {

    public void run(int i) {

        int fiboSum = 0;
        int last = 1;

        for (int n = 1; n <= i; n++) {
            int sum = (last * n-1) + (last * n-2);
            System.out.println(sum);
            last++;
        }
    }
}
