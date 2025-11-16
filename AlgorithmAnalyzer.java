//======Ujali=========

import java.util.*;

public class AlgorithmAnalyzer {

    public static void main(String[] args) {
        int[] sizes = {100, 500, 1000};

        System.out.println("===== Algorithm Time Analyzer =====\n");

        testLinearSearch(sizes);
        System.out.println();

        testBinarySearch(sizes);
        System.out.println();

        testBubbleSort(sizes);
        System.out.println();

        testQuickSort(sizes);
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

// ================= BINARY SEARCH ================= Ruwanthika
    static void testBinarySearch(int[] sizes) {
        Random rand = new Random();

        System.out.println("Algorithm: Binary Search");
        System.out.println("Input Size | Time (ms)");
        System.out.println("----------------------");

        for (int n : sizes) {
            int[] arr = createArray(n, rand);
            Arrays.sort(arr);
            int key = arr[n - 1];

            long start = System.nanoTime();
            Arrays.binarySearch(arr, key);
            long end = System.nanoTime();

            double timeMs = (end - start) / 1e6;
            System.out.printf("%-11d| %.4f%n", n, timeMs);
        }
    }

// ================= BUBBLE SORT ================= Sithara
    static void testBubbleSort(int[] sizes) {
        Random rand = new Random();

        System.out.println("Algorithm: Bubble Sort");
        System.out.println("Input Size | Time (ms)");
        System.out.println("----------------------");

        for (int n : sizes) {
            int[] arr = createArray(n, rand);

            long start = System.nanoTime();
            bubbleSort(arr);
            long end = System.nanoTime();

            double timeMs = (end - start) / 1e6;
            System.out.printf("%-11d| %.4f%n", n, timeMs);
        }
    }

    static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }


    // ================= QUICK SORT ================= pasindu
    static void testQuickSort(int[] sizes) {
        Random rand = new Random();

        System.out.println("Algorithm: Quick Sort");
        System.out.println("Input Size | Time (ms)");
        System.out.println("----------------------");

        for (int n : sizes) {
            int[] arr = createArray(n, rand);

            long start = System.nanoTime();
            quickSort(arr, 0, arr.length - 1);
            long end = System.nanoTime();

            double timeMs = (end - start) / 1e6;
            System.out.printf("%-11d| %.4f%n", n, timeMs);
        }
    }

    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }


}