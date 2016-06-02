package com.avvero.sortman.handler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * @author fxdev-belyaev-ay
 */
public class ArrayListHandler<T extends Comparable> implements IHandler<T> {

    private int resultSize;
    private ArrayList<T> list;

    public ArrayListHandler(int resultSize) {
        this.resultSize = resultSize;
        list = new ArrayList<>();
    }

    @Override
    public void put(T number) {
        list.add(number);
        Collections.sort(list);
        if (list.size() > resultSize){
            list.remove(0);
        }
    }

    @Override
    public Collection<T> result() {
        return list;
    }
}
