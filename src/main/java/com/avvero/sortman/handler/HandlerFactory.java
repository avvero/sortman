package com.avvero.sortman.handler;

/**
 * @author fxdev-belyaev-ay
 */
public class HandlerFactory<T extends Comparable> {

    public IHandler getHandler(int resultSize) {
        return new ArrayListHandler<T>(resultSize);
    }

}
