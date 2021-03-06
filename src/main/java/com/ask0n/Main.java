package com.ask0n;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Table table = new Table();

    private static double startValue;
    private static double endValue;
    private static double deltaX;
    private static int num;

    public static void main(String[] args) {
        inputData();
        table.create();

        while (deltaX < 0 ? endValue <= startValue : startValue <= endValue) {
            final List<Double> value;
            if (num % 2 == 0) {
                value = funMax(startValue, num);
            } else {
                value = funMin(startValue, num);
            }

            table.insert(startValue, value.get(0), value.get(1), Double.isNaN(value.get(2)) ? "Error" : value.get(2));
            startValue += deltaX;
        }

        table.delimiter();
    }

    public static void inputData() {
        while (true) {
            num = intInput("??????? ?????: ");
            if (num > 0) break;
            else System.out.println("????? ?????? ???? ?????? 0");
        }
        while (true) {
            deltaX = doubleInput("??????? deltaX (???): ");
            if (deltaX != 0) break;
            else System.out.println("DeltaX ?? ?????? ???? ????? 0. ??????? ??????");
        }
        while (true) {
            startValue = doubleInput("??????? ????????? ????????: ");
            endValue = doubleInput("??????? ???????? ????????: ");
            if (deltaX < 0 ? endValue <= startValue : startValue <= endValue) break;
            else System.out.println("?????? ?????. ????????? ????????.");
        }
    }

    public static double doubleInput(String message) {
        System.out.print(message);
        Scanner in = new Scanner(System.in);
        while (true) {
            String input = in.nextLine();
            if (input == null) throw new NumberFormatException("???????? ?????? ?????, ????????? ????: ");
            try {
                return Double.parseDouble(input.replace(",", "."));
            } catch (NumberFormatException e) {
                System.out.print("???????? ?????? ?????, ????????? ????: ");
            }
        }

    }

    public static int intInput(String message) {
        System.out.print(message);
        Scanner in = new Scanner(System.in);
        while (true) {
            String input = in.nextLine();
            if (input == null) throw new NumberFormatException("???????? ?????? ?????, ????????? ????: ");
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.print("???????? ?????? ?????, ????????? ????: ");
            }
        }

    }

    public static List<Double> funMax(double xDelta, int num) {
        final double first = customLog((1 - num) / Math.sin(xDelta + num), 21);
        final double second = Math.abs(Math.cos(xDelta) / num);
        return Arrays.asList(first, second, Math.max(first, second));
    }

    public static List<Double> funMin(double xDelta, int num) {
        final double first = customLog((1 - num) / Math.cos(xDelta - num), 21);
        final double second = Math.sin(xDelta) / num;
        return Arrays.asList(first, second, Math.min(first, second));
    }

    private static double customLog(double logNumber, double base) {
        return Math.log(logNumber) / Math.log(base);
    }
}
