public abstract class Person {

    private String name;
    private String address;

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public double getYears() {
        return years;
    }

    private int years;

    Person(String name, String address, int years){
        this.name = name;
        this.address = address;
        this.years = years;
    }


}
