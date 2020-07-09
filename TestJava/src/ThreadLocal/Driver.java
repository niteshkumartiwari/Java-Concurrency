package ThreadLocal;

public class Driver {
    public static void main(String[] args) {
        User user1= new User("ram",10);
        Service1 service1= new Service1();
        Service2 service2= new Service2();

        service1.process1(user1);
        System.out.println(service2.process());
    }
}
