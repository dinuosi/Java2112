package collection;

import java.util.ArrayList;
import java.util.List;

/**
 * java.util.List接口
 * List继承自Collection，是最常用的一类集合。特点：可以存放重复元素且有序。
 * List里提供了一套哦可以通过下标操作元素的方法。
 * 常用实现类：
 * java.util.ArrayList:内部使用数组实现，查询性能更好。
 * java.util.LinkedList:内部使用链表实现，增删性能更好，收尾增删性能最佳。
 * 对性能没有特别苛刻的要求下，通常使用ArrayList即可。
 */
public class ListDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");
        System.out.println(list);

        //获取第三个元素
        /*
            E get(int index)
            获取指定下标处对应的元素
         */
        String str = list.get(2);//与数组获取元素功能一致，String str = arr[2];
        System.out.println(str);
        //List也可以通过循环下标的方式遍历
        for(int i = 0;i< list.size();i++){
            str = list.get(i);
            System.out.println(str);
        }

        /*
            E set(int index,E e)
            将给定元素设置到指定位置上，返回值为该位置原来的元素
         */
        String old = list.set(2,"six");
        System.out.println(old);
        System.out.println(list);

        /*
            在不创建新集合的前提下，将集合元素反转
         */
        for (int i = 0;i< list.size()/2;i++) {
            list.set(i,list.set(list.size()-i-1, list.get(i)));
        }
        System.out.println(list);

    }
}























