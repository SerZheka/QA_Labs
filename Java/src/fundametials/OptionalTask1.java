package fundametials;

import java.util.*;
import java.util.stream.Collectors;

public class OptionalTask1 {
    public static void main(String[] args) {
        System.out.println("Введите массив чисел:");
        String[] array = new Scanner(System.in)
                .nextLine()
                .split(" ");

        System.out.println("Отсортированный по длине числа массив:");
        Arrays.stream(array)
                .sorted(Comparator.comparingInt(String::length))
                .forEach(number -> System.out.printf("%s ", number));
        System.out.println();

        int mediumLength = (int) Arrays.stream(array)
                .mapToInt(String::length)
                .average()
                .orElse(0);
        System.out.printf("Среднее значение длины: %d\n", mediumLength);
        System.out.println("Числа больше средней длины или равные ей:");
        Arrays.stream(array)
                .filter(value -> value.length() >= mediumLength)
                .forEach(number -> System.out.printf("%s ", number));
        System.out.println();

        System.out.printf("Число с минимальным количеством различных чисел: %s\n",
                Arrays.stream(array)
                        .min(Comparator.comparingInt(value ->
                                value.chars()
                                        .mapToObj(c -> (char) c)
                                        .collect(Collectors.toCollection(HashSet::new))
                                        .size()))
                        .orElse("")
        );
    }
}
