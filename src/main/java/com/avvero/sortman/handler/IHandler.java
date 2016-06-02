package com.avvero.sortman.handler;

/**
 * @author fxdev-belyaev-ay
 */
public interface IHandler<T> {

    void put(T number);
    T[] result();

}
