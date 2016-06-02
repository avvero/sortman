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
        int l = -1;
        int r = 0;
        int low = 0, mid, high = this.array.length;
        while (low < high) {
            mid = (low + high) >>> 1;
            if (number == this.array[mid]) {
                return; //skip
            } else {
                if (number < this.array[mid]) {
                    r = mid;
                    high = mid;
                } else {
                    l = mid;
                    r = mid + 1;
                    low = mid + 1;
                }
            }
        }
        long[] newArray = new long[array.length+1];
        System.arraycopy(array, 0, newArray, 0, l+1);
        newArray[l+1] = number;
        if (r < array.length) {
            System.arraycopy(array, r, newArray, r+1, array.length-r);
        }
        if (newArray.length <= resultSize) {
            array = newArray;
        } else {
            System.arraycopy(newArray, 1, array, 0, resultSize);
        }
    }

    @Override
    public Collection result() {
        return Arrays.stream(array).boxed().collect(Collectors.toList());
    }
}
