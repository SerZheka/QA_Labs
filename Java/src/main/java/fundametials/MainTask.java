package fundametials;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MainTask {
    public static void main(String[] args) {
        Scanner inputStream = new Scanner(System.in);
        System.out.print("Введите ваше имя: ");
        String inputUserName = inputStream.nextLine();
        System.out.printf("Здравствуйте, %s!\n\n", inputUserName);

        System.out.println("Аргументы командной строки в обратном порядке:");
        Arrays.stream(args).collect(Collectors.toCollection(LinkedList::new)).descendingIterator()
                .forEachRemaining(argument -> System.out.printf("%s ", argument));
        System.out.println("\n");

        System.out.print("Введите количество генерируемых чисел: ");
        int inputNumberOfDigits = inputStream.nextInt();
        System.out.printf("\n%d случайных чисел без перехода на новую строку:\n", inputNumberOfDigits);
        Random random = new Random();
        IntStream.range(0, inputNumberOfDigits).forEach(i -> System.out.printf("%d ", random.nextInt(100)));
        System.out.println("\nС переходом на новую строку:");
        IntStream.range(0, inputNumberOfDigits).forEach(i -> System.out.printf("%d\n", random.nextInt(100)));
        System.out.println();

        List<Integer> numbersInCommandLineArguments = Arrays.stream(args)
                .filter(number -> {
                    try {
                        Integer.parseInt(number);
                        return true;
                    } catch (NumberFormatException e) {
                        return false;
                    }
                }).limit(2)
                .mapToInt(Integer::parseInt)
                .boxed().collect(Collectors.toList());
        if (numbersInCommandLineArguments.size() == 2)
            System.out.printf("Числа из командной строки: %d и %d\nСумма = %d\nПроизведение = %d\n\n",
                    numbersInCommandLineArguments.get(0),
                    numbersInCommandLineArguments.get(1),
                    numbersInCommandLineArguments.get(0) + numbersInCommandLineArguments.get(1),
                    numbersInCommandLineArguments.get(0) * numbersInCommandLineArguments.get(1));
        else
            System.out.println("В аргументах командной строки недостаточно чисел (необходимо минимум 2).\n");

        System.out.print("Введите число от 1 до 12 для вывода названия месяца: ");
        int numberOfMonth = inputStream.nextInt();
        if (numberOfMonth >= 1 && numberOfMonth <= 12)
            System.out.println(new SimpleDateFormat("MMMM").format(numberOfMonth - 1));
        else
            System.out.println("Введенное число должно быть в пределах от 1 до 12.");
    }

}
