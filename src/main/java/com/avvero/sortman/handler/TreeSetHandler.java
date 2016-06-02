package com.avvero.sortman.handler;

import java.util.Collections;
import java.util.TreeSet;

/**
 * @author fxdev-belyaev-ay
 */
public class TreeSetHandler implements IHandler<Long> {

    private int resultSize;
    private TreeSet<Long> treeSet;

    public TreeSetHandler(int resultSize) {
        this.resultSize = resultSize;
        treeSet = new TreeSet<>();
    }

    @Override
    public void put(Long number) {
        treeSet.add(number); // добавляем новый
        if (treeSet.size() > resultSize) {
            treeSet.pollFirst(); // удаляем меньший
        }
    }

    @Override
    public Long[] result() {
        return treeSet.toArray(new Long[resultSize]);
    }
}
