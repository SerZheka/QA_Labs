package classes;

import java.time.LocalDate;

public class Student {
    private int id;
    private String surname;
    private String name;
    private String patronymic;
    private PersonalInfo personalInfo;

    public static class PersonalInfo {
        private LocalDate dateOfBirth;
        private String address;
        private String phone;

        public PersonalInfo() {
        }

        public PersonalInfo(LocalDate dateOfBirth, String address, String phone) {
            this.dateOfBirth = dateOfBirth;
            this.address = address;
            this.phone = phone;
        }

        public LocalDate getDateOfBirth() {
            return dateOfBirth;
        }

        public String getAddress() {
            return address;
        }

        public String getPhone() {
            return phone;
        }

        @Override
        public String toString() {
            return "{" +
                    "dateOfBirth=" + dateOfBirth +
                    ", address='" + address + '\'' +
                    ", phone='" + phone + '\'' +
                    '}';
        }
    }

    public static class UniversityInfo {
        private String faculty;
        private int course;
        private int group;

        public UniversityInfo() {
        }

        public UniversityInfo(String faculty, int course, int group) {
            this.faculty = faculty;
            this.course = course;
            this.group = group;
        }

        public String getFaculty() {
            return faculty;
        }

        public int getCourse() {
            return course;
        }

        public int getGroup() {
            return group;
        }

        @Override
        public String toString() {
            return "{" +
                    "faculty='" + faculty + '\'' +
                    ", course=" + course +
                    ", group=" + group +
                    '}';
        }
    }

    public Student() {
    }

    public Student(int id, String surname, String name, String patronymic, PersonalInfo personalInfo, UniversityInfo universityInfo) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.personalInfo = personalInfo;
        this.universityInfo = universityInfo;
    }

    private UniversityInfo universityInfo;

    public int getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public PersonalInfo getPersonalInfo() {
        return personalInfo;
    }

    public UniversityInfo getUniversityInfo() {
        return universityInfo;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", personalInfo=" + personalInfo +
                ", universityInfo=" + universityInfo +
                '}';
    }
}
