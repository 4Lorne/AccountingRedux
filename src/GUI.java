import javax.swing.*;
import java.util.ArrayList;

public class GUI extends JPanel {
    //Variables
    ArrayList<Student> studentArrayList = new ArrayList<>();
    ArrayList<Teacher> teacherArrayList = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    private int choice;

    //Initial menu
    void launch(){
        String [] choices = {"Student", "Staff", "Finish"};
        choice = JOptionPane.showOptionDialog(null,"Select Student or Staff","Accounting App",JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,choices,choices[1]);

        switch (choice) {
            case 0 -> studentChoice();
            case 1 -> teacherChoice();
        }
    }

    //Takes input for student
    void studentChoice(){
        String year = JOptionPane.showInputDialog("Enter student year(1-4)");
        String name = JOptionPane.showInputDialog("Enter student name");
        String address = JOptionPane.showInputDialog("Enter student address");

        int yearInt = Integer.parseInt(year);

        studentArrayList.add(new Student(name,address,yearInt));

    }

    //Takes input for teacher
    void teacherChoice() {
        String name = JOptionPane.showInputDialog("Enter staff name");
        while (name.equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter valid information.", "Alert", JOptionPane.WARNING_MESSAGE);
            name = JOptionPane.showInputDialog("Enter staff name");
        }
        String address = JOptionPane.showInputDialog("Enter staff address");
        while (address.equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter valid information.", "Alert", JOptionPane.WARNING_MESSAGE);
            address = JOptionPane.showInputDialog("Enter staff address");
        }
        String year;
        int yearInt = 0;
        //TODO: Fix validation
        do {
                year = JOptionPane.showInputDialog("Enter staff years of service");
                if (year.matches("\"\\d\"gm")) {
                    yearInt = Integer.parseInt(year);
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter valid information.", "Alert", JOptionPane.WARNING_MESSAGE);
                    year = JOptionPane.showInputDialog("Enter staff years of service");
                }
        } while (yearInt > 0 && yearInt < 5);

        teacherArrayList.add(new Teacher(name, address, yearInt));
    }

    //Outputs the report
    void printReport(){
        String studentOutput = buildStudent(studentArrayList);
        String teacherOutput = buildTeacher(teacherArrayList);
        String resultsOutput = buildResults(studentArrayList,teacherArrayList);
        JOptionPane.showInternalMessageDialog(null,"Student total: " +
                studentArrayList.size() +"\n"+studentOutput+"\nStaff total:"
                +teacherArrayList.size()+"\n"+teacherOutput+"\n\n\n"+resultsOutput,
                "Information",JOptionPane.INFORMATION_MESSAGE);
    }

    //Builds student string
    String buildStudent(ArrayList<Student>student){
        for (int i = 0; i < student.size();i++){
            sb.append(i+1+"). ").append(student.get(i).toString()).append("\n");
        }
        return sb.toString();
    }

    //Builds teacher string
    String buildTeacher(ArrayList<Teacher>teacher){
        sb.setLength(0);
        for (int i = 0; i < teacher.size();i++){
            sb.append(i+1+"). ").append(teacher.get(i).toString()).append("\n");
        }
        return sb.toString();
    }

    //Prints results
    String buildResults(ArrayList<Student>student, ArrayList<Teacher> teacher){
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

        return String.format("Results\nOutgoing: $%.2f\nIncoming: $%.2f\nTotal: $%.2f",totalTeacher,totalStudent,totalOverall);
    }

    //Getter
    public int getChoice() {
        return choice;
    }
}
