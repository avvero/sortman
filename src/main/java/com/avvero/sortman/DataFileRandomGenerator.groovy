package com.avvero.sortman

/**
 * Генерация файла с количеством строк length со случайным набором целых чисел в диапазоне max
 * @author fxdev-belyaev-ay
 */
class DataFileRandomGenerator {

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
