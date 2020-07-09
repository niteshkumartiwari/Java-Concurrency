package HashCodeAndEquals;

import java.util.Objects;

public class Employee implements Comparable<Employee>{
    private String name;
    private int empNo;
    private int salary;

    public Employee(String name, int empNo, int salary) {
        this.name = name;
        this.empNo = empNo;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return empNo == employee.empNo &&
                salary == employee.salary &&
                name.equals(employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, empNo, salary);
    }

    @Override
    public int compareTo(Employee o) {
        return name.compareTo(o.name);
    }
}
