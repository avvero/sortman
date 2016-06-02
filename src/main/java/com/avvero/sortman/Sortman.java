package com.avvero.sortman;

import com.avvero.sortman.exeptions.SortmanException;
import com.avvero.sortman.handler.HandlerFactory;
import com.avvero.sortman.handler.IHandler;

import java.io.*;
import java.util.Arrays;

import static java.util.stream.Collectors.joining;

/**
 * TODO Назначение программы
 * @author fxdev-belyaev-ay
 */
public class Sortman {

    public static void main(String[] args) throws IOException {
        try {
            validateArguments(args);
        } catch (SortmanException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
        int n = Integer.parseInt(args[0]);
        File file = new File(args[1]);
        IHandler handler = new HandlerFactory().getHandler(n);
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                long number = Long.parseLong(line);
                handler.put(number);
            }
        }
        String resultString = handler.result().stream().map(i -> i.toString()).collect(joining(", "));
        System.out.println(resultString);
    }

    /**
     * Валидация параметров:
     * - прааметра должно быть два
     * - первый параметр должен быть целым числом, большим нуля
     * - второй параметр - путь к существующему файлу с данными
     * @param args
     */
    private static void validateArguments(String[] args) throws SortmanException {
        int n;
        if(args.length != 2) {
            throw new SortmanException("Required two parameters to perform operation: [size(int) of result list] [file name with number-per-line data]");
        }
        try{
            n = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            throw new SortmanException("Size of the result list must be integer");
        }
        if (n <= 0) {
            throw new SortmanException("Size of the result list must be greater than zero");
        }
        if(!new File(args[1]).exists()) {
            throw new SortmanException(String.format("File '%s' does not exists", args[1]));
        }
    }

}
