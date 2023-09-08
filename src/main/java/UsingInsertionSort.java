import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class UsingInsertionSort {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN_BG = "\u001B[42m";
    public static final String ANSI_RED_BG = "\u001B[41m";

    public static final String ANSI_BLACK = "\u001B[30m";


    public static void main(String[] args) {
        int[] arr = {320, 96, 16, 90, 120, 80, 200, 64};
        System.out.print("Array before Insertion Sort: ");
        for (int j : arr) System.out.print(j + " ");
        insertionSort(arr);
        System.out.print("\nArray after Insertion Sort: ");
        for (int j : arr) System.out.print(j + " ");
    }

    public static void insertionSort(@NotNull int[] arr) {
        int n = arr.length;
        int key;

        System.out.println("\nStep by step");
        for (int i = 1; i < n; i++) {
            key = arr[i];
            int j = i - 1;

            System.out.println("For i = " + i + ":");

            while (j >= 0 && arr[j] > key) {
                System.out.println("\tFor j = " + j + ":");
                System.out.print("\t\tBefore: ");
                printArray(arr, i - 1);
                System.out.println("\t\t" + arr[j] + " > " + key + " ?: Yes");
                System.out.println("\t\t" + arr[j] + " moves up one position");
                arr[j + 1] = arr[j];
                j--;
            }

            if (j != -1) System.out.println("\t\t" + arr[j] + " > " + key + " ?: No");
            else System.out.println("\t\t" + key + " is the smallest element in the subarray");
            System.out.println("\t\tSo " + key + " is inserted at position " + (j + 1));
            arr[j + 1] = key;
            System.out.print("\t\tAfter: ");
            printArray(arr, i);
        }
    }

    public static void printArray(@NotNull int[] arr, int j) {
        Map<String, String> colorMap = new HashMap<>();
        colorMap.put("unsorted", ANSI_RED_BG + ANSI_BLACK);
        colorMap.put("sorted", ANSI_GREEN_BG + ANSI_BLACK);

        String unsortedColor = colorMap.get("unsorted");
        String sortedColor = colorMap.get("sorted");

        for (int i = 0; i <= j; i++) {
            System.out.print(sortedColor + arr[i] + ANSI_RESET + " ");
        }

        for (int i = j + 1; i < arr.length; i++) {
            System.out.print(unsortedColor + arr[i] + ANSI_RESET + " ");
        }
        System.out.println();
    }

}
