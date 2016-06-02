package com.avvero.sortman

import com.avvero.sortman.handler.ArrayHandler
import com.avvero.sortman.handler.ArrayListHandler
import com.avvero.sortman.handler.TreeSetHandler
import spock.lang.Specification
import spock.lang.Unroll

/**
 * @author fxdev-belyaev-ay
 */
class AppTests extends Specification {

    @Unroll
    def "Sort file #fileName with #handler "() {
        expect:
            readAndSort(fileName, handler).size() != 0
        where:
            fileName                  | handler
            "random_7_10.txt"         | new TreeSetHandler(10)
            "random_7_10.txt"         | new ArrayListHandler(10)
            "random_7_10.txt"         | new ArrayHandler(10)

            "random_24_100.txt"       | new TreeSetHandler(10)
            "random_24_100.txt"       | new ArrayListHandler(10)
            "random_24_100.txt"       | new ArrayHandler(10)

            "random_10007_10000.txt"  | new TreeSetHandler(10)
            "random_10007_10000.txt"  | new ArrayListHandler(10)
            "random_10007_10000.txt"  | new ArrayHandler(10)

            "random_1000007_1000.txt" | new TreeSetHandler(10)
            "random_1000007_1000.txt" | new ArrayListHandler(10)
            "random_1000007_1000.txt" | new ArrayHandler(10)
    }

    def readAndSort(fileName, handler) {
        def file = new File(this.getClass().getResource(fileName).getFile())
        file.withReader { reader ->
            def line
            while (line = reader.readLine()) {
                def number = Long.parseLong(line);
                handler.put(number);
            }
        }
        def result = handler.result()
        println result
        return result
    }
}
