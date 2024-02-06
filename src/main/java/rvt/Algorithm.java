package rvt;

import java.util.Arrays;

public class Algorithm {
    public static void main(String[] args)  {
        int[] array = {5, 16, 6, 8, 2, 9};
        System.out.println("Original Array: " + Arrays.toString(array).replaceAll("^.|.$", ""));
        System.out.println("Min value: " + Algorithm.findMinVal(array));
        int[] sortedArr = Algorithm.sort(array);
        System.out.println("Sorted Array: " + Arrays.toString(sortedArr).replaceAll("^.|.$", ""));
    }

    public static int findMinVal(int[] array) {
        int minValue = array[0];
        for (int i : array) {
            if (i < minValue) minValue = i;
        }
        return minValue;
    }

    public static int binarySearch(int[] array, int target) {
        int start = 0;
        int end = array.length - 1;
        
        while (start <= end) {
            int middle = (start + end) / 2;
            int val = array[middle];
            
            if (val == target) return middle;
            
            if (val < target) {
                start = middle + 1;
            } else if (val > target) {
                end = middle - 1;
            }
        }
        return -1;
    }

    public static int[] sort (int[] array) {
        return array;
    }

    public static int[] mergeSort(int[] array) {
        

        return array;
    }
    
    public static int[] quickSort(int[] array) {
        return array;
    }
    

}
