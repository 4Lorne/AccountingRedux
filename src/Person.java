public abstract class Person {
    //Variables
    private final String name;
    private final String address;
    private final int years;

    //Constructor
    Person(String name, String address, int years) {
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
