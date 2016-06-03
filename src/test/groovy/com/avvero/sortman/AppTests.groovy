package com.avvero.sortman

import com.avvero.sortman.handler.ArrayHandler
import com.avvero.sortman.handler.ArrayListHandler
import com.avvero.sortman.handler.BSArrayHandler
import com.avvero.sortman.handler.TreeSetHandler
import spock.lang.Ignore
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Tests for sortman
 * @author Avvero
 */
class AppTests extends Specification {

    @Unroll
    def "With #handler collection #collection will be sorted to #result"() {
        expect:
            sortCollection(collection, handler) == result
        where:
            handler                  | collection                                    || result
            new TreeSetHandler(10)   | []                                            || []
            new ArrayListHandler(10) | []                                            || []
            new ArrayHandler(10)     | []                                            || []
            new BSArrayHandler(10)   | []                                            || []

            new TreeSetHandler(10)   | [1]                                           || [1]
            new ArrayListHandler(10) | [1]                                           || [1]
            new ArrayHandler(10)     | [1]                                           || [1]
            new BSArrayHandler(10)   | [1]                                           || [1]

            new TreeSetHandler(10)   | [3, 2, 1]                                     || [1, 2, 3]
            new ArrayListHandler(10) | [3, 2, 1]                                     || [1, 2, 3]
            new ArrayHandler(10)     | [3, 2, 1]                                     || [1, 2, 3]
            new BSArrayHandler(10)   | [3, 2, 1]                                     || [1, 2, 3]

            new TreeSetHandler(10)   | [3, 2, 1, 6, 2, 2, 7]                         || [1, 2, 3, 6, 7]
            new ArrayListHandler(10) | [3, 2, 1, 6, 2, 2, 7]                         || [1, 2, 3, 6, 7]
            new ArrayHandler(10)     | [3, 2, 1, 6, 2, 2, 7]                         || [1, 2, 3, 6, 7]
            new BSArrayHandler(10)   | [3, 2, 1, 6, 2, 2, 7]                         || [1, 2, 3, 6, 7]

            new TreeSetHandler(10)   | [91, 8, 7, 16, 5, 4, 3, 2, 1, 10, 67, 78, 89] || [4, 5, 7, 8, 10, 16, 67, 78, 89, 91]
            new ArrayListHandler(10) | [91, 8, 7, 16, 5, 4, 3, 2, 1, 10, 67, 78, 89] || [4, 5, 7, 8, 10, 16, 67, 78, 89, 91]
            new ArrayHandler(10)     | [91, 8, 7, 16, 5, 4, 3, 2, 1, 10, 67, 78, 89] || [4, 5, 7, 8, 10, 16, 67, 78, 89, 91]
            new BSArrayHandler(10)   | [91, 8, 7, 16, 5, 4, 3, 2, 1, 10, 67, 78, 89] || [4, 5, 7, 8, 10, 16, 67, 78, 89, 91]
    }

    @Unroll
    def "Sort file #fileName with #handler for timer"() {
        expect:
            sortFile(fileName, handler).size() != 0
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

    def sortFile(fileName, handler) {
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

    def sortCollection(Collection collection, handler) {
        collection.each { it -> handler.add(it) }
        def result = handler.result()
        println result
        return new ArrayList(result)
    }
}
