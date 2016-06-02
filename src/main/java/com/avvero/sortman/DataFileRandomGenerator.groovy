package com.avvero.sortman

/**
 * @author fxdev-belyaev-ay
 */
class DataFileRandomGenerator {

    static def getNext(int max) {
        return new Random().nextInt(max);
    }

    public static void main(String [] strings) {
        int length = strings[0].toInteger()
        int max = strings[1].toInteger()
    }

}
