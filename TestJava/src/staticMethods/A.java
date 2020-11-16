package staticMethods;

class A {
    public static void show(){
        System.out.println("A()::show");
    }
}

class B extends A{
    public static void show(){
        System.out.println("B()::show");
    }
}
