package collection;

import java.util.*;

/**
 * 排序自定义类型元素
 */
public class SortListDemo2 {
    public static void main(String[] args) {
        List<Point> list = new ArrayList<>();
        list.add(new Point(1,2));
        list.add(new Point(97,88));
        list.add(new Point(7,6));
        list.add(new Point(9,9));
        list.add(new Point(5,4));
        list.add(new Point(2,3));
        System.out.println(list);
        /*
            Collection.sort(List list)在排序List集合时要求集合元素必须实现了Comparable接口。
            实现了该接口的类必须重写一个方法compareTo用于定义比较大小的规则，从而进行元素间的比较后排序。否则编译不通过。

            侵入性：
            当我们调用某个API时，其反过来要求我们为其修改其他额外的代码，这种现象就称为侵入性。
            侵入性不利于程序后期的维护，尽可能避免
         */
        //Collections.sort(list);


        /**
         * 实现比较器接口后必须重写方法compare.
         * 该方法用来定义参数o1与参数o2的比较大小规则
         * 返回值用来表示o1与o2的大小关系
         */Collections.sort(list, (o1, o2) -> o1.getX()* o1.getX()+ o1.getY()*o1.getY()-o2.getX()* o2.getX()- o2.getY()*o2.getY());
        System.out.println(list);

    }
}




