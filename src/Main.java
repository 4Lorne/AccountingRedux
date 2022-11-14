public class Main {
    public static void main(String[] args) {
        GUI myGUI = new GUI();

        do {
            myGUI.launch();
        } while (!(myGUI.getChoice() == 2));

        myGUI.printReport();


    }
}
