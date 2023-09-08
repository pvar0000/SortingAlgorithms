import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class UsingSelectionSort {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN_BG = "\u001B[42m";
    public static final String ANSI_RED_BG = "\u001B[41m";

    public static final String ANSI_BLUE_BG = "\u001B[44m";

    public static final String ANSI_BLACK = "\u001B[30m";


    public static void main(String[] args) {
        int[] arr = {320, 96, 16, 90, 120, 80, 200, 64};
        System.out.print("Array before Selection Sort: ");
        for (int j : arr) System.out.print(j + " ");
        selectionSort(arr);
        System.out.print("\nArray after Selection Sort: ");
        for (int j : arr) System.out.print(j + " ");
    }

    public static void selectionSort(@NotNull int[] arr) {
        int n = arr.length;
        int minIndex, temp;

        System.out.println("\nStep by step");
        for (int i = 0; i < n - 1; i++) {
            minIndex = i;

            System.out.println("For i = " + i + ":");
            System.out.println("\tMinimum = " + arr[minIndex]);
            System.out.print("\tBefore: ");
            printArray(arr, i, minIndex);

            for (int j = i + 1; j < n; j++) {
                System.out.println("\tFor j = " + j + ":");
                System.out.println("\t\t" + arr[j] + " < " + arr[minIndex] + " ?: " + (arr[j] < arr[minIndex]));
                if (arr[j] < arr[minIndex]) {
                    System.out.println("\t\t" + arr[j] + " is the new minimum");
                    minIndex = j;
                }
            }

            System.out.println("\tSwap " + arr[i] + " and " + arr[minIndex]);
            temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
            System.out.print("\tAfter: ");
            printArray(arr, i, minIndex);
        }
    }

    public static void printArray(@NotNull int[] arr, int j, int minIndex) {
        int n = arr.length;
        Map<String, String> colorMap = new HashMap<>();
        colorMap.put("unsorted", ANSI_RED_BG + ANSI_BLACK);
        colorMap.put("sorted", ANSI_GREEN_BG + ANSI_BLACK);
        colorMap.put("min", ANSI_BLUE_BG + ANSI_BLACK);

        String unsortedColor = colorMap.get("unsorted");
        String sortedColor = colorMap.get("sorted");
        String minColor = colorMap.get("min");

        for (int i = 0; i <= j; i++) {
            if (i == minIndex) System.out.print(minColor + arr[i] + ANSI_RESET + " ");
            else System.out.print(sortedColor + arr[i] + ANSI_RESET + " ");
        }

        for (int i = j + 1; i < n; i++) {
            if (i == minIndex) System.out.print(minColor + arr[i] + ANSI_RESET + " ");
            else System.out.print(unsortedColor + arr[i] + ANSI_RESET + " ");
        }
        System.out.println();
    }
}
