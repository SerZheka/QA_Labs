package classes;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StudentAction {
    private final List<Student> students;

    public StudentAction(List<Student> students) {
        this.students = students;
    }

    public List<Student> getStudentsFromFaculty(String faculty) {
        return students.stream()
                .filter(student -> student.getUniversityInfo().getFaculty().equals(faculty))
                .collect(Collectors.toList());
    }

    public void printStudentsForEveryFacultyAndCourse() {
        Set<String> faculties = students.stream()
                .map(student -> student.getUniversityInfo().getFaculty())
                .collect(Collectors.toSet());
        for (String faculty : faculties) {
            System.out.printf("Факультет %s:\n", faculty);
            List<Student> studentsOfFaculty = students.stream()
                    .filter(student -> student.getUniversityInfo().getFaculty().equals(faculty))
                    .collect(Collectors.toList());
            Set<Integer> courses = studentsOfFaculty.stream()
                    .map(student -> student.getUniversityInfo().getCourse())
                    .collect(Collectors.toSet());
            for (Integer course : courses) {
                System.out.printf("Курс %d:\n", course);
                studentsOfFaculty.stream()
                        .filter(student -> student.getUniversityInfo().getCourse() == course)
                        .forEach(student -> System.out.printf("\t%s\n", student));
            }
            System.out.println();
        }
    }

    public List<Student> getStudentsBornAfter(int year) {
        return students.stream()
                .filter(student -> student.getPersonalInfo().getDateOfBirth().getYear() >= year)
                .collect(Collectors.toList());
    }

    public List<Student> getStudentsInGroup(String faculty, int course, int group) {
        return students.stream()
                .filter(student -> {
                    Student.UniversityInfo universityInfo = student.getUniversityInfo();
                    return universityInfo.getGroup() == group &&
                            universityInfo.getFaculty().equals(faculty) &&
                            universityInfo.getCourse() == course;
                })
                .collect(Collectors.toList());
    }
}
