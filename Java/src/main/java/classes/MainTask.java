package classes;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class MainTask {
    private static final List<Student> students = Arrays.asList(
            new Student(1, "Иванов", "Иван", "Иванович",
                    new Student.PersonalInfo(LocalDate.parse("2001-05-21"), "Свердлова 13а", "33 251 65 48"),
                    new Student.UniversityInfo("ФИТ", 3, 2)),
            new Student(2, "Сергеев", "Сергей", "Сергеевич",
                    new Student.PersonalInfo(LocalDate.parse("2002-06-03"), "Михалова 26", "29 351 29 02"),
                    new Student.UniversityInfo("ФИТ", 2, 1)),
            new Student(3, "Петров", "Петр", "Петрович",
                    new Student.PersonalInfo(LocalDate.parse("2001-10-20"), "Независимости 114", "44 705 46 00"),
                    new Student.UniversityInfo("ФИТ", 3, 2)),
            new Student(4, "Товпеко", "Илья", "Сергеевич",
                    new Student.PersonalInfo(LocalDate.parse("2002-12-15"), "Победителей 145", "29 505 98 47"),
                    new Student.UniversityInfo("ФИТ", 3, 2)),
            new Student(5, "Симакович", "Владислав", "Максимович",
                    new Student.PersonalInfo(LocalDate.parse("2003-01-12"), "Кирова 3", "33 768 21 08"),
                    new Student.UniversityInfo("ИДиП", 1, 2))
    );

    public static void main(String[] args) {
        StudentAction studentAction = new StudentAction(students);

        System.out.println("Список студентов ФИТа:");
        studentAction.getStudentsFromFaculty("ФИТ").forEach(System.out::println);
        System.out.println();

        System.out.println("Списки студентов для каждого факультета и курса:");
        studentAction.printStudentsForEveryFacultyAndCourse();

        System.out.println("Список студентов, родившихся после 2002 года:");
        studentAction.getStudentsBornAfter(2002).forEach(System.out::println);
        System.out.println();

        System.out.println("Список студентов 2 группы 3 курса ФИТа:");
        studentAction.getStudentsInGroup("ФИТ", 3, 2).forEach(System.out::println);
    }
}
