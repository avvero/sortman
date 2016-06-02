package com.avvero.sortman

import com.avvero.sortman.handler.ArrayHandler
import com.avvero.sortman.handler.ArrayListHandler
import com.avvero.sortman.handler.BSArrayHandler
import com.avvero.sortman.handler.TreeSetHandler
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Tests for srtman
 * @author Avvero
 */
class AppTests extends Specification {

    @Unroll
    def "Sort file #fileName with #handler for timer"() {
        expect:
            readAndSort(fileName, handler).size() != 0
        where:
            fileName                  | handler
            "random_7_10.txt"         | new TreeSetHandler(25)
            "random_7_10.txt"         | new ArrayListHandler(25)
            "random_7_10.txt"         | new ArrayHandler(25)
            "random_7_10.txt"         | new BSArrayHandler(25)

            "random_24_100.txt"       | new TreeSetHandler(25)
            "random_24_100.txt"       | new ArrayListHandler(25)
            "random_24_100.txt"       | new ArrayHandler(25)
            "random_24_100.txt"       | new BSArrayHandler(25)

            "random_10007_10000.txt"  | new TreeSetHandler(25)
            "random_10007_10000.txt"  | new ArrayListHandler(25)
            "random_10007_10000.txt"  | new ArrayHandler(25)
            "random_10007_10000.txt"  | new BSArrayHandler(25)

            "random_1000007_1000.txt" | new TreeSetHandler(25)
            "random_1000007_1000.txt" | new ArrayListHandler(25)
            "random_1000007_1000.txt" | new ArrayHandler(25)
            "random_1000007_1000.txt" | new BSArrayHandler(25)
    }

    def readAndSort(fileName, handler) {
        def file = new File(this.getClass().getResource(fileName).getFile())
        file.withReader { reader ->
            def line
            while (line = reader.readLine()) {
                def number = Long.parseLong(line);
                handler.add(number);
            }
        }
        def result = handler.result()
        println result
        return result
    }
}
