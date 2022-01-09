package com.ask0n;

public class Table {
    private static final String OUTPUT_FORMAT = "| %-5s | %-20s | %-25s | %-25s | %-25s |%n";
    private static final String DELIMITER = "+-------+----------------------+---------------------------+---------------------------+---------------------------+";
    private int rowNum;

    public Table() {
        this.rowNum = 1;
    }

    public void delimiter() {
        System.out.println(DELIMITER);
    }

    public void create() {
        delimiter();
        System.out.format(OUTPUT_FORMAT, "#", "DeltaX", "Function 1", "Function 2", "Result");
        delimiter();
    }

    public void insert(Object deltaX, Object f1, Object f2, Object result) {
        System.out.format(OUTPUT_FORMAT, rowNum++, deltaX, f1, f2, result);
    }
}
