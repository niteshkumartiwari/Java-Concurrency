package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Demo1 {
    public static void main(String[] args) {
        ArrayList<Integer> list= new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        list.add(60);
        list.add(70);
        list.add(80);

        List<Integer> list2=list.stream()
                .filter(i->i%20==0)
                .collect(Collectors.toList());
        System.out.println(list2);

        List<Integer> list3=list.stream()
                .map(i->i+5)
                .collect(Collectors.toList());
        System.out.println(list3);

    }
}
