package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 集合的遍历
 * Collection层面上不支持随机访问操作(根据指定的位置获取对应的元素)
 * 但是集合支持遍历操作，我们可以通过遍历最终拿到每一个元素。
 *
 * 集合提供了统一的遍历方式：迭代器模式
 * 对应方法：
 * Iterator iterator()
 * 该方法会返回一个用于遍历当前集合元素的迭代器
 * java.util.Iterator是迭代器接口，定义了迭代器遍历集合的基本操作，
 * 所有的集合都提供了一个用于遍历自身元素的迭代器实现类，
 * 我们无需记住他们的名字，用多台的思想将他们统一看做是Iterator即可。
 * 迭代器遍历几个遵循的步骤：问->取->删。其中删除不是必须操作
 */
public class IteratorDemo {
    public static void main(String[] args) {
        Collection c = new ArrayList();
        c.add("one");
        c.add("#");
        c.add("two");
        c.add("#");
        c.add("three");
        c.add("#");
        c.add("four");
        c.add("#");
        c.add("five");
        c.add("#");
        c.add("six");
        System.out.println(c);
        Iterator it = c.iterator();
         /*
            boolean hasNext()
            判断集合是否还有"下一个"元素可以遍历。迭代器的起始位置可以理解为是集合第一个
            元素位置之前。因此第一次调用hasNext()就是判断集合是否有第一个元素。
            E next()
            获取集合中"下一个"元素。获取后迭代器的位置会向后移动一个元素位置
         */
        while(it.hasNext()){
            String e = (String)it.next();
            System.out.println(e);
            if ("#".equals(e)){
                /*
                    迭代器在遍历的过程中不能通过集合的方法增删元素，
                    否则迭代器会抛出并发修改异常：
                    java.util.ConcurrentModificationException
                //c.remove(e);
                 */
                /*
                    迭代器提供了remove方法可以将本词通过next方法获取的元素从集合中删除
                 */
                it.remove();
            }
        }

        System.out.println(c);

    }

}
