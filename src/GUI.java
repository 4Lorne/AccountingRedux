import javax.swing.*;
import java.util.ArrayList;

public class GUI extends JPanel {
    ArrayList<Student> studentArrayList = new ArrayList<>();
    ArrayList<Teacher> teacherArrayList = new ArrayList<>();

    StringBuilder sb = new StringBuilder();

    public int getChoice() {
        return choice;
    }

    private int choice;

    void launch(){
        String [] choices = {"Student", "Staff", "Finish"};
        choice = JOptionPane.showOptionDialog(null,"Select Student or Staff","Accounting App",JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,choices,choices[1]);

        switch (choice) {
            case 0 -> {
                studentChoice();
                return;
            }
            case 1 -> {
                teacherChoice();
                return;
            }
        }
    }

    void studentChoice(){
        String year = JOptionPane.showInputDialog("Enter student year(1-4)");
        String name = JOptionPane.showInputDialog("Enter student name");
        String address = JOptionPane.showInputDialog("Enter student address");

        int yearInt = Integer.parseInt(year);

        studentArrayList.add(new Student(name,address,yearInt));

    }

    void teacherChoice(){
        String name = JOptionPane.showInputDialog("Enter staff name");
        String address = JOptionPane.showInputDialog("Enter staff address");
        String year = JOptionPane.showInputDialog("Enter staff years of service");

        int yearInt = Integer.parseInt(year);

        teacherArrayList.add(new Teacher(name,address,yearInt));
    }

    void printReport(){
        String studentOutput = buildStudent(studentArrayList);
        String teacherOutput = buildTeacher(teacherArrayList);
        String resultsOutput = buildResults(studentArrayList,teacherArrayList);
        JOptionPane.showInternalMessageDialog(null,"Student total: " +
                studentArrayList.size() +"\n"+studentOutput+"\nStaff total:"+teacherArrayList.size()+"\n"+teacherOutput+"\n\n\n"+resultsOutput,"Information",JOptionPane.INFORMATION_MESSAGE);

    }

    String buildStudent(ArrayList<Student>student){
        for (int i = 0; i < student.size();i++){
            sb.append(i+1+"). ").append(student.get(i).toString()).append("\n");
        }
        return sb.toString();
    }

    String buildTeacher(ArrayList<Teacher>teacher){
        sb.setLength(0);
        for (int i = 0; i < teacher.size();i++){
            sb.append(i+1+"). ").append(teacher.get(i).toString()).append("\n");
        }
        return sb.toString();
    }

    String buildResults(ArrayList<Student>student, ArrayList<Teacher> teacher){
        sb.setLength(0);
        double totalStudent = 0;
        double totalTeacher = 0;

        for (Student value : studentArrayList) {
            totalStudent += value.getTuition();
        }

        for (Teacher value : teacherArrayList) {
            totalTeacher += value.getSalary();
        }

        totalStudent = totalStudent / 2;
        totalTeacher = totalTeacher / 26;

        sb.append("Results:\n");
        sb.append("Outgoing: %.2f").append(totalStudent).append("\n");
        sb.append("Incoming: %.2f").append(totalTeacher).append("\n");
        sb.append("Total: %.2f").append(totalStudent+totalTeacher).append("\n");
        return sb.toString();
    }
}
