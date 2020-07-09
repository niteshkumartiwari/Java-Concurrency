package TestConcurrentModificationException;

/*
Java.util.ConcurrentModificationException is a very common exception when working with Java collection classes.
Java Collection classes are fail-fast, which means if the Collection will be changed while some thread is
traversing over it using iterator, the iterator.next() will throw ConcurrentModificationException.
Concurrent modification exception can come in case of multithreaded as well as a single threaded java
programming environment.

To Avoid ConcurrentModificationException in multi-threaded environment
->You can convert the list to an array and then iterate on the array. This approach works well for small or
medium size list but if the list is large then it will affect the performance a lot.
->You can lock the list while iterating by putting it in a synchronized block. This approach is not recommended
because it will cease the benefits of multithreading.
->If you are using JDK1.5 or higher then you can use ConcurrentHashMap and CopyOnWriteArrayList classes.
This is the recommended approach to avoid concurrent modification exception.
 */

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class Driver {
    public static void main(String[] args) {
        List<String> list= new CopyOnWriteArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");

//        Iterator<String> itr= list.iterator();
//
//        while(itr.hasNext()){
//            String tmp= itr.next();
//            System.out.println("List Value: "+ tmp);
//            if(tmp.equals("3")){
//                list.remove(tmp);
//            }
//        }
//        System.out.println("List Size:" + list.size());
        for(int i = 0; i<list.size(); i++){
            System.out.println(list.get(i));
            if(list.get(i).equals("3")){
                list.remove(i);
                i--;
                list.add("6");
            }
        }
        System.out.println("List Size:" + list.size());

        //Now not deleting
            Map<String,String> myMap= new ConcurrentHashMap<>();
        myMap.put("1","1");
        myMap.put("2","2");
        myMap.put("3","3");

        Iterator<String> itr2= myMap.keySet().iterator();

        while(itr2.hasNext()){
            String key= itr2.next();
            System.out.println("Map val: "+myMap.get(key));
            if(key.equals("1")){
//                myMap.put("1","4");
                myMap.remove("3");
                myMap.put("4", "4");
                myMap.put("5", "5");
            }
        }

        System.out.println("Map Size:" + myMap.size());
    }
}
