package com.avvero.sortman.handler;

/**
 * @author fxdev-belyaev-ay
 */
public class HandlerFactory {

    public static IHandler getHandler(int resultSize) {
        return new TreeSetHandler(resultSize);
    }

}
