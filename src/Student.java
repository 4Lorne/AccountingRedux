public class Student extends Person {
    //Variables
    private final double tuition;

    //Constructor
    Student(String name, String address, int years) {
        super(name, address, years);
        this.tuition = 2900 + (100 * years);
    }

    @Override
    public String toString() {
        return String.format("Name: " + getName() + " Address: " + getAddress() + " Year: %.0f Tuition: $" + getTuition(), getYears());
    }

    //Getter
    public double getTuition() {
        return tuition;
    }
}
