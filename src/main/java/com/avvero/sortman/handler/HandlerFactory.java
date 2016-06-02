package com.avvero.sortman.handler;

/**
 * Factory for IHandler implementations
 * @author Avvero
 */
public class HandlerFactory {

    /**
     * Factory method to return the most excellent super duper quick sort handler
     * (based on test results and my opinion)
     * @param resultSize size of desired result collection
     * @return handler
     */
    public static IHandler getHandler(int resultSize) {
        return new BSArrayHandler(resultSize);
    }

}
