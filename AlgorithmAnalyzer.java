import java.util.*;

public class AlgorithmAnalyzer {

    public static void main(String[] args) {
        int[] sizes = {100, 500, 1000};

        System.out.println("===== Algorithm Time Analyzer =====\n");

        testLinearSearch(sizes);
        System.out.println();


    }

            // ================= UTILITY =================
    static int[] createArray(int n, Random rand) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(1000);
        }
        return arr;
    }

        // ================= LINEAR SEARCH =================
    static void testLinearSearch(int[] sizes) {
        Random rand = new Random();

        System.out.println("Algorithm: Linear Search");
        System.out.println("Input Size | Time (ms)");
        System.out.println("----------------------");

        for (int n : sizes) {
            int[] arr = createArray(n, rand);
            int key = arr[n - 1];

            long start = System.nanoTime();
            linearSearch(arr, key);
            long end = System.nanoTime();

            double timeMs = (end - start) / 1e6;
            System.out.printf("%-11d| %.4f%n", n, timeMs);
        }
    }

    static int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) return i;
        }
        return -1;
    }

}