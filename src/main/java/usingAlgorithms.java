import org.jetbrains.annotations.NotNull;

public class usingAlgorithms {
    public static void main(String[] args) {
        int[] arr = {320, 96, 16, 90, 120, 80, 200, 64};
        System.out.print("Array Before Bubble Sort: ");
        for (int j : arr) System.out.print(j + " ");
        bubbleSort(arr);
        System.out.print("\nArray After Bubble Sort: ");
        for (int j : arr) System.out.print(j + " ");
    }

    public static void bubbleSort(@NotNull int[] arr) {
        int n = arr.length;
        boolean flag = false;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            flag = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j+1] and arr[j] and check if the array is sorted
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (!flag) break;
        }
    }

    public static void printArray(@NotNull int[] arr) {
        for (int j : arr) System.out.print(j + " ");
    }
}


