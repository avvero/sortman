package com.avvero.sortman.handler;

import java.util.Collection;
import java.util.TreeSet;

/**
 * Sort handler based on TreeSet with algorithm:
 * - add new number to TreeSet
 * - remove first
 *
 * Sort performs after each "add" method call
 * @author Avvero
 */
public class TreeSetHandler implements IHandler {

    private int resultSize;
    private TreeSet treeSet;

    public TreeSetHandler(int resultSize) {
        this.resultSize = resultSize;
        treeSet = new TreeSet<>();
    }

    @Override
    public void add(long number) {
        treeSet.add(number);
        if (treeSet.size() > resultSize) {
            treeSet.pollFirst();
        }
    }

    @Override
    public Collection result() {
        return treeSet;
    }
}
