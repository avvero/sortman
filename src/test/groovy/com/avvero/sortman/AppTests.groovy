package com.avvero.sortman

import com.avvero.sortman.handler.ArrayListHandler
import com.avvero.sortman.handler.TreeSetHandler
import spock.lang.Specification
import spock.lang.Unroll

/**
 * @author fxdev-belyaev-ay
 */
class AppTests extends Specification {

    @Unroll
    def "Sort file #fileName with #handler"() {
        expect:
            readAndSort(fileName, handler).size() == 10
        where:
            fileName      | handler
            "random1.txt" | new TreeSetHandler<Long>(10)
            "random1.txt" | new ArrayListHandler<Long>(10)
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
        return handler.result()
    }
}
