package intro;

import java.util.function.Function;

public class FunctionTest {
    public static void main(String[] args) {
        Function<Integer,Integer> f=i->i*i;

        System.out.println(f.apply(10));
    }
}
