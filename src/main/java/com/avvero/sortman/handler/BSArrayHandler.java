package com.avvero.sortman.handler;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 * Sort handler based on array and binarysearch algorithm
 *
 * Sort performs after each "add" method call
 * @author Avvero
 */
public class BSArrayHandler implements IHandler {

    private int resultSize;
    private long[] array;

    public BSArrayHandler(int resultSize) {
        this.resultSize = resultSize;
    }

    @Override
    public void add(long number) {
        if (array == null) {
            array = new long[]{number};
            return;
        }
        // search position like binarysearch do
        int p = -1; //position
        int low = 0, mid, high = this.array.length;
        while (low < high) {
            mid = (low + high) >>> 1;
            if (number == this.array[mid]) {
                return; //skip
            } else {
                if (number < this.array[mid]) {
                    high = mid;
                } else {
                    p = mid;
                    low = mid + 1;
                }
            }
        }
        // skip less-than-first element
        if (array.length == resultSize && p == -1) {
            return;
        }
        // increase size for the undersized array
        if (array.length < resultSize) {
            long[] newArray = new long[array.length+1];
            System.arraycopy(array, 0, newArray, 1, array.length);
            array = newArray;
            ++p; // position must be increased too
        }
        System.arraycopy(array, 1, array, 0, p);
        array[p] = number;
    }

    @Override
    public Collection result() {
        if (array == null) {
            return Collections.emptyList();
        } else {
            return Arrays.stream(array).boxed().collect(Collectors.toList());
        }
    }
}
