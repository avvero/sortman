package com.avvero.sortman.handler;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author fxdev-belyaev-ay
 */
public class ArrayHandler implements IHandler {

    private int resultSize;
    private long[] array;

    public ArrayHandler(int resultSize) {
        this.resultSize = resultSize;
        array = new long[resultSize];
    }

    @Override
    public void put(long number) {
        boolean done = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0 || array[i] == number) {
                array[i] = number;
                done = true;
                break;
            }
        }
        if (!done) {
            array[0] = number;
        }
        Arrays.sort(array);
    }

    @Override
    public Collection result() {
        return Arrays.asList(array);
    }
}
