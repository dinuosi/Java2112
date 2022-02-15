package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * 数组转换为List集合
 * 数组的工具类Arrays提供了一个静态方法asList，可以讲一个数组转换为一个List集合
 */
public class ArrayToListDemo {
    public static void main(String[] args) {
        String[] arr = {"one","two","three","four","five"};
        System.out.println("Array:"+Arrays.toString(arr));
        List<String> list = Arrays.asList(arr);
        System.out.println("List"+list);

        //对该集合的操作就是对原数组对应的操作
        list.set(1,"six");
        System.out.println("Array:"+Arrays.toString(arr));
        System.out.println("List"+list);

        List<String> list2 = new ArrayList<>();
        list2.addAll(list);
        System.out.println("list2"+list2);
        list2.add("seven");
        System.out.println("list2"+list2);
    }
}
