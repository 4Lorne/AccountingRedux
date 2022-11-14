import javax.swing.*;
import java.lang.reflect.Array;
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
        String studentOutput = buildString(studentArrayList);
        String teacherOutput = buildTeacher(teacherArrayList);
        JOptionPane.showInternalMessageDialog(null,"Student total: " +
                studentArrayList.size() +"\n"+studentOutput+"\nStaff total:"+teacherArrayList.size()+"\n"+teacherOutput,"Information",JOptionPane.INFORMATION_MESSAGE);

    }

    String buildString(ArrayList<Student>student){
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
}
