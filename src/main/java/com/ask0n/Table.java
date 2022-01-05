package com.ask0n;

public class Table {
    private static final String OUTPUT_FORMAT = "| %-5s | %-25s | %-30s |\n";
    private static final String DELIMITER = "+-------+---------------------------+--------------------------------+";

    public void delimiter() {
        System.out.println(DELIMITER);
    }

    public void create() {
        delimiter();
        System.out.format(OUTPUT_FORMAT, "#", "X", "function");
        delimiter();
    }

    public void insert(Object rowNum, Object x, Object text) {
        System.out.format(OUTPUT_FORMAT, rowNum, x, text);
    }
}
