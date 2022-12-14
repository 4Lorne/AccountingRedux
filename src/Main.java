public class Main {
    public static void main(String[] args) {
        GUI myGUI = new GUI();

        //Runs a loop of the initial menu until the user clicks finish.
        do {
            myGUI.launch();
        } while (!(myGUI.getChoice() == 2));

        //Prints the final report
        myGUI.printReport();

    }
}
