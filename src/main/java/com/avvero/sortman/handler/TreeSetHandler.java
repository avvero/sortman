package com.avvero.sortman.handler;

import java.util.Collection;
import java.util.TreeSet;

/**
 * @author fxdev-belyaev-ay
 */
public class TreeSetHandler<T extends Comparable> implements IHandler<T> {

    private int resultSize;
    private TreeSet<T> treeSet;

    public TreeSetHandler(int resultSize) {
        this.resultSize = resultSize;
        treeSet = new TreeSet<>();
    }

    @Override
    public void put(T number) {
        treeSet.add(number); // добавляем новый
        if (treeSet.size() > resultSize) {
            treeSet.pollFirst(); // удаляем меньший
        }
    }

    @Override
    public Collection<T> result() {
        return treeSet;
    }
}
