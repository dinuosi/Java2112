package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

/**
 * 集合转数组
 * Collection定义了方法toArray可以将一个集合转换为一个数组
 */
public class CollectionToArrayDemo {
    public static void main(String[] args) {
        Collection<String> c =new ArrayList<>();
        c.add("one");
        c.add("two");
        c.add("three");
        c.add("four");
        c.add("five");
        System.out.println(c);

        String[] array = c.toArray(new String[0]);
        System.out.println(Arrays.toString(array));
    }
}
