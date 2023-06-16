package util;

public class MenuUtil {
    public static void processMenu(int selectedMenu) {
        switch (selectedMenu) {
            case 1:
                StudentUtil.registerStudent();
                break;
            case 2:
                StudentUtil.printAllRegisteredStudents();
                break;
            case 3:
                StudentUtil.findStudentsAndPrint();
                break;
            case 4:
                StudentUtil.updateStudentWithNewObj();
                break;
            case 5:
                System.exit(0);
                break;
            default:
                break;
        }
    }

    public static String requireName() {
        return InputUtil.requireText("enter name");
    }

    public static String requireSurname() {
        return InputUtil.requireText("enter surname");
    }

    public static int requireAge() {
        return InputUtil.requireNumber("enter age");
    }

    public static String requireClassNAme() {
        return InputUtil.requireText("enter class");
    }

    public static void showSuccessOpMessage() {
        System.out.println("Operation completed successfully");
    }
}
