package singleton;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Driver {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        LazySingleton instance1= LazySingleton.getInstance();
        System.out.println(instance1.hashCode());

        LazySingleton instance2=null;

//        //Breaks when cloned
//        {
//            try {
//                instance2 = (LazySingleton) instance1.clone();
//            } catch (CloneNotSupportedException e) {
//                e.printStackTrace();
//            }
//        }

//        //Breaks with Reflection
//        Constructor[] constructors= LazySingleton.class.getDeclaredConstructors();
//        for(Constructor constructor: constructors){
//            constructor.setAccessible(true);
//            try {
//                instance2= (LazySingleton) constructor.newInstance();
//            } catch (InstantiationException e) {
//                e.printStackTrace();
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            } catch (InvocationTargetException e) {
//                e.printStackTrace();
//            }
//        }


        //Breaks with Deserialization
        ObjectOutput out= new ObjectOutputStream(new FileOutputStream("singleton.ser"));
        out.writeObject(instance1);
        out.close();

        ObjectInput in= new ObjectInputStream(new FileInputStream("singleton.ser"));
        instance2= (LazySingleton)in.readObject();
        in.close();

        System.out.println(instance2.hashCode());
    }
}
