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
        JOptionPane.showInternalMessageDialog(null,"Students: " + studentArrayList.size() , "Information",JOptionPane.INFORMATION_MESSAGE);

    }
}
