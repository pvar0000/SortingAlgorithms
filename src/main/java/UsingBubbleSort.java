import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class UsingBubbleSort {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";

    public static void main(String[] args) {
        int[] arr = {320, 96, 16, 90, 120, 80, 200, 64};
        System.out.print("Array before Bubble Sort: ");
        for (int j : arr) System.out.print(j + " ");
        bubbleSort(arr);
        System.out.print("\nArray after Bubble Sort: ");
        for (int j : arr) System.out.print(j + " ");
    }

    public static void bubbleSort(@NotNull int[] arr) {
        int n = arr.length;
        boolean flag;
        int temp;
        System.out.println("\nStep by step");
        for (int i = 0; i < n; i++) {
            flag = false;
            System.out.println("For i = " + i + ":");
            for (int j = 0; j < n - i - 1; j++) {
                System.out.println("\tFor j = " + j + ":");
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j+1] and arr[j] and check if the array is sorted
                    System.out.print("\t\tBefore: ");
                    printArray(arr, j, "before");
                    System.out.println("\t\t" + arr[j] + " > " + arr[j + 1] + " ?: Yes");
                    System.out.println("\t\tSwap: " + arr[j] + " and " + arr[j + 1]);
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                } else System.out.println("\t\t" + arr[j] + " > " + arr[j + 1] + " ?: No");
                System.out.print("\t\tAfter: ");
                printArray(arr, j, "after");
                System.out.println();
            }
            if (!flag) break;
        }
    }

    public static void printArray(@NotNull int[] arr, int j, String status) {
        Map<String, String> colorMap = new HashMap<>();
        colorMap.put("before", ANSI_RED);
        colorMap.put("after", ANSI_GREEN);

        String color = colorMap.get(status);

        for (int i = 0; i < arr.length; i++) {
            if (i == j || i == j + 1) System.out.print(color + arr[i] + ANSI_RESET + " ");
            else System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}


