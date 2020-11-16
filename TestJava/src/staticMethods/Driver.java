package staticMethods;

public class Driver {
    public static void main(String[] args) {
        A a= new A();
        B b= new B();
        A ab= new B();

        A.show();
        B.show();
    }
}
