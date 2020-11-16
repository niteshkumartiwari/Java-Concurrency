package HashCodeAndEquals;

public class Driver {
    public static void main(String[] args) {
        Employee e1= new Employee("ram",1);
        Employee e2= new Employee("ram",1);

        if(e1.equals(e2))
            System.out.println("Equal");
        else
            System.out.println("Not Equal");
    }
}
