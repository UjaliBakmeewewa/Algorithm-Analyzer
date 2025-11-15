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
}