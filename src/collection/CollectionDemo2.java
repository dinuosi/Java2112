package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/**
 * 元素会影响集合操作的相关方法
 */
public class CollectionDemo2 {
    public static void main(String[] args) {
        //Collection c = new ArrayList();
        Collection c = new HashSet();//不可重复的集合
        c.add(new Point(1,2));
        c.add(new Point(1,2));
        c.add(new Point(3,4));
        c.add(new Point(5,6));
        c.add(new Point(7,8));
        c.add(new Point(9,10));
        Point p = new Point(1,2);//重复元素无法放入Set集合两次

        /*
           集合重写了toString方法，格式为:
           [元素1.toString(), 元素2.toString(), 元素3.toString(), ....]
         */
        System.out.println(c);

        /*
            boolean contains(Object o)
            判断当前集合是否包含给定元素。
            元素是否包含取决于该元素是否与集合现有元素存在equals比较为true的情况
         */

        boolean contains = c.contains(p);
        System.out.println("是否包含该元素："+contains);

        /*
            remove方法删除元素时也是删除与集合中equals比较为true的元素。
            注意：对于List而言，由于可以存放重复元素，对这种情况仅会删除一次。
         */
        //c.remove(p);
        System.out.println(c);
    }
}
