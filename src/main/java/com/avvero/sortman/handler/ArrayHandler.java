package com.avvero.sortman.handler;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * @author fxdev-belyaev-ay
 */
public class ArrayHandler implements IHandler {

    private int resultSize;
    private long[] array;

    public ArrayHandler(int resultSize) {
        this.resultSize = resultSize;
    }

    @Override
    public void put(long number) {
        if (array == null) {
            array = new long[0];
        }
        // Лишний цикл проверки на дубли
        for (int i = 0; i < array.length; i++) {
            if (array[i] == number) {
                return;
            }
        }
        long[] newArray = Arrays.copyOf(array, array.length+1);
        newArray[array.length] = number;
        Arrays.sort(newArray);

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
