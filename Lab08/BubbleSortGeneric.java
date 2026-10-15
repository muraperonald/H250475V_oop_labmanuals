// ============================================================
// Lab 8 - Exercise solutions (Challenge)
// File: BubbleSortGeneric.java
// Student: Ronald Murape (H250475V)
// ============================================================
public class BubbleSortGeneric {

    // EXPLAIN: bounded type param so compareTo is available; primitives (int[]) won't work
    public static <T extends Comparable<T>> void bubbleSort(T[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    T tmp = arr[j]; arr[j] = arr[j + 1]; arr[j + 1] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] nums = {5, 1, 4, 2, 8};
        bubbleSort(nums);
        System.out.println(java.util.Arrays.toString(nums));

        String[] words = {"pear", "apple", "zebra"};
        bubbleSort(words);
        System.out.println(java.util.Arrays.toString(words));
    }
}
