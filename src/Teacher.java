public class Teacher extends Person {
    //Variables
    private final double salary;

    //Constructor
    public Teacher(String name, String address, int years){
        super(name,address,years);
        this.salary = 50000 + (500*years);
    }

    @Override
    public String toString(){
        return String.format("Name: "+getName()+" Address: "+getAddress()+" Year: %.0f Tuition: $"+getSalary(),getYears());
    }

    //Getters
    public double getSalary() {
        return salary;
    }
}
