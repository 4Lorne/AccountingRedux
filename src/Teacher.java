public class Teacher extends Person {
    private double salary;

    public Teacher(String name, String address, int years){
        super(name,address,years);
        this.salary = 3000;
    }

    @Override
    public String toString(){
        return "Name: "+getName()+" Address: "+getAddress()+" Year: "+getYears();
    }


}
