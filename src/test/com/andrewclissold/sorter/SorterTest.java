package com.andrewclissold.sorter;

import java.util.HashMap;

import com.andrewclissold.sorter.Sorter;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class SorterTest {

    // TODO Three test cases per sort order

    private Sorter sorter;

    @Before
    public void init() {
        sorter = new Sorter();
    }

    // Checks that the array really is in ascending order after being sorted
    @Test
    public void isAscending() {
        int[] array = {3, 5, 7, 4, 6, 1, 2};
        sorter.sortAscending(array);

        // Iterate through the sorted array, ensuring each element ≥ the last
        int prev = 0;
        for (int num : array) {
            if (num < prev) {
                fail("array not in ascending order (" + num + " is less " +
                        "than " + prev + ")");
            }
            prev = num;
        }
    }

    // Checks that the array really is in descending order after being sorted
    @Test
    public void isDescending() {
        int[] array = {3, 5, 7, 4, 6, 1, 2};
        sorter.sortDescending(array);

        // Iterate through the sorted array, ensuring each element ≤ the last
        int prev = 8;
        for (int num : array) {
            if (num > prev) {
                fail("array not in descending order (" + num + " is greater " +
                        "than " + prev + ")");
            }
            prev = num;
        }
    }

    // Verifies that the array gets put into proper ascending sorted order
    @Test
    public void ascendingKnownResult() {
        int[] actual = {0, -1, 3, 1, 2147483647, 2, -2147483648, -2, -3};
        int[] expected = {-2147483648, -3, -2, -1, 0, 1, 2, 3, 2147483647};
        sorter.sortAscending(actual);
        assertArrayEquals(expected, actual);
    }

    // Verifies that the array gets put into proper descending sorted order
    @Test
    public void descendingKnownResult() {
        int[] actual = {0, -1, 3, 1, 2147483647, 2, -2147483648, -2, -3};
        int[] expected = {2147483647, 3, 2, 1, 0, -1, -2, -3, -2147483648};
        sorter.sortDescending(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void ascendingPermutes() {
        // Ensures the resultant array is a permutation of the original items.
        int[] array = {2, -1, 2, -10, 4, 5, -5, -10, 5, -5, -4, 9, -9, 2,
        -2, -3, 4, 3, -6, -9, -7, -8, 6, -5, 1, 5, -5, 5, -7, 10, -4, -2, -7,
        -7, 5, 3, -4, -5, 5, -2, -5, -8, -7, -5, -1, 1, -8, -1, -4, 4, -3, -10,
        -7, 8, 9, 10, -6, -6, -5, -5, -9, -7, 8, 1, 9, -2, 8, 10, -2, 6, -9,
        -9, 6, 10, -5, -10, 3, -9, -6, 1, -8, 1, -3, -2, -5, 1, 6, -9, 7, -5,
        6, 9, -3, -9, 7, -8, -10, 4, -2, 0};

        // Use a HashMaps to count the occurences of each item
        HashMap<Integer, Integer> expected = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> actual = new HashMap<Integer, Integer>();

        populate(expected, array);

        // Sort the array and re-count the elements
        sorter.sortAscending(array);
        populate(actual, array);

        assertEquals(expected, actual);
    }

    @Test
    public void descendingPermutes() {
        // Ensures the resultant array is a permutation of the original items.
        int[] array = {2, -1, 2, -10, 4, 5, -5, -10, 5, -5, -4, 9, -9, 2,
        -2, -3, 4, 3, -6, -9, -7, -8, 6, -5, 1, 5, -5, 5, -7, 10, -4, -2, -7,
        -7, 5, 3, -4, -5, 5, -2, -5, -8, -7, -5, -1, 1, -8, -1, -4, 4, -3, -10,
        -7, 8, 9, 10, -6, -6, -5, -5, -9, -7, 8, 1, 9, -2, 8, 10, -2, 6, -9,
        -9, 6, 10, -5, -10, 3, -9, -6, 1, -8, 1, -3, -2, -5, 1, 6, -9, 7, -5,
        6, 9, -3, -9, 7, -8, -10, 4, -2, 0};

        // Use a HashMaps to count the occurences of each item
        HashMap<Integer, Integer> expected = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> actual = new HashMap<Integer, Integer>();

        populate(expected, array);

        // Sort the array and re-count the elements
        sorter.sortDescending(array);
        populate(actual, array);

        assertEquals(expected, actual);
    }

    // populates the given HashMap with the counts of each item in the array
    private void populate(HashMap<Integer, Integer> hashMap, int[] array) {
        for (int num : array) {
            if (!hashMap.containsKey(num)) {
                hashMap.put(num, 1);
            } else {
                int count = hashMap.get(num);
                count++;
                hashMap.put(num, count);
            }
        }
    }
}
