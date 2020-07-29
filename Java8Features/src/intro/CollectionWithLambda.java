package intro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CollectionWithLambda {
    public static void main(String[] args) {
        ArrayList l= new ArrayList();
        l.add(20);
        l.add(10);
        l.add(-90);
        l.add(45);
        l.add(100);
        l.add(74);

        System.out.println(l);
        Comparator<Integer> c= (I1,I2)->{
            if(I1<I2) return -1;
            if(I1>I2) return 1;
            return 0;
        };
        Collections.sort(l,c);
        System.out.println(l);
    }
}
