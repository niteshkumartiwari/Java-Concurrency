package intro;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class StreamAndForEach {
    public static void main(String[] args) {
        List<Integer> list= new ArrayList<>();

        for(int i=1;i<=10;i++) list.add(i);

        list.forEach(i-> System.out.print(i+" "));

        System.out.println();
        //stream
        
        list.stream().forEach(i-> System.out.print(i+" "));

        int[] arr={4,1,3,6,7,8,0,1,4};
        System.out.println();
        IntStream.of(arr)
                .distinct()
                .sorted()
                .limit(3)
                .forEach(i-> System.out.print(i+" "));
    }
}
