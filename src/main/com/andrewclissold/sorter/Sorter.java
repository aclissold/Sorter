package com.andrewclissold.sorter;

import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;

// Sorter provides simple ascending and descending sort facilities.
public class Sorter {

    // implicit default no-param constructor

    // Sorts the input array in ascending order
    public void sortAscending(int[] array) {
        sort(false, array);
    }

    // Sorts the input array in descending order
    public void sortDescending(int[] array) {
        sort(true, array);
    }

    // Sort implements an even stupider version of bogosort. Bogosort, also
    // known as random sort or stupidsort, randomly permutes the array until
    // it is sorted. This implementation one-ups the stupidity of it by first
    // calling Collections.sort on a copy of the array (hah!) to use as the
    // comparison for whether or not the shuffled array is sorted.
    private void sort(boolean descending, int[] array) {
        // Setup
        ArrayList<Integer> list = new ArrayList<Integer>(array.length);
        for (int num : array) list.add(num);
        ArrayList<Integer> sortedList = new ArrayList<Integer>(list);
        Collections.sort(sortedList);
        if (descending) Collections.reverse(sortedList);

        // bogosort
        while (!list.equals(sortedList)) {
            Collections.shuffle(list);
        }

        // Put list back into the original array now that it's sorted
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
    }

}
