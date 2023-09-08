import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class UsingBinaryInsertionSort {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN_BG = "\u001B[42m";
    public static final String ANSI_RED_BG = "\u001B[41m";

    public static final String ANSI_BLACK = "\u001B[30m";

    public static void main(String[] args) {
        int[] arr = {320, 96, 16, 90, 120, 80, 200, 64};
        System.out.print("Array before Binary Insertion Sort: ");
        for (int j : arr) System.out.print(j + " ");
        binaryInsertionSort(arr);
        System.out.print("\nArray after Binary Insertion Sort: ");
        for (int j : arr) System.out.print(j + " ");
    }

    public static void binaryInsertionSort(@NotNull int[] arr) {
        int n = arr.length;
        int key, left, right, mid;

        System.out.println("\nStep by step");
        for (int i = 1; i < n; i++) {
            key = arr[i];
            left = 0;
            right = i - 1;

            System.out.println("For i = " + i + ":");

            while (left <= right) {
                mid = (left + right) / 2;
                if (key < arr[mid]) right = mid - 1;
                else left = mid + 1;
            }

            System.out.println("\tKey = " + key);
            System.out.println("\tLeft = " + left);

            for (int j = i - 1; j >= left; j--) {
                arr[j + 1] = arr[j];
                System.out.println("\tFor j = " + j + ":");
                System.out.print("\t\tAfter: ");
                printArray(arr, i - 1);
            }
            System.out.println("\n\tSo " + key + " is inserted at position " + left);
            arr[left] = key;

            System.out.print("\tResult: ");
            printArray(arr, i);
        }
    }

    public static void printArray(@NotNull int[] arr, int j) {
        int n = arr.length;
        Map<String, String> colorMap = new HashMap<>();
        colorMap.put("unsorted", ANSI_RED_BG + ANSI_BLACK);
        colorMap.put("sorted", ANSI_GREEN_BG + ANSI_BLACK);

        String unsortedColor = colorMap.get("unsorted");
        String sortedColor = colorMap.get("sorted");

        for (int i = 0; i <= j; i++) {
            System.out.print(sortedColor + arr[i] + ANSI_RESET + " ");
        }

        for (int i = j + 1; i < n; i++) {
            System.out.print(unsortedColor + arr[i] + ANSI_RESET + " ");
        }
        System.out.println();
    }
}
