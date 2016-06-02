package com.avvero.sortman.handler;

/**
 * @author fxdev-belyaev-ay
 */
public class HandlerFactory {

    public IHandler getHandler(int resultSize) {
        return new ArrayListHandler(resultSize);
    }

}
