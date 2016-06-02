package com.avvero.sortman

/**
 * Convenient file generator with number-per-line data
 * @author Avvero
 */
class DataFileRandomGenerator {

    /**
     * Groovy magic
     * @param strings
     */
    public static void main(String [] strings) {
        int length = strings[0].toInteger()
        int max = strings[1].toInteger()
        def file = new File("random_"+length+"_"+max+".txt")
        if (file.exists()) {
            throw new RuntimeException("File already exists")
        }
        length.times {
            file << new Random().nextInt(max) + '\n'
        }
        println "File is filled: " + file.absolutePath
    }

}
