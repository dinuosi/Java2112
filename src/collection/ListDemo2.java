package collection;

import java.util.ArrayList;
import java.util.List;

/**
 * List集合提供的方法：
 * List subList(int start,int end)
 * [含头不含尾)
 * 获取当前集合中新置顶范围内的子集。
 */
public class ListDemo2 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        System.out.println(list);
        List<Integer> subList = list.subList(3,8);
        System.out.println(subList);
        for (int i = 0; i < subList.size(); i++) {
            subList.set(i,subList.get(i)*10);
        }
        System.out.println(subList);

        /*
            对子集的操作就是对原集合对应元素的操作
         */
        System.out.println(list);
        list.subList(1,9).clear();
        System.out.println(list);
    }
}
