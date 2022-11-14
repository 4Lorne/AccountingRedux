public class Student extends Person{
    public double getTuition() {
        return tuition;
    }

    private double tuition;


    Student(String name, String address, int years){
        super(name,address,years);
        this.tuition = 2900 + (100 * years);
    }

    @Override
    public String toString(){
        return String.format("Name: "+getName()+" Address: "+getAddress()+" Year: %.0f Tuition: "+getTuition(),getYears());
    }


}
