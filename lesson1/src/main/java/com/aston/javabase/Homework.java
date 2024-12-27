package com.aston.javabase;

import java.util.ArrayList;
import java.util.List;

public class Homework {

    public static void main(String[] args) {
        System.out.println(isPalindrome("aba"));    // true
        System.out.println(isPalindrome("112211")); // true
        System.out.println(isPalindrome("abc"));    // false
        System.out.println(isPalindrome("112233")); // false

        int[] arr = {10, 15, 23, 11, 44, 13, 66, 1, 6, 47};
        System.out.println(findSecondMaxElement(arr));  // 47

        System.out.println(lengthOfLastWord("Hello world"));                    // 5
        System.out.println(lengthOfLastWord("   fly me   to the moon    "));    // 4

        turnString("I love Java");
        System.out.println();
        getDistinctNumbers(new int[]{1, 2, 2, 3, 4, 5, 5, 6, 7, 8, 8, 9});
    }

    // Перевернуть строку и вывести на консоль
    //  String string = "I love Java";
    public static void turnString(String string) {
        for (int i = string.length() - 1; i >= 0; i--) {
            System.out.print(string.charAt(i));
        }
    }

    // int[] ints = {1, 2, 2, 3, 4, 5, 5, 6, 7, 8, 8, 9};
    // Удалить дубликаты из массива и вывести в консоль
    public static void getDistinctNumbers(int[] ints) {
        List<Integer> uniqueInts = new ArrayList<>();
        for (int anInt : ints) {
            if (uniqueInts.contains(anInt)) {
                continue;
            }
            uniqueInts.add(anInt);
        }
        System.out.println(uniqueInts);
    }

    // Дан массив, заполненный уникальными значениями типа int.
    // int[] arr = {10, 15, 23, 11, 44, 13, 66, 1, 6, 47};
    // Необходимо найти элемент, который меньше максимума, но больше всех остальных.
    public static Integer findSecondMaxElement(int[] arr) {
        if (arr.length < 2) {
            return Integer.MIN_VALUE;
        }
        int max = arr[0];
        int secondMax = Integer.MIN_VALUE;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                secondMax = max;
                max = arr[i];
            } else if (arr[i] > secondMax) {
                secondMax = arr[i];
            }
        }
        return secondMax;
    }

    // Найти длину последнего слова в строке. В строке только буквы и пробелы.
    // "Hello world" - 5
    // "    fly me    to the moon    " - 4
    public static Integer lengthOfLastWord(String string) {
        String trimmed = string.trim();
        int lastIndexOfSpace = trimmed.lastIndexOf(' ');
        return trimmed.substring(lastIndexOfSpace + 1).length();
    }

    // Определить, что строка является палиндромом
    // Сложность по памяти O(1), не создавать новые String, StringBuilder
    // Примеры:
    // abc - false
    // 112233 - false
    // aba - true
    // 112211 - true
    public static boolean isPalindrome(String string) {
        if (string == null || string.isEmpty()) {
            return false;
        }
        if (string.length() == 1) {
            return true;
        }
        for (int i = 0; i < string.length() / 2; i++) {
            if (string.charAt(i) != string.charAt(string.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
