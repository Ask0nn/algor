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
            num = intInput("Введите номер: ");
            if (num > 0) break;
            else System.out.println("Номер должен быть больше 0");
        }
        while (true) {
            deltaX = doubleInput("Введите deltaX (шаг): ");
            if (deltaX != 0) break;
            else System.out.println("DeltaX не должен быть равен 0. Введите заного");
        }
        while (true) {
            startValue = doubleInput("Введите стартовое значение: ");
            endValue = doubleInput("Введите конечное значение: ");
            if (deltaX < 0 ? endValue <= startValue : startValue <= endValue) break;
            else System.out.println("Ошибка ввода. Проверьте значения.");
        }
    }

    public static double doubleInput(String message) {
        System.out.print(message);
        Scanner in = new Scanner(System.in);
        while (true) {
            String input = in.nextLine();
            if (input == null) throw new NumberFormatException("Неверный формат числа, повторите ввод: ");
            try {
                return Double.parseDouble(input.replace(",", "."));
            } catch (NumberFormatException e) {
                System.out.print("Неверный формат числа, повторите ввод: ");
            }
        }

    }

    public static int intInput(String message) {
        System.out.print(message);
        Scanner in = new Scanner(System.in);
        while (true) {
            String input = in.nextLine();
            if (input == null) throw new NumberFormatException("Неверный формат числа, повторите ввод: ");
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.print("Неверный формат числа, повторите ввод: ");
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
        return Arrays.asList(first, second, Math.max(first, second));
    }

    private static double customLog(double base, double logNumber) {
        return Math.log(logNumber) / Math.log(base);
    }
}
