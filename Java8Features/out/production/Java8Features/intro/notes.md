Java 8 Features
---------------------
-Concise coding
-Enabling Functional Programming

1.  Lambda Expressions
2.  Functional interface
3.  Default Methods and static methods
4.  Predefined functional interfaces
    Predicate
    Function
    Consumer
    Supplier
    etc
5.  Functions
6.  Double colon Operator(::)
    Methods reference
    Constructor references
7.  Streams
8.  Date and Time API
9.  Optional class
10. Nashorn Javascript Engine

<========================================>

1-Lambda Expressions
Benefits:
    -To Bring benefits of functional programming into java
    
What is LE?
It is a anonymous function
    -nameless
    -without return types
    -without modifiers

eg1.
`public void m(){
    System.out.println("Hello")
}`
``
()->{System.out.println("Hello");}
()->System.out.println("Hello"); //since one line
``

eg2.
``
public void m1(int a,int b){
     System.out.println(a+b);
}
``

(int a,int b)->System.out.println(a+b);

eg3.
public int squareIt(int n){
     return n*n;
}
``
(int n)->{ return n*n; }
(int n)-> n*n;//if only return one liner
(n)-> n*n;//compiler will guess type
n->n*n;//since only one param  
``

eg4.

``
public int m1(String s){
     return s.length();
}
``

s->s.length();


Without curly braces we cannot use return keyword

<=====How to call lambda functions=====>
FI=> Functional Interface

Runnable=>run()
Comparable=>compareTo()
Comparator=>compare()
Callable=>call()

FI which contains(@FunctionalInterface)
SAM=> Single Abstract Method
but can contains anyno. of default and static methods

-annotation is optional to check if it apply FI rules by compiler

job of FI=>To invoke lambda expression

<=====Anonymous Inner Class and Lambda Expressions=======>
AIC=> Class without having name.

AIC can implement many abstract methods but lambda expression can only do one.

<===Functional Interfaces===>
Predicate 
Function
Consumer
Supplier

-Predicate<T>---Boolean
only contains one input argument
only contains one method `test()` returns boolean.

-Predicate Joining
p1.or(p2)
p1.ans(p2).test(34);
p1.negate()

--Function<T,R>--->R type
`
interface Function<T,R>{
    public R apply(T t);
}
`
Function Chaining
first f1 then f2
f1.andThen(f2).apply(i);

first f2 then f1
f1.compose(f2).apply(i);

-- Consumer<T>---->void

--Supplier
Just supply my required objects and it won't take any inputs
`
interface Supplier<R>{
    public R get();
}
`
<=========Method and Constructor Reference===========>
Class::m1;
to provide code reusability
argument types and num. should match
return type doesn't match




