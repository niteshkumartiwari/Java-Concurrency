package intro;

import java.util.function.Predicate;

public class PredicateTest {
    public static void main(String[] args) {
        int[] x={0,5,10,15,20,25,30};
        Predicate<Integer> p=(I)->I%2==0;

        System.out.println(p.test(5));

        Predicate<Integer>p2=(I)->I%10==0;

        //Predicate Joining
        for(int val: x)
            if(p.and(p2).test(val))
                System.out.println(val);
    }
}
