package HashCodeAndEquals;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class Driver {
    public static void main(String[] args) {
        Employee emp1= new Employee("Ram",1,100);
        Employee emp2= new Employee("Shyam",2,200);
        Employee emp3= new Employee("Radhe",3,300);

        Map<Employee,String> mapper= new TreeMap<>();// no need to override tohashCode() and equals()
        mapper.put(emp1,emp1.getName());
        mapper.put(emp2,emp2.getName());
        mapper.put(emp3,emp3.getName());


        System.out.println("Employee2 Name: "+mapper.get(emp2));
        System.out.println("Employee1 Name: "+mapper.get(emp1));
        System.out.println("Employee3 Name: "+mapper.get(emp3));

    }
}
