public class Student extends Person{
    public double getTuition() {
        return tuition;
    }

    private double tuition;


    Student(String name, String address, int years){
        super(name,address,years);
        this.tuition = 3000;
    }

    @Override
    public String toString(){
        return "Name: "+getName()+" Address: "+getAddress()+" Year: "+getYears();
    }


}
