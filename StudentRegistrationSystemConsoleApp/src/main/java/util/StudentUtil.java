package util;

import beans.Student;
import org.example.Config;

public class StudentUtil {
    public static Student fillStudent() {
        String name = MenuUtil.requireName();
        String surname = MenuUtil.requireSurname();
        int age = MenuUtil.requireAge();
        String className = MenuUtil.requireClassNAme();


        Student st = new Student(name, surname, age, className);
        return st;
    }

    public static void printAllRegisteredStudents() {
        if (Config.students == null) {
            return;
        }
        for (int i = 0; i < Config.students.length; i++) {
            Student st = Config.students[i];
            System.out.println((i + 1) + ". " + st.getFullInfo());
        }
    }

    public static void registerStudent() {
        int count = InputUtil.requireNumber("How many students you will register?");
        Config.students = new Student[count];

        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ".Register");
            Config.students[i] = StudentUtil.fillStudent();
        }

        MenuUtil.showSuccessOpMessage();
        StudentUtil.printAllRegisteredStudents();
    }

    public static void findStudentsAndPrint() {
        String text = InputUtil.requireText("type name, surname or class name");
        Student[] findedStudents = findStudents(text);
        for (int i = 0; i < findedStudents.length; i++) {
            System.out.println(findedStudents[i].getFullInfo());
        }

    }

    public static Student[] findStudents(String text) {
        int count = 0;
        for (int i = 0; i < Config.students.length; i++) {
            Student st = Config.students[i];
            if (st.getName().contains(text) || st.getSurname().contains(text) || st.getClassName().contains(text)) {
                count++;
            }
        }

        Student[] result = new Student[count];
        int found = 0;
        for (int i = 0; i < Config.students.length; i++) {
            Student st = Config.students[i];
            if (st.getName().contains(text) || st.getSurname().contains(text) || st.getClassName().contains(text)) {
                result[found++] = st;
            }
        }
        return result;

    }

    public static void updateStudentWithNewObj() {
        StudentUtil.printAllRegisteredStudents();
        int i = InputUtil.requireNumber("Enter which student you want to update");

        System.out.println("Enter new information");
        Student s = StudentUtil.fillStudent();

        Config.students[i - 1] = s;
    }

    public static void updateStudentWithSameObj() {
        StudentUtil.printAllRegisteredStudents();
        int i = InputUtil.requireNumber("Enter which student you want to update");

        System.out.println("Enter new information");
        Student selectedStudent = Config.students[i - 1];
        String changeParam = InputUtil.requireText("What do you want to change? For example 'name','surname','age','class name'");

        if (changeParam.contains("'name'")) {
            selectedStudent.setName(MenuUtil.requireName());
        }
        if (changeParam.contains("'surname'")) {
            selectedStudent.setSurname(MenuUtil.requireSurname());
        }
        if (changeParam.contains("'age'")) {
            selectedStudent.setAge(MenuUtil.requireAge());
        }
        if (changeParam.contains("'class name'")) {
            selectedStudent.setClassName(MenuUtil.requireClassNAme());
        }
    }

    public static void updateStudentWithSplit() {
        StudentUtil.printAllRegisteredStudents();
        int index = InputUtil.requireNumber("Enter which student you want to update");

        System.out.println("Enter new information");
        Student selectedStudent = Config.students[index - 1];
        String changeParam = InputUtil.requireText("What do you want to change? For example name, surname, age, class name");

        String[] parameters = changeParam.split(",");
        for (int i = 0; i < parameters.length; i++) {
            String param = parameters[i];
            if (param.equalsIgnoreCase("name")) {
                selectedStudent.setName(MenuUtil.requireName());
            } else if (param.equalsIgnoreCase("surname")) {
                selectedStudent.setSurname(MenuUtil.requireSurname());
            } else if (param.equalsIgnoreCase("age")) {
                selectedStudent.setAge(MenuUtil.requireAge());
            } else if (param.equalsIgnoreCase("class name")) {
                selectedStudent.setClassName(MenuUtil.requireClassNAme());
            }
        }

    }
}