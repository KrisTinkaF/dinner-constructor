package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static DinnerConstructor dc;
    static Scanner scanner;

    public static void main(String[] args) {
        dc = new DinnerConstructor();
        scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            String command = scanner.nextLine();

            switch (command) {
                case "1":
                    addNewDish();
                    break;
                case "2":
                    generateDishCombo();
                    break;
                case "3":
                    return;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Выход");
    }

    private static void addNewDish() {
        System.out.println("Введите тип блюда:");
        String dishType = scanner.nextLine().trim().toUpperCase();
        System.out.println("Введите название блюда:");
        String dishName = scanner.nextLine().trim();
        dc.saveDishes(dishType, dishName);
    }

    private static void generateDishCombo() {
        System.out.println("Начинаем конструировать обед...");

        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        int numberOfCombos = scanner.nextInt();
        scanner.nextLine();
        if (numberOfCombos != 0) {

            System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). Для завершения ввода введите пустую строку");
            String nextItem = scanner.nextLine().trim().toUpperCase();
            ArrayList<String> dishTypes = new ArrayList<>();

            while (!nextItem.isEmpty()) {
                boolean typeExist = dc.checkType(nextItem);
                if (typeExist) {
                    dishTypes.add(nextItem);
                    nextItem = scanner.nextLine().trim().toUpperCase();
                } else {
                    System.out.println("Такого типа блюда не существует");
                    break;
                }
            }
            dc.generateCombos(numberOfCombos, dishTypes);
        } else {
            System.out.println("Недопустимое значение!");
        }
    }
}
