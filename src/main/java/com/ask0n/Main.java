package com.ask0n;

import java.util.Scanner;

public class Main {
    private static final MathFunctions mathFunctions = new MathFunctions();
    private static final Table table = new Table();

    private static double startValue;
    private static double endValue;
    private static double deltaX;
    private static int num;

    public static void main(String[] args) {
        int rowNum = 1;
        inputData();

        table.create();

        while (startValue <= endValue) {
            final double value;
            if (num % 2 == 0) {
                value = mathFunctions.funMax(startValue, num);
            } else {
                value = mathFunctions.funMin(startValue, num);
            }

            table.insert(rowNum++, startValue,
                    Double.isNaN(value) ? "Error" : value == 0 ? "Значение sin или cos равно 0" : String.valueOf(value));
            startValue += deltaX;
        }

        table.delimiter();
    }

    public static void inputData() {
        while (true) {
            startValue = doubleInput("Введите стартовое значение: ");
            endValue = doubleInput("Введите конечное значение: ");
            if (startValue < endValue) break;
            else System.out.println("Стартовое значение не может быть больше либо равно конечному.");
        }
        while (true) {
            deltaX = doubleInput("Введите deltaX (шаг): ");
            if (deltaX > 0) break;
            else System.out.println("Шаг должен быть больше 0");
        }
        while (true) {
            num = intInput("Введите номер: ");
            if (num > 0) break;
            else System.out.println("Номер должен быть больше 0");
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
                System.out.println("Неверный формат числа, повторите ввод: ");
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
                System.out.println("Неверный формат числа, повторите ввод: ");
            }
        }

    }
}
