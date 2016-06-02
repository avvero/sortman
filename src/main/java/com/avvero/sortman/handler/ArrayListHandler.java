package com.avvero.sortman.handler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 *  Sort handler based on ArrayList with lazy algorithm:
 * - add new number to list
 * - sort list
 * - remove first (the lesser one) element
 * @author Avvero
 */
public class ArrayListHandler implements IHandler {

    private int resultSize;
    private ArrayList<Long> list;

    public ArrayListHandler(int resultSize) {
        this.resultSize = resultSize;
        list = new ArrayList<>();
    }

    @Override
    public void add(long number) {
        // Skip duplicates
        if (!list.contains(number)) {
            list.add(number);
            Collections.sort(list);
            if (list.size() > resultSize){
                list.remove(0);
            }
        }
    }

    @Override
    public Collection result() {
        return list;
    }
}
