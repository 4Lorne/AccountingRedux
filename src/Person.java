public abstract class Person {
    //Variables
    private String name;
    private String address;
    private int years;

    //Constructor
    Person(String name, String address, int years){
        this.name = name;
        this.address = address;
        this.years = years;
    }

    //Getters
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public double getYears() {
        return years;
    }
}
