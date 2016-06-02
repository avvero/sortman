package com.avvero.sortman.handler;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * @author Avvero
 */
public class BSArrayHandler implements IHandler {

    private int resultSize;
    private long[] array;

    public BSArrayHandler(int resultSize) {
        this.resultSize = resultSize;
    }

    @Override
    public void put(long number) {
        if (array == null) {
            array = new long[]{number};
            return;
        }
        //position search
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
        if (array.length < resultSize) {
            long[] newArray = new long[array.length+1];
            System.arraycopy(array, 0, newArray, 1, array.length);
            array = newArray;
            ++p;
        }
        // replace first
        if (array.length == resultSize && p == -1) {
            return;
        }
        System.arraycopy(array, 1, array, 0, p);
        array[p] = number;
        int f = 1;
    }

    @Override
    public Collection result() {
        return Arrays.stream(array).boxed().collect(Collectors.toList());
    }
}
