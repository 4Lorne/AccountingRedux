import javax.swing.*;
import java.util.ArrayList;

public class GUI extends JPanel {
    //Variables
    ArrayList<Student> studentArrayList = new ArrayList<>();
    ArrayList<Teacher> teacherArrayList = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    private String name;
    private String address;
    private int yearInt;
    private int choice;

    //Initial menu
    void launch() {
        String[] choices = {"Student", "Staff", "Finish"};
        choice = JOptionPane.showOptionDialog(null, "Select Student or Staff", "Accounting App", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, choices, choices[1]);

        switch (choice) {
            case 0 -> studentChoice();
            case 1 -> teacherChoice();
        }
    }

    //Takes input for student
    void studentChoice() {
        yearInt = validateIntStudent();

        name = JOptionPane.showInputDialog("Enter student name");
        while (name.equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter valid information.", "Alert", JOptionPane.WARNING_MESSAGE);
            name = JOptionPane.showInputDialog("Enter student name");
        }
        address = JOptionPane.showInputDialog("Enter student address");
        while (address.equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter valid information.", "Alert", JOptionPane.WARNING_MESSAGE);
            address = JOptionPane.showInputDialog("Enter student address");
        }

        studentArrayList.add(new Student(name, address, yearInt));

    }

    //Takes input for teacher
    void teacherChoice() {
        name = JOptionPane.showInputDialog("Enter staff name");
        while (name.equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter valid information.", "Alert", JOptionPane.WARNING_MESSAGE);
            name = JOptionPane.showInputDialog("Enter staff name");
        }
        address = JOptionPane.showInputDialog("Enter staff address");
        while (address.equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter valid information.", "Alert", JOptionPane.WARNING_MESSAGE);
            address = JOptionPane.showInputDialog("Enter staff address");
        }
        yearInt = validateIntTeacher();
        teacherArrayList.add(new Teacher(name, address, yearInt));
    }

    //Regex to validate teacher
    int validateIntTeacher() {
        String year = "";
        while (!year.matches("[0-9]+")) {
            year = JOptionPane.showInputDialog("Enter staff years of service");
            if (year.matches("[A-Z]+") || year.matches("[a-z]+")) {
                JOptionPane.showMessageDialog(null, "Please enter a number", "Alert", JOptionPane.WARNING_MESSAGE);
            }
            if (year.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter valid information.", "Alert", JOptionPane.WARNING_MESSAGE);
            }
        }
        yearInt = Integer.parseInt(year);
        if (yearInt >= 30 || yearInt < 1) {
            JOptionPane.showMessageDialog(null, "Please enter a number between 1-29.", "Alert", JOptionPane.WARNING_MESSAGE);
            validateIntTeacher();
        }
        return yearInt;
    }

    //Regex to validate student
    int validateIntStudent() {
        String year = "";
        while (!year.matches("[0-9]+")) {
            year = JOptionPane.showInputDialog("Enter student year(1-4)");
            if (year.matches("[A-Z]+") || year.matches("[a-z]+")) {
                JOptionPane.showMessageDialog(null, "Please enter a number", "Alert", JOptionPane.WARNING_MESSAGE);
            }
            if (year.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter valid information.", "Alert", JOptionPane.WARNING_MESSAGE);
            }
        }
        yearInt = Integer.parseInt(year);
        if (yearInt > 4 || yearInt < 1) {
            JOptionPane.showMessageDialog(null, "Please enter a number between 1-4.", "Alert", JOptionPane.WARNING_MESSAGE);
            validateIntStudent();
        }
        return yearInt;
    }

    //Outputs the report
    void printReport() {
        String studentOutput = buildStudent(studentArrayList);
        String teacherOutput = buildTeacher(teacherArrayList);
        String resultsOutput = buildResults(studentArrayList, teacherArrayList);
        JOptionPane.showInternalMessageDialog(null, "Students: [Total:" +
                        studentArrayList.size() + "]\n" + studentOutput + "\nStaff:[Total:"
                        + teacherArrayList.size() + "]\n" + teacherOutput + "\n\n\n" + resultsOutput,
                "Information", JOptionPane.INFORMATION_MESSAGE);
    }

    //Builds student string
    String buildStudent(ArrayList<Student> student) {
        for (int i = 0; i < student.size(); i++) {
            sb.append(i + 1).append("). ").append(student.get(i).toString()).append("\n");
        }
        return sb.toString();
    }

    //Builds teacher string
    String buildTeacher(ArrayList<Teacher> teacher) {
        sb.setLength(0);
        for (int i = 0; i < teacher.size(); i++) {
            sb.append(i + 1).append("). ").append(teacher.get(i).toString()).append("\n");
        }
        return sb.toString();
    }

    //Prints results
    String buildResults(ArrayList<Student> student, ArrayList<Teacher> teacher) {
        sb.setLength(0);
        double totalStudent = 0;
        double totalTeacher = 0;
        double totalOverall;

        for (Student value : student) {
            totalStudent += value.getTuition();
        }

        for (Teacher value : teacher) {
            totalTeacher += value.getSalary();
        }

        totalStudent = totalStudent / 2;
        totalTeacher = totalTeacher / 26;
        totalOverall = totalStudent - totalTeacher;

        return String.format("Results\nOutgoing: $%.2f\nIncoming: $%.2f\nTotal: $%.2f", totalTeacher, totalStudent, totalOverall);
    }

    //Getter
    public int getChoice() {
        return choice;
    }
}
