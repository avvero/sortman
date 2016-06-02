package com.avvero.sortman.handler;

import java.util.Collection;

/**
 * @author fxdev-belyaev-ay
 */
public interface IHandler {

    void put(long number);
    Collection<Long> result();

}
