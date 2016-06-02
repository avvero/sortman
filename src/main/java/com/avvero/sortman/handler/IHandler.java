package com.avvero.sortman.handler;

import java.util.Collection;

/**
 * @author fxdev-belyaev-ay
 */
public interface IHandler<T extends Comparable> {

    void put(T number);
    Collection<T> result();

}
