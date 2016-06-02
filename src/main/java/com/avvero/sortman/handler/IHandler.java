package com.avvero.sortman.handler;

import java.util.Collection;

/**
 * Sort handler interface
 * @author Avvero
 */
public interface IHandler {

    /**
     * Add specified number to this handler
     * @param number number to be added to this handler
     */
    void add(long number);

    /**
     * Returns result of sorting
     * @return result sorted collection
     */
    Collection<Long> result();

}
