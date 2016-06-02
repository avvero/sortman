package com.avvero.sortman.handler;

import java.util.Collection;
import java.util.TreeSet;

/**
 * @author fxdev-belyaev-ay
 */
public class TreeSetHandler implements IHandler {

    private int resultSize;
    private TreeSet treeSet;

    public TreeSetHandler(int resultSize) {
        this.resultSize = resultSize;
        treeSet = new TreeSet<>();
    }

    @Override
    public void put(long number) {
        treeSet.add(number); // добавляем новый
        if (treeSet.size() > resultSize) {
            treeSet.pollFirst(); // удаляем меньший
        }
    }

    @Override
    public Collection result() {
        return treeSet;
    }
}
