package lv.rvt;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import rvt.Algorithm;

public class AlgorithmTest {
    @Test
    public void testFindMinVal() {
        int[] array = {5, 16, 6, 8, 2, 9};
        int minVal = Algorithm.findMinVal(array);
        assert minVal == 2;
    }

    @Test
    public void testSort() {
        int[] array = {5, 16, 6, 8, 2, 9};
        int[] sortedArr = Algorithm.sort(array);
        assert sortedArr[0] == 2;
        assert sortedArr[1] == 5;
        assert sortedArr[2] == 6;
        assert sortedArr[3] == 8;
        assert sortedArr[4] == 9;
        assert sortedArr[5] == 16;
    }

    @Test
    public void testMergeSort() {
        int[] array = {5, 16, 6, 8, 2, 9};
        int[] sortedArr = Algorithm.mergeSort(array);
        int[] exceptedArr = {2, 5, 6, 8, 9, 16};

        assertArrayEquals(exceptedArr, sortedArr);
    }

    @Test
    public void testQuickSort() {
        int[] array = {5, 16, 6, 8, 2, 9};
        int[] sortedArr = Algorithm.quickSort(array);
        int[] exceptedArr = {2, 5, 6, 8, 9, 16};

        assertArrayEquals(exceptedArr, sortedArr);
    }

    @Test
    public void testBinarySearch() {
        int[] array = {-1, 0, 3, 5, 8, 9, 12};
        assertEquals(4, Algorithm.binarySearch(array, 8));
        assertEquals(-1, Algorithm.binarySearch(array, 10));

        int[] newArray = {-190, -1, 0, 3, 5, 8, 9, 12, 100, 1000};
        assertEquals(8, Algorithm.binarySearch(newArray, 100));
        assertEquals(-1, Algorithm.binarySearch(newArray, 10));
    }
}
